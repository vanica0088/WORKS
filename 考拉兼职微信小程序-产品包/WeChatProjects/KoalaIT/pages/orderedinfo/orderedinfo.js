var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {

    boss_id: '',
    user_id: '',
    boss_title: '',
    user_name: '',
    orderhunter: '',
    infoList: [],
    state: '未判断',
    hunterlist: [],
    scroll_height: 0,

    select: false,
    selected: true,
  },

  select: function (e) {
    if ('w' == e.currentTarget.dataset.w) {
      this.setData({
        select: false,
        selected: true,
      })
    }
    else if ('y' == e.currentTarget.dataset.y) {
      this.setData({
        select: true,
        selected: false,
      })
    }
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function () {
    var that = this;
    that.setData({
      user_id: app.globalData.user_id
    });
    let windowHeight = wx.getSystemInfoSync().windowHeight // 屏幕的高度
    let windowWidth = wx.getSystemInfoSync().windowWidth // 屏幕的宽度
    this.setData({
      scroll_height: windowHeight * 750 / windowWidth
    });
    wx.request({
      url: 'http://localhost:8080/bossconnect/getorder',
      data: { "user_id": that.data.user_id },
      method: 'GET',

      success: function (res) {
        var infoList = res.data.infoList;
        if (infoList == null) {
          var toastText = "获取数据失败" + res.data.errMsg;
          wx.showToast({
            title: 'toastText',
            icon: '',
            duration: 2000
          });
        } else {
          that.setData({
            boss_id: infoList.boss_id,
            infoList: infoList,
            user_name: infoList.user_name,
            boss_title: infoList.boss_title,
            price: infoList.price
          });
      
        }
      }
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
    var that = this;
    that.setData({
      user_id: app.globalData.user_id
    });
    let windowHeight = wx.getSystemInfoSync().windowHeight // 屏幕的高度
    let windowWidth = wx.getSystemInfoSync().windowWidth // 屏幕的宽度
    this.setData({
      scroll_height: windowHeight * 750 / windowWidth
    });
    wx.request({
      url: 'http://localhost:8080/hunterconnect/getorder',
      data: { "user_id": that.data.user_id },
      method: 'GET',

      success: function (res) {
        var hunterlist = res.data.hunterlist;
        if (hunterlist == null) {
          var toastText = "获取数据失败" + res.data.errMsg;
          wx.showToast({
            title: 'toastText',
            icon: '',
            duration: 2000
          });
        } else {
          that.setData({
            hunter_id: hunterlist.hunter_id,
            infoList: hunterlist,
            user_name: hunterlist.user_name,
            hunter_title: hunterlist.hunter_title,
            salary: hunterlist.salary
          });
        }
      }
    });

    that.onLoad()

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



})