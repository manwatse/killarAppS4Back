package RESTServer.handlers;

import models.User;
import response.Reply;

public interface IUserHandler {
    Reply getUser(User user);
    Reply saveUser(User user);
}
