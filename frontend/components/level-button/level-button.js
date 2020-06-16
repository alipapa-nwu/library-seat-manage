// components/level-button/level-button.js
const assert = require('../../utils/assert.js');

Component({
  properties: {
    level: Number,
    remain: Number
  },
  data: {
    levelTitle: "",
    color: "green"
  },
  methods: {
    getLevelCapital(level) {
      const mapper = ['', '一', '二', '三', '四', '五', '六', '七', '八', '九', '十'];
      return mapper[level];
    },
    getColor(remain){
      if(remain>=40){
        return "green";
      }else if(remain>=15){
        return "yellow";
      }else{
        return "red";
      }
    },
    onTap(e){
      wx.navigateTo({
        url: `/pages/level/level?level=${this.properties.level}`,
      })
    }
  },
  lifetimes: {
    attached: function() {
      const {level, remain} = this.properties;
      assert(level, "参数level缺失");
      assert(remain, "参数remain参数");
      assert(level > 0 && level <= 10, "非法参数level");
      this.setData({
        levelTitle: this.getLevelCapital(level),
        color: this.getColor(remain)
      })
    },
  }
})