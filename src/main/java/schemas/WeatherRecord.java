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

    public static List<WeatherRecord> rowRecordToListWeatherRecords(RowRecord rowRecord) {
        ArrayList<WeatherRecord> result = new ArrayList<>();
        result.add(new WeatherRecord(rowRecord.getDatetime(), "Portland", rowRecord.getPortland()));
        result.add(new WeatherRecord(rowRecord.getDatetime(), "San Francisco", rowRecord.getSanFrancisco()));
        result.add(new WeatherRecord(rowRecord.getDatetime(), "Seattle", rowRecord.getSeattle()));
        result.add(new WeatherRecord(rowRecord.getDatetime(), "Los Angeles", rowRecord.getLosAngeles()));
        result.add(new WeatherRecord(rowRecord.getDatetime(), "San Diego", rowRecord.getSanDiego()));
        result.add(new WeatherRecord(rowRecord.getDatetime(), "Las Vegas", rowRecord.getLasVegas()));
        result.add(new WeatherRecord(rowRecord.getDatetime(), "Phoenix", rowRecord.getPhoenix()));
        result.add(new WeatherRecord(rowRecord.getDatetime(), "Albuquerque", rowRecord.getAlbuquerque()));
        result.add(new WeatherRecord(rowRecord.getDatetime(), "Denver", rowRecord.getDenver()));
        result.add(new WeatherRecord(rowRecord.getDatetime(), "San Antonio", rowRecord.getSanAntonio()));
        result.add(new WeatherRecord(rowRecord.getDatetime(), "Dallas", rowRecord.getDallas()));
        result.add(new WeatherRecord(rowRecord.getDatetime(), "Houston", rowRecord.getHouston()));
        result.add(new WeatherRecord(rowRecord.getDatetime(), "Kansas City", rowRecord.getKansasCity()));
        result.add(new WeatherRecord(rowRecord.getDatetime(), "Minneapolis", rowRecord.getMinneapolis()));
        result.add(new WeatherRecord(rowRecord.getDatetime(), "Saint Louis", rowRecord.getSaintLouis()));
        result.add(new WeatherRecord(rowRecord.getDatetime(), "Chicago", rowRecord.getChicago()));
        result.add(new WeatherRecord(rowRecord.getDatetime(), "Nashville", rowRecord.getNashville()));
        result.add(new WeatherRecord(rowRecord.getDatetime(), "Indianapolis", rowRecord.getIndianapolis()));
        result.add(new WeatherRecord(rowRecord.getDatetime(), "Atlanta", rowRecord.getAtlanta()));
        result.add(new WeatherRecord(rowRecord.getDatetime(), "Detroit", rowRecord.getDetroit()));
        result.add(new WeatherRecord(rowRecord.getDatetime(), "Jacksonville", rowRecord.getJacksonville()));
        result.add(new WeatherRecord(rowRecord.getDatetime(), "Charlotte", rowRecord.getCharlotte()));
        result.add(new WeatherRecord(rowRecord.getDatetime(), "Miami", rowRecord.getMiami()));
        result.add(new WeatherRecord(rowRecord.getDatetime(), "Pittsburgh", rowRecord.getPittsburgh()));
        result.add(new WeatherRecord(rowRecord.getDatetime(), "Philadelphia", rowRecord.getPhiladelphia()));
        result.add(new WeatherRecord(rowRecord.getDatetime(), "New York", rowRecord.getNewYork()));
        result.add(new WeatherRecord(rowRecord.getDatetime(), "Boston", rowRecord.getBoston()));
        result.add(new WeatherRecord(rowRecord.getDatetime(), "Beersheba", rowRecord.getBeersheba()));
        result.add(new WeatherRecord(rowRecord.getDatetime(), "Tel Aviv District", rowRecord.getTelAvivDistrict()));
        result.add(new WeatherRecord(rowRecord.getDatetime(), "Eilat", rowRecord.getEilat()));
        result.add(new WeatherRecord(rowRecord.getDatetime(), "Haifa", rowRecord.getHaifa()));
        result.add(new WeatherRecord(rowRecord.getDatetime(), "Nahariyya", rowRecord.getNahariyya()));
        result.add(new WeatherRecord(rowRecord.getDatetime(), "Jerusalem", rowRecord.getJerusalem()));
        return result;
    }

    @Override
    public String toString() {
        return "{datetime: " + this.datetime + ", city: " + this.city + ", weather: " + this.weather + "}";
    }
}
