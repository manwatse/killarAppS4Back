package RESTServer;

import RESTServer.handlers.*;
import RESTServer.restServices.AgendaService;
import RESTServer.restServices.UserService;
import logging.Logger;
import models.User;
import org.eclipse.jetty.server.*;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.glassfish.jersey.servlet.ServletContainer;

import javax.servlet.DispatcherType;
import java.util.EnumSet;
import java.util.List;

public class RestServer {
    private static final int PORT = 8099;

    public static void main(String[] args) {
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        Server jettyServer = new Server(PORT);

        // region Origin header
        FilterHolder cors = context.addFilter(CrossOriginFilter.class, "/*", EnumSet.of(DispatcherType.REQUEST));
        cors.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "*");
        cors.setInitParameter(CrossOriginFilter.ACCESS_CONTROL_ALLOW_ORIGIN_HEADER, "*");
        cors.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "GET,POST,DELETE,PUT,HEAD");
        cors.setInitParameter(CrossOriginFilter.ALLOWED_HEADERS_PARAM, "X-Requested-With,Content-Type,Accept,Origin");
        // endregion

        jettyServer.setHandler(context);
        ServletHolder jerseyServlet = context.addServlet(ServletContainer.class, "/*");
        jerseyServlet.setInitOrder(0);

        // Creating and settings handlers

        IUserHandler userHandler = new UserHandler();
        UserService.setHandler(userHandler);

        IAgendaHandler agendaHandler = new AgendaHandler();
        AgendaService.setHandler(agendaHandler);

        //test hiber

        testHandler test= new testHandler();
        User usertest = new User("test@mail.nl","1234");
        test.saveStudent(usertest);

        List<User> users = test.getStudents();
        users.forEach(s -> System.out.println(s.getEmailaddress()));

        // Tells the Jersey Servlet which REST service/class to load
        jerseyServlet.setInitParameter("jersey.config.server.provider.packages", "SimsRESTServer.restservices");

        try {
            jettyServer.start();
            jettyServer.join();;

        } catch (Exception e) {
            Logger.getInstance().log(e);
        } finally {
            jettyServer.destroy();
        }
    }
}

