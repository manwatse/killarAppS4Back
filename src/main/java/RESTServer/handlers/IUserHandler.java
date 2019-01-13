package RESTServer.handlers;

import response.Reply;

import javax.ws.rs.core.Response;

public interface IUserHandler {
    Response register(String message);
    Response login(String message);

}
