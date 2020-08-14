var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    index: '',
    boss_id: '',
    resume_id: '',
    name: '',//姓名
    phone: '',//联系电话
    email: '',//联系邮箱
    self_introduction: '',//个人简介
    user: "输入您的姓名",    // 姓名placeholder
    userphone: "输入您的电话",
    useremail: "输入您的邮箱",
    userintro: "工作经验 技术能力",
    edu: ['高中', '大专', '本科', '硕士', '博士'],//学历
    eduindex: 2,//默认本科
    addUrl: "http://localhost:8080/koalaresume/addresume",
    url: "http://localhost:8080/koalaresume/updresume"
  },

  /*
   生命周期函数--监听页面加载
   */
  onLoad: function (options) {

    var that = this;//存储当前页面地址，方便调用
    that.setData({
      boss_id: options.boss_id,

    });
    //页面初始化 options为页面跳转所带来的参数
    that.setData({
      user_name: options.user_name,
      //boss_id:options.boss_id
    });
    wx.request({
      url: 'http://localhost:8080/koalaresume/orderresume',
      data: { "user_name": that.data.user_name },
      method: 'GET',
      success: function (res) {
        var resume = res.data.resumeList;
        if (resume == undefined) {
          var toastText = "获取数据失败" + res.data.errMsg;
          that.data.url = that.data.addUrl;
          wx.showToast({
            title: toastText,
            icon: '',
            duration: 2000
          });
        } else {
          that.setData({
            resume_id: resume.resume_id,
            name: resume.name,
            phone: resume.phone,
            email: resume.email,
            self_introduction: resume.self_introduction

          })

        }
      },
    })
  },










  //同意
  formSubmit: function (e) {
    var that = this;
    var formData = e.detail.value;
    formData.education = that.data.edu[formData.eduindex];
    formData.boss_id = that.data.boss_id;;
    formData.user_id = that.data.resume_id;
    if (formData.index == '1') {
      formData.check = 1;
      formData.orderhunter = that.data.resume_id;
      wx.request({
        url: 'http://localhost:8080/koalaboss/order',
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
    } else {
      formData.check = 2;
    }

    wx.request({
      url: 'http://localhost:8080/bossconnect/yescheck',
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

      }



    })
  },








})