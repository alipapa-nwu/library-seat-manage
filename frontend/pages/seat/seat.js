// pages/seat/seat.js
const app = getApp();

Page({
  data: {

  },
  onLoad: function (options) {
    this.setData({
      table: app.globalData.currentTableData.table,
      seats: app.globalData.currentTableData.seats,
      today: app.globalData.currentTableData.id.substring(1) === "today"
    })
  }
})