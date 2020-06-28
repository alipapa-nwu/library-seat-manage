// components/table-info/table-info.js
const app = getApp();

Component({
  properties: {
    tableData: Object
  },
  data: {},
  lifetimes: {
    attached() {
      const {
        column,
        row
      } = this.properties.tableData.table;
      const label = alphaBet[row] + (column + 1);
      const seats = this.properties.tableData.seats.map(seatData => {
        let seat = {};
        let totalReservationDuration = 0;
        for (let i of seatData.reservations) {
          totalReservationDuration += (new Date(i.end) - new Date(i.start));
        }
        if (totalReservationDuration == 0) {
          seat.borderColor = "#09bb07";
        } else if (totalReservationDuration == (22 - 8) * 60 * 60 * 1000) {
          seat.borderColor = "#f76260";
        } else {
          seat.borderColor = "#ffbe00";
        }
        const start = new Date("1970-1-1 08:00:00");
        const timelines = seatData.reservations.reduce((arr, reservation) => {
          arr.push(new Date(reservation.start) - start);
          arr.push(new Date(reservation.end) - start);
          return arr;
        }, [])
        timelines.unshift(0);
	      let white = true;
        let covers = [];
        for(let i=1;i<timelines.length;i++){
          covers.push({
            color: white?"#ffffff":"#f76260",
            height: (timelines[i]-timelines[i-1])/((22-8)*60*60*1000)*100
          })
          white = !white;
        }
        seat.covers = covers;
        return seat;
      })
      this.setData({
        label: label,
        seats
      })
    }
  },
  methods: {
    onTap(){
      app.globalData.currentTableData = this.properties.tableData;
      wx.navigateTo({
        url: '/pages/seat/seat',
      })
    }
  }
})

const alphaBet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"