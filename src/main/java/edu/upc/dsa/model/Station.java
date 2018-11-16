package edu.upc.dsa.model;
import java.util.LinkedList;
import java.util.List;

public class Station {

    private LinkedList<Bike> bikes;
    public String idStation;
    String description;
    public int max;
    double lat;
    double lon;

    public Station(){

    }
    public Station(String idStation,String description,int max,double lat,double lon){

        this.idStation=idStation;
        this.description=description;
        this.max=max;
        this.lat=lat;
        this.lon=lon;
        bikes=new LinkedList<>();
    }


    public void setBikes(LinkedList<Bike> bikes) {
        this.bikes = bikes;
    }

    public String getIdStation() {
        return idStation;
    }

    public void setIdStation(String idStation) {
        this.idStation = idStation;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public LinkedList<Bike> biListStation(){
        return bikes;
    }
    public void addBike(Bike bike){
        bikes.add(bike);
    }


    public LinkedList<Bike> getBikes() {
        return bikes;
    }
}


