package RESTServer.handlers;

import com.google.gson.Gson;
import logic.calendarLogic;
import models.PasswordHasher;
import models.User;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/calendar")
public class calendarResponse implements IUserHandler{

    private Gson gson;
    private PasswordHasher passwordHasher;
    calendarLogic logic = new calendarLogic();

    public calendarResponse() {
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
        if (logic.register(user)){
            List<User> users = logic.getStudents();
            users.forEach(s -> System.out.println(s.getEmailaddress()));
            System.out.println("registered");
            return Response.status(200).build();
        }
        else {
            return Response.status(400).entity(ResponseHelper.getErrorResponseString()).build();
        }
    }

//    User usertest = new User("test@mail.nl","1234");
//        test.saveStudent(usertest);



    @POST
    @Path("/user/login")
    @Consumes("application/json")
    @Produces("application/json")
    public Response login(String message) {
        return null;
    }

    @GET
    @Path("/test")
    public Response test(String message) {
        System.out.println("registered");
        List<User> users = logic.getStudents();
        if (users!=null){
            for (User user: users) {
            System.out.println(user.getEmailaddress());
            }
            return Response.status(200).build();
        }
        else {
            System.out.println("registered");
            return Response.status(400).entity(ResponseHelper.getErrorResponseString()).build();
        }

    }

}
