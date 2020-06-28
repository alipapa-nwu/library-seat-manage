// index.js
Page({
  data: {},
  onLoad() {
    wx.request({
      url: 'https://seat.milolab.cn/public/get_remaining_seats',
      success: res => {
        this.setData({
          levelData: res.data.data
        })
      },
      fail: res => {
        wx.showToast({
          title: res.data.error || "未知服务器异常，请稍后再试",
        })
      }
    })
  }
})