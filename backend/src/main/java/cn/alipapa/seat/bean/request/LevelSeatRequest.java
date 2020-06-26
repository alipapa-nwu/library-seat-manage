package cn.alipapa.seat.bean.request;

public class LevelSeatRequest {
    private Integer level;

    @Override
    public String toString() {
        return "LevelSeatRequest{" +
                "level=" + level +
                '}';
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
