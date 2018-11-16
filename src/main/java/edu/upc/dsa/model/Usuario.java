package edu.upc.dsa.model;
import java.util.ArrayList;
import java.util.List;
public class Usuario {

    private String idUser;
    private String nombre;
    private String surname;
    private List<Bike> bicisDelUsuario;

    public Usuario(){}

    public Usuario(String idUser, String nombre,String surname){
        this.idUser=idUser;
        this.nombre=nombre;
        this.surname=surname;
        this.bicisDelUsuario= new ArrayList<>();

    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Bike> getBicisDelUsuario() {
        return bicisDelUsuario;
    }

    public void setBicisDelUsuario(List<Bike> bicisDelUsuario) {
        this.bicisDelUsuario = bicisDelUsuario;
    }
    public void addBici(Bike b){
        this.bicisDelUsuario.add(b);
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getSurname(String surname) {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


}


