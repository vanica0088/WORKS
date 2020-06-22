var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    bosslist: [],
    scroll_height: 0,

    // 轮播图
    background: ['https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1577338591157&di=0d5c52d7a5ee4d2b30a928aa30b4606f&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201512%2F01%2F20151201193307_TrGkv.png', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1577255291627&di=f78d7318b1d8726fd31114e917cf57a7&imgtype=0&src=http%3A%2F%2Fupload.art.ifeng.com%2F2015%2F1010%2F1444471301223.png', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3764843150,694550881&fm=26&gp=0.jpg'],
    interval: 3000,
    duration: 500,
    previousMargin: 0,
    nextMargin: 0

  },



  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function() {
    let windowHeight = wx.getSystemInfoSync().windowHeight // 屏幕的高度
    let windowWidth = wx.getSystemInfoSync().windowWidth // 屏幕的宽度
    this.setData({
      scroll_height: windowHeight * 750 / windowWidth
    })


  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    // var getAppInfo = app.globalData.user_id;
    // console.log(getAppInfo)
    var that = this;//之后的this不再指整个页面
    wx.request({
      url: 'http://localhost:8080/koalaboss/findboss',
      method: 'GET',
      data: {},
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


  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function() {

  }
})