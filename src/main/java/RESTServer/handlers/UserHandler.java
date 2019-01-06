package RESTServer.handlers;

import com.google.gson.Gson;
import models.PasswordHasher;
import response.Reply;

public class UserHandler implements IUserHandler {

    private Gson gson;
    private PasswordHasher passwordHasher;

    public UserHandler() {

        this.gson = new Gson();
        this.passwordHasher = new PasswordHasher();
    }

    //TODO: Add checks + error handling + implement
    @Override
    public Reply register(String emailaddress, String password) {
        return null;
    }

    @Override
    public Reply login(String emailaddress, String password) {
        return null;
    }

    @Override
    public Reply editUser() {
        return null;
    }

    @Override
    public Reply getAll() {
        return null;
    }
}
