// pages/mine/mine.js
const app = getApp();

Page({
  data: {
    reservations: [],
    nickName: "用户昵称",
    serial: "未绑定学号",
    avatarUrl: "/assets/reservation_avatar_placeholder.png",
    loggedIn: false,
    page: 0
  },
  onTap(e) {
    const {
      description,
      status
    } = e.target.dataset;
    if (status == "pending") {
      wx.navigateTo({
        url: `/pages/reservation/reservation?description=${description}`,
      })
    }
  },
  onLoad() {
    if (app.globalData.userInfo) {
      this.setData({
        ...app.globalData.userInfo,
        loggedIn: true
      });
    } else {
      this.setData({
        loggedIn: false
      })
    }
  },
  getUserInfo() {
    wx.getUserInfo({
      success: (res) => {
        app.globalData.userInfo = {
          ...app.globalData.userInfo,
          ...res.userInfo
        };
        wx.setStorage({
          data: app.globalData.userInfo,
          key: 'userInfo',
        })
        this.setData({
          ...app.globalData.userInfo
        })
        this.login();
      },
    })
  },
  login() {
    wx.login({
      success: res => {
        const {
          code
        } = res;
        wx.request({
          url: 'https://seat.milolab.cn/public/login',
          method: 'POST',
          data: {
            code
          },
          success: res => {
            if (!res.data.data.serial) {
              wx.navigateTo({
                url: '/pages/bind/bind',
                events: {
                  updateSerial: res=>{
                    this.setData({serial: res.serial})
                  }
                }
              })
            };
            app.globalData.userInfo = {
              ...app.globalData.userInfo,
              ...res.data.data,
            };
            wx.setStorage({
              data: app.globalData.userInfo,
              key: 'userInfo',
            });
            this.setData({
              ...app.globalData.userInfo,
              loggedIn: true
            });
            this.getReservations();
          },
          fail: res => {
            wx.showToast({
              title: '登陆失败',
              image: '/assets/error.png'
            })
          }
        })
      },
      fail: () => {
        wx.showToast({
          title: '登陆失败',
          image: '/assets/error.png'
        })
      }
    })
  },
  onShow() {
    if (app.globalData.userInfo)
      this.getReservations();
  },
  getReservations() {
    wx.request({
      url: 'https://seat.milolab.cn/private/get_reservations',
      data: {
        page: this.data.page
      },
      header: {
        "open-id": this.data.openId,
        "session-id": this.data.sessionId
      },
      success: res => {
        let reservations = res.data.data;
        this.setData({
          reservations: reservations.map(this.reservationMapper)
        })
      }
    })
  },
  reservationMapper(r) {
    let date = r.reservation_date.substr(0, 10);
    let start = r.start.substr(11, 5);
    let end = r.end.substr(11, 5);
    let column = alphabet[r.column];
    let level = uppercaseMapper[r.level];
    let row = r.row + 1;
    let position = r.position;
    return {
      status: "pending",
      id: r.id,
      description: `第${level}层 ${column}${row}-${position} ${date} ${start}-${end}`
    }
  }
})

const uppercaseMapper = '一二三四五六七八九十';
const alphabet = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';