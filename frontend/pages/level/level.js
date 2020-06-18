// pages/level/level.js
Page({
  data: {
    level: 0
  },
  onLoad(option) {
    this.setData({
      level: option.level
    });
  }
})