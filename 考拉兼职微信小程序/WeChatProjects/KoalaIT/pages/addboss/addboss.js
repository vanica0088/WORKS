// pages/addboss/addboss.js
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    boss_title: "",
    boss_detail: "描述 背景 目的",
    limited_time: "",
    Price: "元"

  },



  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;//存储当前页面地址，方便调
    that.setData({
      user_id: app.globalData.user_id
    });
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
  /**
 * 提交后处理
 */
  formSubmit: function (e) {//e:表单传来的值
    var that = this;
    var formData = e.detail.value;


    formData.user_id = app.globalData.user_id;//传值时多加boss_id值
    formData.checkstate = 1;


    wx.request({
      url: 'http://localhost:8080/koalaboss/addboss',
      data: JSON.stringify(formData),//表单值转换
      method: 'POST',
      header: {
        'Content-Type': 'application/json'
      },
      success: function (res) {
        var result = res.data.success;
        var toastText = "操作成功!";
        if (result != true) {
          toastText = "操作失败" + res.data.errMsg;
        }
        wx.showToast({
          title: toastText,
          icon: '',
          duration: 2000
        });

        // if (that.data.boss_id == undefined) {
        //   wx.redirectTo({
        //     url: '../list/list',
        //   })
        // }
      }
    })
  },
})