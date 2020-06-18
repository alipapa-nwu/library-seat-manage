// pages/bind/bind.js
Page({
  data: {
    serial: "",
    password: ""
  },
  onSubmmit(e) {
    console.log(this.data)
  },
  onChange(e){
    const data = {};
    data[e.target.dataset.field] = e.detail.value;
    this.setData(data);
  }
})