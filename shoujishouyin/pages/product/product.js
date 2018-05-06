const config = require('../../utils/config.js')
const sun = require('../../utils/sun.js')
const dao = require('../../utils/dao.js')
// pages/product/product.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    inputShowed: false,
    inputVal: '',
    modelHeight: 0,

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

    this.productList = this.selectComponent("#prouctListComp");
    this.getProductList();
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

  showInput: function () {

    this.setData({
      inputShowed: true
    });
  },
  hideInput: function () {
    this.setData({
      inputVal: "",
      inputShowed: false
    });
  },
  clearInput: function () {
    this.setData({
      inputVal: ""
    });
  },
  inputTyping: function (e) {

    this.setData({
      inputVal: e.detail.value
    });
  }
  , add() {
    wx.navigateTo({
      url: '/pages/addProduct/index',
    })
  },
  add1() {
    wx.navigateTo({
      url: '/pages/addProduct1/index',
    })
  },

  
  getProductList: function () {
    var me = this;
    dao.getProductList({
      storeId: sun.getStoreId(),
      endId: this.data.endId
    })
      .then(function (result) {
        var data=result.data;
        data.productList.forEach(function (item) {
          me.productList.addItem(item);
        });
        if (data.productList.length) {
          var endId = data.productList[data.productList.length - 1].id;
          me.setData({ endId: endId });
        }
      }).catch(function (res) {
        console.log(res);
      });
  },



  productListScroll: function (event) {

  },

  productListscrolltolower: function (event) {
    this.getProductList()
  }
})