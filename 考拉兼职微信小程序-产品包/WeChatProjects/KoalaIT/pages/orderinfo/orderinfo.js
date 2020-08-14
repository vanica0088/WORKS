var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    user_id: '',
    bosslist: [],
    hunterlist: [],
    state: '未同意',
    scroll_height: 0,

    select:false,
    selected:true,
  },

  select:function(e){
    if('w'==e.currentTarget.dataset.w){
      this.setData({
        select:false,
        selected:true,
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
      url: 'http://localhost:8080/koalaboss/orderhunter',
      data: { "user_id": that.data.user_id },
      method: 'GET',

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
          if (bosslist.check == 1) {
            that.setData({
              state: '已同意'
            });
          }

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
      url: 'http://localhost:8080/koalahunter/orderboss',
      data: { "user_id": that.data.user_id },
      method: 'GET',

      success: function (res) {
        var hunterlist = res.data.areaHunterList;
        if (hunterlist == null) {
          var toastText = "获取数据失败" + res.data.errMsg;
          wx.showToast({
            title: toastText,
            icon: '',
            duration: 2000
          });
        } else {
          that.setData({
            hunterlist: hunterlist
          });
        }
        if (hunterlist.check == 1) {
          that.setData({
            state: '已同意'
          });
        }
      }
    })


  },
 


})