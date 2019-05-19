package schemas;

public class CityExcursion {

    private String city;
    private Double excursions;

    public CityExcursion(String city, Double excursions) {
        this.city = city;
        this.excursions = excursions;
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
        return "{city: " + city + ", excursions: " + excursions + '}';
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
