var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    bosslist: [],
    scroll_height: 0,
  },


  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function () {
    let windowHeight = wx.getSystemInfoSync().windowHeight // 屏幕的高度
    let windowWidth = wx.getSystemInfoSync().windowWidth // 屏幕的宽度
    this.setData({
      scroll_height: windowHeight * 750 / windowWidth
    })

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

  catchTap: function () {
    wx.navigateTo({
      url: '../bossdetail/bossdetail?boss_id={{item.boss_id}}',
    })
  },

userinfoSubmit:function(e){
  var that = this;//之后的this不再指整个页面
  var formData = e.detail.value;
  wx.request({
    url: 'http://localhost:8080/koalaboss/searchboss',
    method: 'GET',
    data: { "boss_title": '%' + formData.boss_title + '%' },
    success: function (res) {
      var bosslist = res.data.areaBossList;
      if (bosslist == null) {
        var toastText = "获取数据失败" + res.data.errMsg;
        wx.showToast({
          title: 'toastText',
          icon: '',
          duration: 2000
        });
      } else {
        that.setData({
          bosslist: bosslist
        });
      }
    }
  })
}


})