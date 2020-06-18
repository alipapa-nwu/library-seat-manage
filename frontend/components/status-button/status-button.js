// components/finished-button/finished-button.js
Component({
  properties: {
    status: String,
    description: String
  },
  data: {
    color: "",
    title: "",
    subtitle: "",
    imgPath: ""
  },
  lifetimes: {
    attached() {
      const {status, description} = this.properties;
      const stateMap = {
        success: {
          title: "已完成",
          color: "green",
          subtitle: description,
          imgPath: "/assets/reservation_success.png"
        },
        pending: {
          title: "待完成",
          color: "blue",
          subtitle: description,
          imgPath: "/assets/reservation_pending.png"
        },
        fail: {
          title: "未完成",
          color: "red",
          subtitle: description,
          imgPath: "/assets/reservation_fail.png"
        }
      };
      this.setData(stateMap[status]);
    }
  }
})