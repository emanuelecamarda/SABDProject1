package schemas;

import java.io.Serializable;

public abstract class CityRecord implements Serializable {

    protected String datetime;
    protected String city;

    public CityRecord(String datetime, String city) {
        this.datetime = datetime;
        this.city = city;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getYear() {
        return this.datetime.split("-")[0];
    }

    public String getMounth() {
        return this.datetime.split("-")[1];
    }

    public String getDay() {
        return this.datetime.split("-")[2];
    }

    public String getHour() {
        return this.datetime.split(" ")[1].split(":")[0];
    }
}
