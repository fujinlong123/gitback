const sun = require("sun.js")
const wxPromisify = require("wxPromisify.js")
const dao = {};

dao.addOrUpdateProduct = function (obj) {
  sun.request({
    data: obj.product,
    url: 'addOrUpdateProduct'
  }).then(function (res) {
    sun.simpleShowToast("保存成功");
  }).catch(function (res) {
    sun.simpleShowToast("保存失败");
  });
}

dao.getProductByCode = wxPromisify(function (obj) {
  sun.request({
    data: { storeId: obj.storeId, code: obj.code },
    url: 'getProductByCode'
  })
    .then(obj.success)
    .catch(obj.fail);
});


dao.getProductList = wxPromisify(function (options) {
  if (!options.endId) {
    options.endId = "";
  }
  sun.request({
    data: { storeId: options.storeId, endId: options.endId },
    url: 'getProductList'
  }).then(function (result) {
    options.success(result);
  }).catch(function (result) {
    options.fail(result);
  });
});



module.exports = dao