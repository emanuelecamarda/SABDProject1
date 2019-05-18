package schemas;

import java.io.Serializable;

public class CityWeather implements Serializable {

    // 34 attributes
    private String datetime;
    private String Portland;
    private String SanFrancisco;
    private String Seattle;
    private String LosAngeles;
    private String SanDiego;
    private String LasVegas;
    private String Phoenix;
    private String Albuquerque;
    private String Denver;
    private String SanAntonio;
    private String Dallas;
    private String Houston;
    private String KansasCity;
    private String Minneapolis;
    private String SaintLouis;
    private String Chicago;
    private String Nashville;
    private String Indianapolis;
    private String Atlanta;
    private String Detroit;
    private String Jacksonville;
    private String Charlotte;
    private String Miami;
    private String Pittsburgh;
    private String Philadelphia;
    private String NewYork;
    private String Boston;
    private String Beersheba;
    private String TelAvivDistrict;
    private String Eilat;
    private String Haifa;
    private String Nahariyya;
    private String Jerusalem;

    public CityWeather(String datetime, String portland, String sanFrancisco, String seattle, String losAngeles,
                       String sanDiego, String lasVegas, String phoenix, String albuquerque, String denver,
                       String sanAntonio, String dallas, String houston, String kansasCity, String minneapolis,
                       String saintLouis, String chicago, String nashville, String indianapolis, String atlanta,
                       String detroit, String jacksonville, String charlotte, String miami, String pittsburgh,
                       String philadelphia, String newYork, String boston, String beersheba, String telAvivDistrict,
                       String eilat, String haifa, String nahariyya, String jerusalem) {
        this.datetime = datetime;
        Portland = portland;
        SanFrancisco = sanFrancisco;
        Seattle = seattle;
        LosAngeles = losAngeles;
        SanDiego = sanDiego;
        LasVegas = lasVegas;
        Phoenix = phoenix;
        Albuquerque = albuquerque;
        Denver = denver;
        SanAntonio = sanAntonio;
        Dallas = dallas;
        Houston = houston;
        KansasCity = kansasCity;
        Minneapolis = minneapolis;
        SaintLouis = saintLouis;
        Chicago = chicago;
        Nashville = nashville;
        Indianapolis = indianapolis;
        Atlanta = atlanta;
        Detroit = detroit;
        Jacksonville = jacksonville;
        Charlotte = charlotte;
        Miami = miami;
        Pittsburgh = pittsburgh;
        Philadelphia = philadelphia;
        NewYork = newYork;
        Boston = boston;
        Beersheba = beersheba;
        TelAvivDistrict = telAvivDistrict;
        Eilat = eilat;
        Haifa = haifa;
        Nahariyya = nahariyya;
        Jerusalem = jerusalem;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getPortland() {
        return Portland;
    }

    public void setPortland(String portland) {
        Portland = portland;
    }

    public String getSanFrancisco() {
        return SanFrancisco;
    }

    public void setSanFrancisco(String sanFrancisco) {
        SanFrancisco = sanFrancisco;
    }

    public String getSeattle() {
        return Seattle;
    }

    public void setSeattle(String seattle) {
        Seattle = seattle;
    }

    public String getLosAngeles() {
        return LosAngeles;
    }

    public void setLosAngeles(String losAngeles) {
        LosAngeles = losAngeles;
    }

    public String getSanDiego() {
        return SanDiego;
    }

    public void setSanDiego(String sanDiego) {
        SanDiego = sanDiego;
    }

    public String getLasVegas() {
        return LasVegas;
    }

    public void setLasVegas(String lasVegas) {
        LasVegas = lasVegas;
    }

    public String getPhoenix() {
        return Phoenix;
    }

    public void setPhoenix(String phoenix) {
        Phoenix = phoenix;
    }

    public String getAlbuquerque() {
        return Albuquerque;
    }

    public void setAlbuquerque(String albuquerque) {
        Albuquerque = albuquerque;
    }

    public String getDenver() {
        return Denver;
    }

    public void setDenver(String denver) {
        Denver = denver;
    }

    public String getSanAntonio() {
        return SanAntonio;
    }

    public void setSanAntonio(String sanAntonio) {
        SanAntonio = sanAntonio;
    }

    public String getDallas() {
        return Dallas;
    }

    public void setDallas(String dallas) {
        Dallas = dallas;
    }

    public String getHouston() {
        return Houston;
    }

    public void setHouston(String houston) {
        Houston = houston;
    }

    public String getKansasCity() {
        return KansasCity;
    }

    public void setKansasCity(String kansasCity) {
        KansasCity = kansasCity;
    }

    public String getMinneapolis() {
        return Minneapolis;
    }

    public void setMinneapolis(String minneapolis) {
        Minneapolis = minneapolis;
    }

    public String getSaintLouis() {
        return SaintLouis;
    }

    public void setSaintLouis(String saintLouis) {
        SaintLouis = saintLouis;
    }

    public String getChicago() {
        return Chicago;
    }

    public void setChicago(String chicago) {
        Chicago = chicago;
    }

    public String getNashville() {
        return Nashville;
    }

    public void setNashville(String nashville) {
        Nashville = nashville;
    }

    public String getIndianapolis() {
        return Indianapolis;
    }

    public void setIndianapolis(String indianapolis) {
        Indianapolis = indianapolis;
    }

    public String getAtlanta() {
        return Atlanta;
    }

    public void setAtlanta(String atlanta) {
        Atlanta = atlanta;
    }

    public String getDetroit() {
        return Detroit;
    }

    public void setDetroit(String detroit) {
        Detroit = detroit;
    }

    public String getJacksonville() {
        return Jacksonville;
    }

    public void setJacksonville(String jacksonville) {
        Jacksonville = jacksonville;
    }

    public String getCharlotte() {
        return Charlotte;
    }

    public void setCharlotte(String charlotte) {
        Charlotte = charlotte;
    }

    public String getMiami() {
        return Miami;
    }

    public void setMiami(String miami) {
        Miami = miami;
    }

    public String getPittsburgh() {
        return Pittsburgh;
    }

    public void setPittsburgh(String pittsburgh) {
        Pittsburgh = pittsburgh;
    }

    public String getPhiladelphia() {
        return Philadelphia;
    }

    public void setPhiladelphia(String philadelphia) {
        Philadelphia = philadelphia;
    }

    public String getNewYork() {
        return NewYork;
    }

    public void setNewYork(String newYork) {
        NewYork = newYork;
    }

    public String getBoston() {
        return Boston;
    }

    public void setBoston(String boston) {
        Boston = boston;
    }

    public String getBeersheba() {
        return Beersheba;
    }

    public void setBeersheba(String beersheba) {
        Beersheba = beersheba;
    }

    public String getTelAvivDistrict() {
        return TelAvivDistrict;
    }

    public void setTelAvivDistrict(String telAvivDistrict) {
        TelAvivDistrict = telAvivDistrict;
    }

    public String getEilat() {
        return Eilat;
    }

    public void setEilat(String eilat) {
        Eilat = eilat;
    }

    public String getHaifa() {
        return Haifa;
    }

    public void setHaifa(String haifa) {
        Haifa = haifa;
    }

    public String getNahariyya() {
        return Nahariyya;
    }

    public void setNahariyya(String nahariyya) {
        Nahariyya = nahariyya;
    }

    public String getJerusalem() {
        return Jerusalem;
    }

    public void setJerusalem(String jerusalem) {
        Jerusalem = jerusalem;
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
