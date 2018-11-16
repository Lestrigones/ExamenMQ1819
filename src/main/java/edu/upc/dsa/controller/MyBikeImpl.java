package edu.upc.dsa.controller;
import java.util.*;
import java.util.Collections;
import java.util.Comparator;
import org.apache.log4j.Logger;
import edu.upc.dsa.model.Bike;
import edu.upc.dsa.model.Station;
import edu.upc.dsa.model.Usuario;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import edu.upc.dsa.exceptions.*;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;



public class MyBikeImpl implements MyBike {
    private static MyBikeImpl instance=null;
    private int numstations;
    private Station stations[];
    private HashMap<String,Usuario> usuarios;
    final static Logger logger = Logger.getLogger(MyBikeImpl.class);


    private MyBikeImpl(){

        numstations=0;
        this.stations = new Station[10];
        this.usuarios=new HashMap<>();
    }

    public static MyBikeImpl getInstance(){
        if(instance ==null){
            instance = new MyBikeImpl();
        }
        return instance;
    }


    @Override
    public void addStation(String idStation, String description, int max, double lat, double lon) {
        logger.info("numero de estationes"+numstations);
        Station station = new Station(idStation,description,max,lat,lon);
        this.stations[this.numstations] = station;
        this.numstations++;
        logger.debug("completado");
    }
    @Override
    public void addUser(String idUser, String name, String surname) {
        logger.info("Creamdo usuario");
        Usuario usuario = new Usuario(idUser,name,surname);
        this.usuarios.put(idUser, usuario);
        logger.info("Usuario completado");
    }
    @Override
    public void addBike(String idBike, String description, double kms, String idStation) throws StationFullException, StationNotFoundException {
        Station station = null;
        for(int i = 0; i<this.numstations; i++) {
            if(idStation.equals(this.stations[i].idStation)){
                station = this.stations[i];
            }
        }
        if(station != null) {
            LinkedList<Bike> bikes = station.biListStation();
            if (bikes.size() < station.max) {
                station.addBike(new Bike(idBike, description, kms, idStation));
            }
            else {
                logger.error("estacion llena");
                throw new StationFullException();
            }
        }
        else{

            throw new StationNotFoundException();
        }

        logger.debug("Bici Añadida");
    }
    @Override
    public List<Bike> bikesByUser(String userId) throws UserNotFoundException{
        return this.usuarios.get(userId).getBicisDelUsuario();

    }

    @Override
    public List<Bike> bikesByStationOrderByKms(String idStation) throws StationNotFoundException{
        logger.debug("Ordenando por kms");
        List<Bike> bl = new ArrayList<>();
        Bike bike = null;
        Station station = null;
        for(int i = 0; i<this.numstations; i++) {
            if(idStation.equals(this.stations[i].idStation)){
                station = this.stations[i];
            }
        }

        if(station != null) {
            bl = station.biListStation();

            Collections.sort(bl, new Comparator<Bike>() {
                @Override
                public int compare(Bike o1, Bike o2) {
                    return (int) (o1.getKms() - o2.getKms());
                }
            });
        }
        else{
            logger.error("La estacion no existe");
            throw new StationNotFoundException();
        }
        logger.debug("ordenado por kms");

        return bl;
    }

    @Override
    public int numUsers() {
        return this.usuarios.size();
    }

    @Override
    public int numStations() {
        return this.numstations;
    }
    @Override
    public Bike getBike(String stationId, String userId) throws UserNotFoundException, StationNotFoundException {
        logger.debug("getbike");
        List<Bike> x = new LinkedList<>();
        Bike bike = null;
        Station station = null;
        Usuario usuario = usuarios.get(userId);
        for(int i = 0; i<this.numstations; i++) {
            if(stationId.equals(this.stations[i].idStation)){
                station = this.stations[i];
            }
        }

        if(usuario != null) {
            if (station != null) {
                bike = station.biListStation().pop();
            }
            else {
                logger.error("No existe la estacion");
                throw new StationNotFoundException();
            }
        }
        else{
            logger.error("No existe el usuario");
            throw new UserNotFoundException();
        }
        usuario.addBici(bike);
        logger.debug("Completado");
        return bike;
    }



    @Override
    public int numBikes(String idStation) throws StationNotFoundException{
        int num = 0;
        Bike bike = null;
        Station station = null;
        for(int i = 0; i<this.numstations; i++) {
            if(idStation.equals(this.stations[i].idStation)){
                station = this.stations[i];
            }
        }
        if (station != null){
            num = station.biListStation().size();
        }
        else{
            throw new StationNotFoundException();
        }
        return num;
    }

    @Override
    public void clear() {
        usuarios.clear();
        stations = new Station[10];

    }

    @Override
    public Station[] getStations() {
        return new Station[0];
    }

}