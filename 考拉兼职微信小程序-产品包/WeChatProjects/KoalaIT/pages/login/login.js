var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    user_name: '',
    password: ''
  },

  zhuce:function(){
    wx.navigateTo({
      url: '../register/register',
    })
  },

  userinfoSubmit: function (e) {//e:表单传来的值
    var that = this;
    var formData = e.detail.value;

    wx.request({
      url: 'http://localhost:8080/koalauser/login',
      data: JSON.stringify(formData),//表单值转换
      method: 'POST',
      header: {
        'Content-Type': 'application/json'
      },
      success: function (res) {
        var result = res.data.success;
        var toastText = "登录成功!";
        if (result == undefined) {
          toastText = "登录失败" ;
        }
        getApp().globalData.user_id = result;
        var getAppInfo = app.globalData.user_id;
        console.log(getAppInfo)
        wx.showToast({
          title: toastText,
          icon: '',
          duration: 2000
        });

        if (result != undefined) {
          wx.switchTab({
            url: '../myinfo/myinfo'
          })
        }
      }

    })
  },

 
})