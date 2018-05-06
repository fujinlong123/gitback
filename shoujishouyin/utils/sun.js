const config = require("config.js")
const wxPromisify = require("wxPromisify.js")
const data = {};
const sun = {};


sun.getSessionId = function () {
  if (data.sessionId) {
    return data.sessionId;
  } else {
    data.sessionId = wx.getStorageSync("sessionId");
    return data.sessionId;
  }
}

sun.setSessionId = function (sessionId) {
  wx.setStorageSync("sessionId", sessionId);
  data.sessionId = sessionId;
}



sun._loginError = function (msg, callback) {
  wx.showToast({
    icon: 'warn',
    title: msg,
    complete: function () {
      if (typeof callback === 'function') {
        callback();
      }
    }
  });
}


sun._loginSuccess = function (callback) {
  if (callback) {
    callback();
  }
}

sun.login = function (options) {
  var options = options || {};
  wx.login({
    success: res => {
      // 发送 res.code 到后台换取 openId, sessionKey, unionId
      console.log("接口基地址：" + config.baseServerUrl());
      if (res.code) {
        wx.request({
          url: config.baseServerUrl() + "/weixin/onLogin2",
          data: {
            code: res.code,
            sessionId: sun.getSessionId()
          },
          success: function (res) {
            if (res.data) {
              var result = res.data;
              if (result.ret == 'success') {
                sun.setSessionId(result.sessionId);
                sun._loginSuccess(options.success);
              } else {
                sun._loginError("登录失败,请稍候再试", options.fail);
              }
            } else {
              sun._loginError("服务器异常,请稍候再试", options.fail);
            }
          },
          fail: function (res) {
            sun._loginError("微信登录失败,请稍候再试", options.fail);
          }
        })
      } else {
        sun._loginError('微信登录失败,请稍候再试', options.fail);
      }
    }
  })
}


sun.loadSessionData = wxPromisify(function (options) {
  sun.request({
    url: "loadSessionData"
  }).then(function (result) {
    var sessionId = sun.getSessionId();
    var sessionData = {};
    sessionData[sessionId] = result.data;
    wx.setStorageSync("sessionData", sessionData);
    options.success(result);
  }).catch(function (result) {
    options.fail(result);
  });
});



sun.reportUserInfo = function () {
  // 获取用户信息
  wx.getSetting({
    success: res => {
      if (!res.authSetting['scope.userInfo']) {
        wx.authorize({
          scope: 'scope.userInfo',
          success() {
            // 用户已经同意小程序使用录音功能，后续调用 wx.startRecord 接口不会弹窗询问
          }
        })
      }

      if (res.authSetting['scope.userInfo']) {
        // 已经授权，可以直接调用 getUserInfo 获取头像昵称，不会弹框
        wx.getUserInfo({
          success: res => {
            // 可以将 res 发送给后台解码出 unionId
            console.log(res.userInfo);
            var app = getApp();
            app.globalData.userInfo = res.userInfo
            // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
            // 所以此处加入 callback 以防止这种情况
            if (this.userInfoReadyCallback) {
              this.userInfoReadyCallback(res)
            }
          }
        })
      }
    }
  })
};







var request = wxPromisify(wx.request);





//封装wx.request 使得每次请求参数都会带上sessionId
sun.request = wxPromisify(function (options) {
  options.data = options.data || {};
  options.data.sessionId = sun.getSessionId();
  if (options.url) {
    if (options.url.indexOf("http") != 0) {
      options.url = config.baseServerUrl() + "/" + options.url;
    }
  }
  var method = options.method || "GET";
  var success = options.success;
  var fail = options.fail;

  request(options).then(function (res) {
    if (res.data && res.statusCode == 200) {
      var result = res.data;
      if (result.ret == "success") {
        success(result);
      } else if (result.ret == "fail") {
        if (result.code == "noLogin") {//未登录，重新发起登录，并重新请求
          sun.login({
            success: function () {
              sun.request(options);
            }
          });
        } else {
          fail(result);
        }
      }
    } else {
      console.log("调用接口失败,http状态码不对：", res);
      wx.showToast({
        title: '网络异常:' + res.statusCode,
      })
    }

  }).catch(function (res) {
    console.log("调用接口失败：", res);
    wx.showToast({
      title: '网络异常',
    })
  });

});




sun.simpleShowToast = function (msg) {
  wx.showToast({
    title: msg
  })
}

sun.getStoreId = function () {
  return sun.getSessionData().storeId;
}

sun.getStoreName = function () {
  return sun.getSessionData().storeName;
}

sun.getSessionData = function (options) {
  var sessionId = sun.getSessionId();
  if (!data.sessionData) {
    data.sessionData = wx.getStorageSync("sessionData");
  }
  return data.sessionData[sessionId];
}



module.exports = sun