// components/text-field/text-field.js
Component({
  /**
   * 组件的属性列表
   */
  properties: {
    placeholder: {
      type: String,
      default: ""
    },
    label: {
      type: String,
      default: ""
    }
  },

  /**
   * 组件的初始数据
   */
  data: {

  },

  /**
   * 组件的方法列表
   */
  methods: {
    onInput(e){
      this.triggerEvent('change', e.detail);
    },
  }
})
