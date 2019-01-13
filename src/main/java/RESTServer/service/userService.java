package RESTServer.service;

import RESTServer.RestServer;
import RESTServer.handlers.IAppointmentHandler;
import RESTServer.handlers.IUserHandler;
import RESTServer.handlers.UserHandler;
import com.google.gson.Gson;

import models.Appointment;
import models.PasswordHasher;
import models.User;
import response.Reply;
import utils.GsonUtils;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("user")
public class userService{
    private  static RESTServer.handlers.IUserHandler handler;

    public static void setHandler(IUserHandler iUserHandler)
    { userService.handler = iUserHandler;}

//    private Gson gson;
//    private PasswordHasher passwordHasher;
//
//
//    public userService() {
//        this.gson = new Gson();
//        this.passwordHasher = new PasswordHasher();
//
//    }

    @POST
    @Path("/register")
    @Consumes("application/json")
    @Produces("application/json")
    public Response register(String data) {
        User user = GsonUtils.fromJson(data, User.class);
        Reply reply = handler.saveUser(user);
        return Response.status(reply.getStatus().getCode()).entity(reply.getMessage()).build();
    }

    @GET
    @Path("/login")
    @Consumes("application/json")
    @Produces("application/json")
    public Response login(String data){
        User user = GsonUtils.fromJson(data, User.class);
        Reply reply = handler.getUser(user);
        return Response.status(reply.getStatus().getCode()).entity(reply.getMessage()).build();
    }


}
