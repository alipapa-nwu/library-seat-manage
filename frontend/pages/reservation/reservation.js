// pages/reservation/reservation.js
Page({
  data: {
    description: "",
  },
  onLoad: function (options) {
    this.setData({
      description: options.description
    })
  }
})