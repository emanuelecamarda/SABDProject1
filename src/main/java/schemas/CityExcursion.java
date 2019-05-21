package schemas;

import java.io.Serializable;

public class CityExcursion implements Serializable {

    private String city;
    private Double excursions;
    private String query;
    private String year;
    private String state;

    public CityExcursion(String city, Double excursions, String year) {
        this.city = city;
        this.excursions = excursions;
        this.query = "query3";
        this.year = year;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getExcursions() {
        return excursions;
    }

    public void setExcursions(Double excursions) {
        this.excursions = excursions;
    }

    @Override
    public String toString() {
        return "{\"year\": \"" + this.year + "\", \"state\": \"" + this.state + "\", \"city\": " +
                this.city + "\", \"excursions\": \"" + this.excursions + "\", \"query\": \"" + this.query + "\"}";
    }

    public String getState() {
        if (this.city.equals("Beersheba") ||
                this.city.equals("Tel Aviv District") ||
                this.city.equals("Eilat") ||
                this.city.equals("Haifa") ||
                this.city.equals("Nahariyya") ||
                this.city.equals("Jerusalem")) {
            this.state = "Israel";
            return "Israel";
        } else {
            this.state = "USA";
            return "USA";
        }
    }
}
