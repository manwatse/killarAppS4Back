package RESTServer.handlers;

import com.google.gson.Gson;
import dal.repository.AppointmentRepository;
import dal.repository.UserRepository;
import models.Appointment;
import models.User;
import response.ErrorJson;
import response.Reply;
import response.Status;

public class UserHandler implements IUserHandler {

    private UserRepository userRepository;
    private Gson gson;


    public UserHandler(UserRepository userRepository){
        this.userRepository=userRepository;
        this.gson= new Gson();
    }


    @Override
    public Reply getUser(User user) {
        User account = userRepository.findOne(user);

        if (account != null) {
            String json = gson.toJson(account);

            return new Reply(Status.OK, json);
        }

        ErrorJson errorJson = new ErrorJson("Something went wrong");
        return new Reply(Status.ERROR, gson.toJson(errorJson));
    }

    @Override
    public Reply saveUser(User user) {
        User saved = userRepository.save(user);

        if (saved != null) {
            String json = gson.toJson(saved);

            return new Reply(Status.OK, json);
        }

        ErrorJson errorJson = new ErrorJson("Something went wrong");
        return new Reply(Status.ERROR, gson.toJson(errorJson));
    }
}
