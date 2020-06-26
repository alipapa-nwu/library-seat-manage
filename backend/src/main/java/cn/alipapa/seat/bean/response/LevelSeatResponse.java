package cn.alipapa.seat.bean.response;

import cn.alipapa.seat.bean.entity.Reservation;
import cn.alipapa.seat.bean.entity.Seat;
import cn.alipapa.seat.bean.entity.Table;

import java.util.ArrayList;
import java.util.List;

public class LevelSeatResponse {
    private List<TableResponse> tables;

    public LevelSeatResponse() {
        this.tables = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "LevelSeatResponse{" +
                "tables=" + tables +
                '}';
    }

    public List<TableResponse> getTables() {
        return tables;
    }

    public void setTables(List<TableResponse> tables) {
        this.tables = tables;
    }

    public static class TableResponse {
        private Table table;
        private List<SeatResponse> seats;

        public TableResponse(Table table) {
            this.table = table;
            this.seats = new ArrayList<>();
        }

        public Table getTable() {
            return table;
        }

        public void setTable(Table table) {
            this.table = table;
        }

        public List<SeatResponse> getSeats() {
            return seats;
        }

        public void setSeats(List<SeatResponse> seats) {
            this.seats = seats;
        }

        @Override
        public String toString() {
            return "TableResponse{" +
                    "table=" + table +
                    ", seats=" + seats +
                    '}';
        }
    }

    public static class SeatResponse {
        private Seat seat;
        private List<Reservation> reservations;

        public SeatResponse(Seat seat) {
            this.seat = seat;
            this.reservations = new ArrayList<>();
        }

        public Seat getSeat() {
            return seat;
        }

        public void setSeat(Seat seat) {
            this.seat = seat;
        }

        public List<Reservation> getReservations() {
            return reservations;
        }

        public void setReservations(List<Reservation> reservations) {
            this.reservations = reservations;
        }

        @Override
        public String toString() {
            return "SeatResponse{" +
                    "seat=" + seat +
                    ", reservations=" + reservations +
                    '}';
        }
    }
}



