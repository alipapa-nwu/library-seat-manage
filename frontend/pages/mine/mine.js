// pages/mine/mine.js
Page({
  data: {
    reservations: [
      {
        status: "success",
        description: "第三层 A13-4 6月5日 08:00-10:00",
        id: 123456
      },
      {
        status: "pending",
        description: "第三层 A13-4 6月5日 08:00-10:00",
        id: 123456
      },
      {
        status: "fail",
        description: "第三层 A13-4 6月5日 08:00-10:00",
        id: 123456
      },
    ],
    name : "岚荨",
    stu_num : "201811XXXX"
  },
  onTap(e){
    const {description,status} = e.target.dataset;
    if(status == "pending"){
      wx.navigateTo({
        url: `/pages/reservation/reservation?description=${description}`,
      })
    }
  }
})