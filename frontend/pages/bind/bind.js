// pages/bind/bind.js
const app = getApp();

Page({
  data: {
    serial: "",
    password: ""
  },
  onSubmmit(e) {
    wx.showLoading({
      title: '正在绑定',
    });
    wx.request({
      url: 'https://seat.milolab.cn/private/bind_serial',
      method: 'POST',
      data: {
        serial: this.data.serial,
        password: this.data.password
      },
      header: {
        'open-id': app.globalData.userInfo.openId,
        'session-id': app.globalData.userInfo.sessionId
      },
      success: res=>{
        app.globalData.userInfo = {
          ...app.globalData.userInfo,
          serial: this.data.serial
        }
        wx.setStorage({
          data: app.globalData.userInfo,
          key: 'userInfo',
        })
        this.getOpenerEventChannel().emit('updateSerial', {
          serial: this.data.serial
        })
        wx.navigateBack();
      },
      fail: res=>{
        wx.showToast({
          title: '绑定失败',
          image: '/assets/error.png'
        });
      },
      complete: res=>{
        wx.hideLoading();
      }
    })
  },
  onChange(e){
    const data = {};
    data[e.target.dataset.field] = e.detail.value;
    this.setData(data);
  }
})