package schemas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class WeatherRecord implements Serializable {

    private String datetime;
    private String city;
    private String weather;

    public WeatherRecord(String datetime, String city, String weather) {
        this.datetime = datetime;
        this.city = city;
        this.weather = weather;
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

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public static List<WeatherRecord> cityWeatherToListWeatherRecords(CityWeather cityWeather) {
        ArrayList<WeatherRecord> result = new ArrayList<>();
        result.add(new WeatherRecord(cityWeather.getDatetime(), "Portland", cityWeather.getPortland()));
        result.add(new WeatherRecord(cityWeather.getDatetime(), "San Francisco", cityWeather.getSanFrancisco()));
        result.add(new WeatherRecord(cityWeather.getDatetime(), "Seattle", cityWeather.getSeattle()));
        result.add(new WeatherRecord(cityWeather.getDatetime(), "Los Angeles", cityWeather.getLosAngeles()));
        result.add(new WeatherRecord(cityWeather.getDatetime(), "San Diego", cityWeather.getSanDiego()));
        result.add(new WeatherRecord(cityWeather.getDatetime(), "Las Vegas", cityWeather.getLasVegas()));
        result.add(new WeatherRecord(cityWeather.getDatetime(), "Phoenix", cityWeather.getPhoenix()));
        result.add(new WeatherRecord(cityWeather.getDatetime(), "Albuquerque", cityWeather.getAlbuquerque()));
        result.add(new WeatherRecord(cityWeather.getDatetime(), "Denver", cityWeather.getDenver()));
        result.add(new WeatherRecord(cityWeather.getDatetime(), "San Antonio", cityWeather.getSanAntonio()));
        result.add(new WeatherRecord(cityWeather.getDatetime(), "Dallas", cityWeather.getDallas()));
        result.add(new WeatherRecord(cityWeather.getDatetime(), "Houston", cityWeather.getHouston()));
        result.add(new WeatherRecord(cityWeather.getDatetime(), "Kansas City", cityWeather.getKansasCity()));
        result.add(new WeatherRecord(cityWeather.getDatetime(), "Minneapolis", cityWeather.getMinneapolis()));
        result.add(new WeatherRecord(cityWeather.getDatetime(), "Saint Louis", cityWeather.getSaintLouis()));
        result.add(new WeatherRecord(cityWeather.getDatetime(), "Chicago", cityWeather.getChicago()));
        result.add(new WeatherRecord(cityWeather.getDatetime(), "Nashville", cityWeather.getNashville()));
        result.add(new WeatherRecord(cityWeather.getDatetime(), "Indianapolis", cityWeather.getIndianapolis()));
        result.add(new WeatherRecord(cityWeather.getDatetime(), "Atlanta", cityWeather.getAtlanta()));
        result.add(new WeatherRecord(cityWeather.getDatetime(), "Detroit", cityWeather.getDetroit()));
        result.add(new WeatherRecord(cityWeather.getDatetime(), "Jacksonville", cityWeather.getJacksonville()));
        result.add(new WeatherRecord(cityWeather.getDatetime(), "Charlotte", cityWeather.getCharlotte()));
        result.add(new WeatherRecord(cityWeather.getDatetime(), "Miami", cityWeather.getMiami()));
        result.add(new WeatherRecord(cityWeather.getDatetime(), "Pittsburgh", cityWeather.getPittsburgh()));
        result.add(new WeatherRecord(cityWeather.getDatetime(), "Philadelphia", cityWeather.getPhiladelphia()));
        result.add(new WeatherRecord(cityWeather.getDatetime(), "New York", cityWeather.getNewYork()));
        result.add(new WeatherRecord(cityWeather.getDatetime(), "Boston", cityWeather.getBoston()));
        result.add(new WeatherRecord(cityWeather.getDatetime(), "Beersheba", cityWeather.getBeersheba()));
        result.add(new WeatherRecord(cityWeather.getDatetime(), "Tel Aviv District", cityWeather.getTelAvivDistrict()));
        result.add(new WeatherRecord(cityWeather.getDatetime(), "Eilat", cityWeather.getEilat()));
        result.add(new WeatherRecord(cityWeather.getDatetime(), "Haifa", cityWeather.getHaifa()));
        result.add(new WeatherRecord(cityWeather.getDatetime(), "Nahariyya", cityWeather.getNahariyya()));
        result.add(new WeatherRecord(cityWeather.getDatetime(), "Jerusalem", cityWeather.getJerusalem()));
        return result;
    }
}
