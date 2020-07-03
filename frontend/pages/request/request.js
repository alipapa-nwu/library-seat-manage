// pages/request/request.js
const app = getApp();

Page({
  data: {
    start: "08:00",
    end: "12:00"
  },
  onLoad(option) {
    let date = new Date();
    if (!option.today)
      date.setDate(date.getDate() + 1);
    date = date.toISOString().substr(0, 10);
    this.setData({
      seatId: option.seatId,
      today: option.today === 'true',
      label: option.label,
      date
    });
  },
  onSubmit() {
    if (!app.globalData.userInfo) {
      wx.showToast({
        title: '请登录',
        image: '/assets/error.png'
      })
      wx.switchTab({
        url: '/pages/mine/mine',
      })
    } else {
      const {
        userInfo
      } = app.globalData;
      wx.request({
        url: 'https://seat.milolab.cn/private/request_reservation',
        method: "POST",
        header: {
          "open-id": userInfo.openId,
          "session-id": userInfo.sessionId
        },
        data: {
          start: this.data.start,
          end: this.data.end,
          seat_id: this.data.seatId,
          today: this.data.today
        },
        success: () => {
          wx.showToast({
            title: '预约成功',
            complete: () => {
              wx.switchTab({
                url: '/pages/mine/mine',
              })
            }
          });
        },
        fail: res => {
          switch (res.statusCode) {
            case 401:
            case 403:
              wx.switchTab({
                url: '/pages/mine/mine',
              })
              app.globalData.userInfo = null;
            default:
              wx.showToast({
                title: '服务器异常',
                image: '/assets/error.png'
              })
          }
        }
      })
    }

  }
})