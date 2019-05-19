package schemas;

public class MeanSchema {

    private Double mean;   // mean value
    private Integer num;   // number of records that contribute to mean value

    public MeanSchema(Double mean, Integer num) {
        this.mean = mean;
        this.num = num;
    }

    public Double getMean() {
        return mean;
    }

    public void setMean(Double mean) {
        this.mean = mean;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "{mean: " + this.mean + ", num: " + this.num + "}";
    }
}
