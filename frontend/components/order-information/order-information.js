// components/order-information/order-information.js
Component({
  
  properties: {
    seat : {
      type : String,
      value : "B6-12" 
    },
    data : {
      type : String,
      value : "2020-06-22"
    },
    periord : {
      type : Array,
      value :[
        {
          start: "08:00",
          end: "12:00"
        },
        {
          start: "10:00",
          end: "11:00"
        },
        {
          start: "09:00",
          end: "13:00"
        },
        {
          start: "12:00",
          end: "14:00"
        }
    ]
    }
  },

  data: {

  },

  methods: {

  }
})
