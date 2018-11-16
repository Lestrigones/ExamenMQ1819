package edu.upc.dsa.services;
import edu.upc.dsa.controller.MyBike;
import edu.upc.dsa.controller.MyBikeImpl;
import edu.upc.dsa.exceptions.StationNotFoundException;
import edu.upc.dsa.exceptions.UserNotFoundException;
import edu.upc.dsa.model.Bike;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.Path;

public class BikeService {

    private MyBike mb;

    public BikeService() throws Exception {

        this.mb = MyBikeImpl.getInstance();
        this.mb.addUser("user1", "Juan", "Lopex");

        this.mb.addStation("Station1", "description:: station1", 10, 3, 3);
        this.mb.addStation("Station2", "description:: station2", 10, 3, 3);

        this.mb.addBike("bike101", "descripton", 25.45, "Station1");
        this.mb.addBike("bike102", "descripton", 70.3, "Station1");
        this.mb.addBike("bike103", "descripton", 10.2, "Station1");
        this.mb.addBike("bike201", "descripton", 1325.45, "Station2");
        this.mb.addBike("bike202", "descripton", 74430.3, "Station2");
        this.mb.addBike("bike203", "descripton", 1320.2, "Station2");

    }
    //Get Bike
    @GET
    @ApiOperation(value = "getBike", notes = "esperando idStation")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Correcto", response = Bike.class),
            @ApiResponse(code = 404, message = "Bici no encontrada")

    })

    @Path("/{idStation}/{idUsuario}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBike(@PathParam("idStation") String idStation, @PathParam("idUsuario") String idUsuario) throws StationNotFoundException, UserNotFoundException {

        Bike p = this.mb.getBike(idStation, idUsuario);
        if (p == null) return Response.status(404).build();
        else return Response.status(201).entity(p).build();

    }

//addBike
    @POST
    @ApiOperation(value = "PostBike", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Bike.class),
            @ApiResponse(code = 404, message = "Bike not found")

    })

    @Path("/{idStation}/{idUsuario}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response postBike(@PathParam("idStation") String idStation, @PathParam("idUsuario") String idUsuario) throws StationNotFoundException, UserNotFoundException {
        Bike p = this.mb.getBike(idStation, idUsuario);
        if (p == null) return Response.status(404).build();
        else  return Response.status(201).entity(p).build();

    }







}
