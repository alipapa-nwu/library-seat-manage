// components/table-info/table-info.js
Component({
  properties: {
    label: String,
    seatData: Array,
    today: Boolean
  },
  data: {},
  lifetimes: {
    attached() {
      this.setData({
        seats: this.properties.seatData.map((seatReservations) => {
          let seat = {};
          const totalReservationDuration = seatReservations.reduce(
            (totalTime, reservation) =>
            totalTime + (reservation.end - reservation.start),
            0,
          );
          if (totalReservationDuration == 0) {
            seat.borderColor = "#09bb07";
          } else if (totalReservationDuration == (22 - 8) * 60 * 60 * 1000) {
            seat.borderColor = "#f76260";
          } else {
            seat.borderColor = "#ffbe00";
          }
          const today = new Date();
          if (!this.properties.today) {
            today.setDate(today.getDate() + 1)
          }
          console.log('today', today);
          today.setHours(8, 0, 0, 0);
          const start = today.getTime();
          const arr = seatReservations.reduce((arr, reservation) => {
            arr.push(reservation.start - start);
            arr.push(reservation.end - start);
            return arr;
          }, []);
          arr.unshift(0);
          let white = true;
          let covers = [];
          for (let i = 1; i < arr.length; i++) {
            covers.push({
              color: white ? "#ffffff" : "#f76260",
              height: (arr[i] - arr[i - 1]) / ((22 - 8) * 60 * 60 * 1000) * 100
            })
            white = !white;
          }
          seat.covers = covers
          console.log(arr);
          return seat;
        })
      })
    }
  }
})