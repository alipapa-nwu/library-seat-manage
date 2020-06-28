// pages/level/level.js
Page({
  data: {
    levelData: {},
    today: true,
    gridLimit: {}
  },
  onLoad(option) {
    this.setData({
      level: option.level
    })
    this.refresh();
  },
  switchDate() {
    this.setData({
      today: !this.data.today
    });
    this.refresh();
  },
  refresh() {
    wx.request({
      url: 'https://seat.milolab.cn/public/get_level_seats',
      data: {
        level: this.data.level,
        today: this.data.today
      },
      fail: res => {
        wx.showToast({
          title: res.data.error || "无法获取数据",
          image: "/assets/error.png"
        })
      },
      success: res => {
        const levelData = res.data.data.tables.map(i => {
          i.id = i.table.id + (this.data.today ? "today" : "tomorrow");
          return i;
        })
        this.setData({
          levelData,
          gridLimit: getGridLimit(levelData)
        })
        wx.showToast({
          title: "楼层数据已刷新"
        })
      },
    });
  }
})

function getGridLimit(tables) {
  let rowMax = 0;
  let colMax = 0;
  for (let i of tables) {
    rowMax = i.table.row > rowMax ? i.table.row : rowMax;
    colMax = i.table.column > colMax ? i.table.column : colMax;
  }
  return {
    rowMax: rowMax + 1,
    colMax: colMax + 1
  }
}