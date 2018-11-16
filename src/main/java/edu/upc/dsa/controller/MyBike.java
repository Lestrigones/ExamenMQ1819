package edu.upc.dsa.controller;
import java.util.List;
import  edu.upc.dsa.controller.MyBikeImpl;
import edu.upc.dsa.model.Bike;
import edu.upc.dsa.exceptions.*;
import edu.upc.dsa.model.Station;


public interface MyBike {


        public static final int S = 10;
        public void addUser(String idUser, String name, String surname);
        public void addStation(String idStation, String description, int max, double lat, double lon);
        public void addBike(String idBike, String description, double kms, String idStation) throws StationFullException, StationNotFoundException;
        public List<Bike> bikesByStationOrderByKms(String idStation) throws StationNotFoundException;
        public Bike getBike(String stationId, String userId) throws UserNotFoundException, StationNotFoundException;
        public List<Bike> bikesByUser(String userId) throws UserNotFoundException;
        public int numUsers();
        public int numStations();
        public int numBikes(String idStation) throws StationNotFoundException;
        public void clear();
        Station[] getStations();
     }


