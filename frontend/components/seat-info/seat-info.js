// components/order-information/order-information.js
Component({

  properties: {
    table: Object,
    seat: Object,
    today: Boolean
  },
  data: {},
  lifetimes: {
    attached() {
      const {
        table,
        seat,
        today
      } = this.properties;
      let label = `第${uppercaseMapper[table.level]}层 ${alphabet[table.row]}${table.column+1}-${seat.seat.position}`;
      let date = new Date();
      if (!today) date.setDate(date.getDate() + 1);
      date = date.toISOString().substr(0, 10);
      const period = seat.reservations.map(reservation => ({
        start: reservation.start.substr(11, 5),
        end: reservation.end.substr(11, 5)
      }))
      const noReservation = period.length == 0;
      this.setData({
        label,
        date,
        period,
        noReservation
      })
    }
  },
  methods: {
    onTap() {
      wx.navigateTo({
        url: `/pages/request/request?seatId=${this.properties.seat.seat.id}&today=${this.properties.today}&label=${this.data.label}`,
      })
    }
  }
})

const uppercaseMapper = '一二三四五六七八九十';
const alphabet = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';