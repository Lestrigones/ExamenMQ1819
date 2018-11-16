package edu.upc.dsa.services;
import edu.upc.dsa.controller.MyBike;
import edu.upc.dsa.controller.MyBikeImpl;
import edu.upc.dsa.model.Bike;
import edu.upc.dsa.model.Station;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;





@Api(value = "/stations", description = "Endpoint to Product Service")
@Path("/stations")
public class StationService {
    private MyBike mb;
    public StationService() throws Exception {
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
    @GET
    @ApiOperation(value = "get  todas las estaciones", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Station.class),
            @ApiResponse(code = 404, message = "Stations not found")
    })

    @Path("/getStations")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStations() {
        Station[] stations = this.mb.getStations();
        GenericEntity<Station[]> entity = new GenericEntity<Station[]>(stations) {
        };
        return Response.status(201).entity(entity).build();

    }





    //em dona 10 quan crec que haurien de ser 2

    @GET

    @ApiOperation(value = "get  todas las estaciones", notes = "asdasd")

    @ApiResponses(value = {

            @ApiResponse(code = 201, message = "Successful", response = Station.class),

            @ApiResponse(code = 404, message = "Stations not found")

    })

    @Path("/getnumStations")

    @Produces(MediaType.TEXT_PLAIN)

    public Response getnumStations() {

        //int i = this.mb.numStations();

        Station[] stations = this.mb.getStations();

        int i = 0;

        i = stations.length;

        return Response.status(201).entity(i).build();





    }

}





