// packages/product-list/dist/index.js
Component({
  /**
   * 组件的属性列表
   */
  properties: {

  },

  /**
   * 组件的初始数据
   */
  data: {
    list: [],
  },




  /**
   * 组件的方法列表
   */
  methods: {
    deleteTap(res) {
      this.setData({ deleteIndex: res.detail.index });
      this.showDialog();

    },
    editTap(res) {
      this.showPopup();

    },
    showPopup() {
      let popupComponent = this.selectComponent('.J_Popup');
      popupComponent && popupComponent.show();
    },
    hidePopup() {
      let popupComponent = this.selectComponent('.J_Popup');
      popupComponent && popupComponent.hide();
    },
    addItem(item){
      this.setData({ list: this.data.list.concat(item)});
    }

  }
})
