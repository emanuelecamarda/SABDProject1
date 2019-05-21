package schemas;

import java.io.Serializable;

public class Query1Result implements Serializable {

    private String year;
    private String city;
    private String query;

    public Query1Result(String year, String city) {
        this.year = year;
        this.city = city;
        this.query = "query1";
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "{\"year\": \"" + this.year + "\", \"city\": \"" + this.city + ",\"query\": \"" + this.query + "\"}";
    }
}
