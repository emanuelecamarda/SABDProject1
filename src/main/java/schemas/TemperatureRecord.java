package schemas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TemperatureRecord extends CityRecord implements Serializable {

    private Double temperature;

    public TemperatureRecord(String datetime, String city, Double temperature) {
        super(datetime, city);
        this.temperature = temperature;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public static List<TemperatureRecord> rowRecordToListWeatherRecords(RowRecord rowRecord) {
        ArrayList<TemperatureRecord> result = new ArrayList<>();
        result.add(new TemperatureRecord(rowRecord.getDatetime(), "Portland",
                Double.parseDouble(rowRecord.getPortland())));
        result.add(new TemperatureRecord(rowRecord.getDatetime(), "San Francisco",
                Double.parseDouble(rowRecord.getSanFrancisco())));
        result.add(new TemperatureRecord(rowRecord.getDatetime(), "Seattle",
                Double.parseDouble(rowRecord.getSeattle())));
        result.add(new TemperatureRecord(rowRecord.getDatetime(), "Los Angeles",
                Double.parseDouble(rowRecord.getLosAngeles())));
        result.add(new TemperatureRecord(rowRecord.getDatetime(), "San Diego",
                Double.parseDouble(rowRecord.getSanDiego())));
        result.add(new TemperatureRecord(rowRecord.getDatetime(), "Las Vegas",
                Double.parseDouble(rowRecord.getLasVegas())));
        result.add(new TemperatureRecord(rowRecord.getDatetime(), "Phoenix",
                Double.parseDouble(rowRecord.getPhoenix())));
        result.add(new TemperatureRecord(rowRecord.getDatetime(), "Albuquerque",
                Double.parseDouble(rowRecord.getAlbuquerque())));
        result.add(new TemperatureRecord(rowRecord.getDatetime(), "Denver",
                Double.parseDouble(rowRecord.getDenver())));
        result.add(new TemperatureRecord(rowRecord.getDatetime(), "San Antonio",
                Double.parseDouble(rowRecord.getSanAntonio())));
        result.add(new TemperatureRecord(rowRecord.getDatetime(), "Dallas",
                Double.parseDouble(rowRecord.getDallas())));
        result.add(new TemperatureRecord(rowRecord.getDatetime(), "Houston",
                Double.parseDouble(rowRecord.getHouston())));
        result.add(new TemperatureRecord(rowRecord.getDatetime(), "Kansas City",
                Double.parseDouble(rowRecord.getKansasCity())));
        result.add(new TemperatureRecord(rowRecord.getDatetime(), "Minneapolis",
                Double.parseDouble(rowRecord.getMinneapolis())));
        result.add(new TemperatureRecord(rowRecord.getDatetime(), "Saint Louis",
                Double.parseDouble(rowRecord.getSaintLouis())));
        result.add(new TemperatureRecord(rowRecord.getDatetime(), "Chicago",
                Double.parseDouble(rowRecord.getChicago())));
        result.add(new TemperatureRecord(rowRecord.getDatetime(), "Nashville",
                Double.parseDouble(rowRecord.getNashville())));
        result.add(new TemperatureRecord(rowRecord.getDatetime(), "Indianapolis",
                Double.parseDouble(rowRecord.getIndianapolis())));
        result.add(new TemperatureRecord(rowRecord.getDatetime(), "Atlanta",
                Double.parseDouble(rowRecord.getAtlanta())));
        result.add(new TemperatureRecord(rowRecord.getDatetime(), "Detroit",
                Double.parseDouble(rowRecord.getDetroit())));
        result.add(new TemperatureRecord(rowRecord.getDatetime(), "Jacksonville",
                Double.parseDouble(rowRecord.getJacksonville())));
        result.add(new TemperatureRecord(rowRecord.getDatetime(), "Charlotte",
                Double.parseDouble(rowRecord.getCharlotte())));
        result.add(new TemperatureRecord(rowRecord.getDatetime(), "Miami",
                Double.parseDouble(rowRecord.getMiami())));
        result.add(new TemperatureRecord(rowRecord.getDatetime(), "Pittsburgh",
                Double.parseDouble(rowRecord.getPittsburgh())));
        result.add(new TemperatureRecord(rowRecord.getDatetime(), "Philadelphia",
                Double.parseDouble(rowRecord.getPhiladelphia())));
        result.add(new TemperatureRecord(rowRecord.getDatetime(), "New York",
                Double.parseDouble(rowRecord.getNewYork())));
        result.add(new TemperatureRecord(rowRecord.getDatetime(), "Boston",
                Double.parseDouble(rowRecord.getBoston())));
        result.add(new TemperatureRecord(rowRecord.getDatetime(), "Beersheba",
                Double.parseDouble(rowRecord.getBeersheba())));
        result.add(new TemperatureRecord(rowRecord.getDatetime(), "Tel Aviv District",
                Double.parseDouble(rowRecord.getTelAvivDistrict())));
        result.add(new TemperatureRecord(rowRecord.getDatetime(), "Eilat",
                Double.parseDouble(rowRecord.getEilat())));
        result.add(new TemperatureRecord(rowRecord.getDatetime(), "Haifa",
                Double.parseDouble(rowRecord.getHaifa())));
        result.add(new TemperatureRecord(rowRecord.getDatetime(), "Nahariyya",
                Double.parseDouble(rowRecord.getNahariyya())));
        result.add(new TemperatureRecord(rowRecord.getDatetime(), "Jerusalem",
                Double.parseDouble(rowRecord.getJerusalem())));
        return result;
    }

    @Override
    public String toString() {
        return "{datetime: " + this.datetime + ", city: " + this.city + ", temperature: " + this.temperature + "}";
    }

}
