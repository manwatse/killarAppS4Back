package RESTServer.handlers;

import com.google.gson.Gson;
import dal.repository.UserRepository;
import models.PasswordHasher;
import response.Reply;

public class UserHandler  implements  IUserHandler{
    private UserRepository repository;
    private Gson gson;
    private PasswordHasher passwordHasher;

    public UserHandler(UserRepository repository) {
        this.repository = repository;
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
