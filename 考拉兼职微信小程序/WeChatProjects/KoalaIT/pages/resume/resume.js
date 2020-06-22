var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
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
  onLoad: function () {

    var that = this;//存储当前页面地址，方便调用
    that.setData({
      user_id: app.globalData.user_id
    });
    //页面初始化 options为页面跳转所带来的参数

    wx.request({
      url: 'http://localhost:8080/koalaresume/getresume',
      data: { "resume_id": that.data.user_id },
      method: 'GET',
      success: function (res) {
        var resume = res.data.resumeList;
        if (resume == undefined) {
         
        } else {
          that.setData({

            name: resume.name,
            phone: resume.phone,
            email: resume.email,
            self_introduction: resume.self_introduction

          })

        }
      },
    })
  },




  //姓名
  // nameTap: function (e) {
  //     var eValue = e.detail.value;

  // },
  // 姓名获取焦点
  namefocus: function (e) {
    this.setData({
      user: ""
    })
  },
  //姓名失去焦点
  nameblur: function (e) {
    this.setData({
      user: "输入您的姓名",
      userName: e.detail.value
    })
  },

  //性别
  bindPickerChangeSex: function (e) {
    this.setData({
      genderindex: e.detail.value
    })
  },

  //出生日期
  bindDateChangeBirthday: function (e) {
    this.setData({
      birthday: e.detail.value
    })
  },

  //城市
  bindPickerChangeCity: function (e) {
    this.setData({
      cityindex: e.detail.value
    })
  },

  //联系电话
  contactTap: function (e) {

    // if (window.event) {
    //   e = window.event;
    //   e.returnValue = false; //取消默认事件  
    // } else
    //   e.preventDefault();    //取消默认事件  
  },
  // 电话获取焦点
  phonefocus: function (e) {
    this.setData({
      userphone: ""
    })
  },
  //电话失去焦点
  phoneblur: function (e) {
    this.setData({
      userphone: "输入您的电话",
      contact: e.detail.value
    });
  },

  //联系邮箱
  // emailTap: function(e){
  //   this.setData({ 

  //   })
  // }, 
  // 邮箱获取焦点
  emailfocus: function (e) {
    this.setData({
      useremail: ""
    })
  },
  //邮箱失去焦点
  emailblur: function (e) {
    this.setData({
      useremail: "输入您的邮箱",
      email: e.detail.value
    })
  },
  //学历
  bindPickerChangeEduLevel: function (e) {
    this.setData({
      eduindex: e.detail.value
    })
  },






  //提交
  formSubmit: function (e) {
    var that = this;
    var formData = e.detail.value;
    formData.education = that.data.edu[formData.eduindex];

    // this.setResumeBaseInfoFun(e);
    if ((formData.name == "") || (formData.phone == "") || (formData.email == "")) {
      wx.showModal({
        title: "程序猿提示您",
        content: "请填写完整信息"
      });
    }
    //else if (formData.name || formData.phone || formData.email) {
    // if (new Date().getFullYear() < this.data.birthday.substring(0, 4)) {
    //   wx.showModal({
    //     title: "程序猿提示您",
    //     content: "请填写真实出生时间"
    //   });
    //   // if (new Date().getMonth() < this.data.birthday.substring(5, 7)) {
    //   //   wx.showModal({
    //   //     title: "程序猿提示您",
    //   //     content: "请填写真实出生时间"
    //   //   });
    //   // }
    // } 
    else if (!(/^1(3|4|5|7|8)\d{9}$/.test(formData.phone))) {
      wx.showModal({
        title: "程序猿提示您",
        content: "手机号码格式不对！"
      });
    } else if (!/^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/.test(formData.email)) {
      wx.showModal({
        title: "程序猿提示您",
        content: "邮箱格式不对！"
      });
    } else {

      var that = this;
      var formData = e.detail.value;
      formData.resume_id = app.globalData.user_id;
      formData.user_id = app.globalData.user_id;

      wx.request({
        url: that.data.url,//对resume表修改值

        data: JSON.stringify(formData),//表单值转换

        method: 'POST',
        header: {
          'Content-Type': 'application/json'
        },
        success: function (res) {
          var result = res.data.success;
          var toastText = '提交成功！';
          if (result != true) {
            toastText = "操作失败,丢人！";
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
      });
      wx.request({

        url: "http://localhost:8080/koalauser/updresume",//对user表插入resume_id值
        data: {
          "user_id": app.globalData.user_id,
          "resume_id": app.globalData.user_id
        },//表单值转换
        method: 'POST',
        header: {
          'Content-Type': 'application/json'
        },
        success: function (res) {
          var result = res.data.success;
          var toastText = '提交成功！';
          if (result != true) {
            toastText = "操作失败,丢人！";
          }
          wx.showToast({
            title: toastText,
            icon: '',
            duration: 2000
          });
          if (toastText == "提交成功！") {
            wx.switchTab({
              url: '../myinfo/myinfo'
            })
          }

        }

      })

      // wx.showToast({
      //   title: '提交成功！请等待对方联系您(*^▽^*)',
      //   icon: 'success',
      //   duration: 500 
      // })
      this.setResumeBaseInfoFun();
      //更新上一级页面
      var pages = getCurrentPages();
      var curPage = pages[pages.length - 2];
      curPage.setData({
        resumeBaseInfo: this.data
      });
    }

  },



  //返回首页
  backIndewx: function () {
    wx.switchTab({    // 跳转到**页面并且关闭其他页面
      url: '/pages/findboss/findboss',
    })
  }

})