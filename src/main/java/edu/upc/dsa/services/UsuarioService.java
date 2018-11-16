package edu.upc.dsa.services;
import edu.upc.dsa.controller.MyBike;
import edu.upc.dsa.controller.MyBikeImpl;
import edu.upc.dsa.exceptions.StationNotFoundException;
import edu.upc.dsa.model.Bike;
import edu.upc.dsa.model.Station;
import edu.upc.dsa.model.Usuario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;




@Api(value = "/usuarios", description = "Endpoint to Product Service")
@Path("/usuarios")
public class UsuarioService {
    private MyBike mb;

    public UsuarioService() throws Exception {

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

    @POST
    @Path("/adduser/{id}/{name}/{surname}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser(@PathParam("id") String id,@PathParam("name") String name,@PathParam("surname") String surname){
        mb.addUser(id, name, surname);
        return Response.status(201).build();

    }





}


