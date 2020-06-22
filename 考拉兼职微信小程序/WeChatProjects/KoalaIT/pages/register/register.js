Page({

  /**
   * 页面的初始数据
   */
  data: {

  },


  register: function (e) {
    var that = this;
    var formData = e.detail.value;

    wx.request({
      url: 'http://localhost:8080/koalauser/register',
      data: JSON.stringify(formData),//表单值转换
      method: 'POST',
      header: {
        'Content-Type': 'application/json'
      },
      success: function (res) {
        var result = res.data.success;
        var toastText = "注册成功!";
        if (result == false) {
          toastText = "注册失败" + res.data.errMsg;
        }

        wx.showToast({
          title: toastText,
          icon: '',
          duration: 2000
        });

        if (result != undefined) {
          wx.navigateTo({
            url: '../login/login'
          })
        }
      }

    })
  },





  denglu: function () {
    wx.navigateTo({
      url: '../login/login',
    })
  },



})