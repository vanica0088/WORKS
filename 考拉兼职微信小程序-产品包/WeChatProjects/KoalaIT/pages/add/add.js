
Page({

  /**
   * 页面的初始数据
   */
  data: {
    // 轮播图
    background: [
      'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1577341481348&di=1d010400aa5ca3e5faa3c211b4fd5c68&imgtype=jpg&src=http%3A%2F%2Fimg.mp.itc.cn%2Fupload%2F20170529%2F4e280c03240f4fd89cbace7d6d06916f_th.jpg'
    ],

  },

  addboss:function(){
    wx.navigateTo({
      url: '../addboss/addboss',
    })
  },

  addhunter:function(){
    wx.navigateTo({
      url: '../addhunter/addhunter',
    })
  }

})