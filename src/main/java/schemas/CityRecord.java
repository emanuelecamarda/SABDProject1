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

    public String getState() {
        if (this.city.equals("Beersheba") ||
                this.city.equals("Tel Aviv District") ||
                this.city.equals("Eilat") ||
                this.city.equals("Haifa") ||
                this.city.equals("Nahariyya") ||
                this.city.equals("Jerusalem"))
            return "Israel";
        else
            return "USA";
    }
}
