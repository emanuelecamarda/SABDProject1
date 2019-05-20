package schemas;

import java.io.Serializable;

public class MeanSchema implements Serializable {

    private Double mean;   // mean value
    private Double num;   // number of records that contribute to mean value

    public MeanSchema(Double mean, Double num) {
        this.mean = mean;
        this.num = num;
    }

    public Double getMean() {
        return mean;
    }

    public void setMean(Double mean) {
        this.mean = mean;
    }

    public Double getNum() {
        return num;
    }

    public void setNum(Double num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "{mean: " + this.mean + ", num: " + this.num + "}";
    }

    public static MeanSchema updateMean(MeanSchema x, MeanSchema y) {
        return new MeanSchema(
                x.getNum() / (x.getNum() + y.getNum()) * x.getMean() +
                        y.getNum() / (x.getNum() + y.getNum()) * y.getMean(),
                x.getNum() + y.getNum());
    }
}
