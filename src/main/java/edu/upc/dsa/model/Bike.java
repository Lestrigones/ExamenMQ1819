package edu.upc.dsa.model;
import java.util.List;

public class Bike {

    private int idBike;
    String description;
    double kms;
    String idStation;


    //private List<Station> station;


    public Bike(String idBike, String description, double kms, String idStation){}

    public Bike(int dni, String description, double kms, String idStation,List<Station> station){
        this.idBike=idBike;
        this.description= description;
        this.kms=kms;
        this.idStation=idStation;

    }

    public int getIdBike() {
        return idBike;
    }

    public void setIdBike(int idBike) {
        this.idBike = idBike;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getKms() {
        return kms;
    }

    public void setKms(double kms) {
        this.kms = kms;
    }

    public String getIdStation() {
        return idStation;
    }

    public void setIdStation(String idStation) {
        this.idStation = idStation;
    }

    /*public List<Station> getStation() {
        return station;
    }

    public void setStation(List<Station> station) {
        this.station = station;
    }

    public boolean isAlquilado() {
        return alquilado;
    }

    public void setAlquilado(boolean alguilado) {
        this.alquilado = alguilado;
    }

    public void add(Bike bike) {
    }*/
}
