package RESTServer.handlers;

import com.google.gson.Gson;
import models.PasswordHasher;
import models.User;
import response.Reply;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.awt.image.RescaleOp;

<<<<<<< Updated upstream
public class UserHandler implements IUserHandler {

=======
@Path("/Calendar")
public class UserHandler implements IUserHandler{
    private UserRepository repository;
>>>>>>> Stashed changes
    private Gson gson;
    private PasswordHasher passwordHasher;

    public UserHandler() {

        this.gson = new Gson();
        this.passwordHasher = new PasswordHasher();
    }

    //TODO: Add checks + error handling + implement

    @POST
    @Path("/user/register")
    @Consumes("application/json")
    @Produces("application/json")

    public Response register(String message) {
        User user = gson.fromJson(message, User.class);
        if (user==null){
            return Response.status(400).entity(ResponseHelper.getErrorResponseString()).build();
        }


        return null;
    }

    @POST
    @Path("/user/login")
    @Consumes("application/json")
    @Produces("application/json")
    public Response login(String message) {
        return null;
    }

}
