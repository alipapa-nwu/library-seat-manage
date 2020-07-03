// app.js

App({
  onLaunch: function () {
    wx.getStorage({
      key: 'userInfo',
      success: res=>{
        this.globalData.userInfo = res.data;
      }
    })
    wx.getSystemInfo({
      complete: (res) => {
        this.globalData.platform = res.platform;
      },
    })
  },
  globalData: {}
})
