package cn.alipapa.seat.bean.response;

public class LevelCountResponse {
    private Integer level;
    private Integer count;

    @Override
    public String toString() {
        return "LevelCount{" +
                "level=" + level +
                ", count=" + count +
                '}';
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
