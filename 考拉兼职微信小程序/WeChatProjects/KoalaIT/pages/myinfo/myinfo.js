var app = getApp();
Page({

  //  页面的初始数据
  data: {
    isShow: false, //是否拿到用户信息，否则显示默认头像
    //myself: ''
    faceImg: "", // 头像
    user: false, // 是否显示注册/登录或者用户名
    username: "", // 判断是否是登录状态，
    usersetting: true, //    退出当前账户
    img_url: "/icons/face.png"
  },

  onLoad: function(options) {
    var that = this; //存储当前页面地址，方便调用
    //页面初始化 options为页面跳转所带来的参数
    this.setData({
      user_id: app.globalData.user_id
    });
    // if (options.boss_id == undefined) {
    //   return;
    // }
    wx.request({
      url: 'http://localhost:8080/koalauser/myinfo',
      data: {
        "user_id": app.globalData.user_id
      },
      method: 'GET',
      success: function(res) {
        var userlist = res.data.userList;
        if (userlist == undefined) {

        } else {
          that.setData({
            img_url: userlist.img_url,
            username: userlist.user_name,
            user: true,
            usersetting: false
          });
          console.log("登录状态");
        }

      },

    })
  },

  onShow: function() {
    this.onLoad()
  },

  //登录
  login: function() {
    wx.navigateTo({
      url: '../login/login',
    })
  },

  //我的简历
  resumeTap: function() {
    wx.navigateTo({
      url: '../resume/resume',
    })
  },

  //修改个人信息
  updMyInfoTap: function() {
    wx.navigateTo({
      url: '../updmyinfo/updmyinfo',
    })
  },

  //我的投递
  orderInfoTap: function() {
    wx.navigateTo({
      url: '../orderinfo/orderinfo',
    })

  },

  //预约我的
  orderedInfoTap: function() {
    wx.navigateTo({
      url: '../orderedinfo/orderedinfo',
    })

  },

  //我发布的
  publishTap: function() {
    wx.navigateTo({
      url: '../publish/publish',
    })

  },

  //退出
  exitTap: function() {
    getApp().globalData.user_id = "";
    wx.reLaunch({ 
      url: '../myinfo/myinfo',
    })
  }


})