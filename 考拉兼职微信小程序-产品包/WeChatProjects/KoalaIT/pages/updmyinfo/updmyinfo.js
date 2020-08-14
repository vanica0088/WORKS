
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    img_url: '', //头像
    user_name: '',//用户名
    password: '',//密码
    sex: ['男', '女'],//性别
    sexindex: 0,//性别index
    birthday: '1990-01-01',//出生日期
    user_id: '',//用户ID

    // 省市区三级联动初始化
    region: ["湖北省", "武汉市", "洪山区"],

  },

  // 选择省市区函数
  changeRegin(e) {
    this.setData({ region: e.detail.value });
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;//存储当前页面地址，方便调用
    //页面初始化 options为页面跳转所带来的参数
    that.setData({
      user_id: app.globalData.user_id,

    });

    wx.request({
      url: 'http://localhost:8080/koalauser/myinfo',
      data: { "user_id": that.data.user_id },
      method: 'GET',
      success: function (res) {
        var userList = res.data.userList;
        if (userList == undefined) {
          var toastText = "获取数据失败" + res.data.errMsg;
          wx.showToast({
            title: toastText,
            icon: '',
            duration: 2000
          });
        } else {
          that.setData({
            img_url: userList.img_url,
            user_name: userList.user_name,
            password: userList.password,
            region: userList.region.split("-")
            // sex: userList.sex,
            // bithday: userList.birthday
          })
        }
      },
    })
  },


  //上传图片
  uploadImgTap: function () {
    var that = this;
    wx.chooseImage({
      count: 1, // 默认9
      sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
      sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
      success: function (res) {
        // 返回选定照片的本地文件路径列表，tempFilePath可以作为img标签的src属性显示图片
        var tempFilePaths = res.tempFilePaths
        that.setData({
          img_url: tempFilePaths
        })
      }
    })
  },
  /**
 * 提交后处理
 */
  formSubmit: function (e) {//e:表单传来的值
    var that = this;
    var formData = e.detail.value;
    var a = formData.region.join("-");
    formData.img_url = that.data.img_url;
    formData.user_id = that.data.user_id;
    formData.region = a;
    wx.request({
      url: 'http://localhost:8080/koalauser/updmyinfo',
      data: JSON.stringify(formData),//表单值转换
      method: 'POST',
      header: {
        'Content-Type': 'application/json'
      },
      success: function (res) {
        var result = res.data.success;
        var toastText = "修改成功!";
        if (result != true) {
          toastText = "修改失败" + res.data.errMsg;
        }
        wx.showToast({
          title: toastText,
          icon: '',
          duration: 2000
        });

        if (toastText == "修改成功!") {
          wx.switchTab({
            url: '../myinfo/myinfo'
          })
        }
      }

    })
  },

})