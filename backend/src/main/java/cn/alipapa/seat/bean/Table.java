package cn.alipapa.seat.bean;

public class Table {
    private Integer level;
    private Integer column;
    private Integer row;

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    @Override
    public String toString() {
        return "Table{" +
                "level=" + level +
                ", column=" + column +
                ", row=" + row +
                '}';
    }
}