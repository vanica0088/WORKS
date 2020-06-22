Page({

  /**
   * 页面的初始数据
   */
  data: {
    hunterlist: [],
    user_id: '',
    scroll_height: 0,
    // 轮播图
    background: [
      'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1577340607710&di=6b4ac58d3e84852b38b7e216f7b77644&imgtype=0&src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20180802%2F7cc041f9031d4d26b56374c0f48bf842.gif'
    ],
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
    var that = this;//之后的this不再指整个页面
    wx.request({
      url: 'http://localhost:8080/koalahunter/findhunter',
      method: 'GET',
      data: {},
      success: function (res) {
        var hunterlist = res.data.areaHunterList;
        if (hunterlist == null) {
          var toastText = "获取数据失败" + res.data.errMsg;
          wx.showToast({
            title: 'toastText',
            icon: '',
            duration: 2000
          });
        } else {
          that.setData({
            hunterlist: hunterlist
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

  },


})