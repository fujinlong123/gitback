// pages/addProduct/index.js
const sun = require("../../utils/sun.js")
const dao = require("../../utils/dao.js")
Page({

  /**
   * 页面的初始数据
   */
  data: {
    code: "",
    scanType: "",
    storeId: "",
    name: "",
    price: null,
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({ storeId: sun.getStoreId() });
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },
  scanCode: function () {
    var me = this;
    wx.scanCode({
      success: function (res) {
        me.setData({ "code": res.result });
        dao.getProductByCode({ code: me.data.code, storeId: sun.getStoreId()})
          .then(function (result) {
            me.setData({ name: result.data.product.name });
            me.setData({ price: result.data.product.price });
          });
      },
      fail: function (res) {
        sun.simpleShowToast('扫码失败');
      }
    })
  },
  save: function () {
    if (!this.data.code) {
      sun.simpleShowToast('条形码不能为空');
      return;
    }
    if (!this.data.name) {
      sun.simpleShowToast('商品名称不能为空');
      return;
    }
    if (!this.data.price) {
      sun.simpleShowToast('价格不能为空');
      return;
    }


    var product = {};
    product.code = this.data.code;
    product.name = this.data.name;
    product.price = this.data.price;
    product.storeId = this.data.storeId;
    dao.addOrUpdateProduct({ product: product });



  },
  codeInput: function (e) {
    this.setData({
      code: e.detail.value
    })
  },
  nameInput: function (e) {
    this.setData({
      name: e.detail.value
    })
  },
  priceInput: function (e) {
    this.setData({
      price: e.detail.value
    })
  }
})