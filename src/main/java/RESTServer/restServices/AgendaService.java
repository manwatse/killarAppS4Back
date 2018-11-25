package RESTServer.restServices;

import RESTServer.handlers.IAgendaHandler;
import models.Appointment;
import response.Reply;

import javax.annotation.security.PermitAll;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/Agenda")
public class AgendaService {
    private static IAgendaHandler handler;
    public  static  void setHandler(IAgendaHandler handler){AgendaService.handler= handler;}
    //TODO: Implement class

    @GET
    @Path("all/{id}")
    public Response getAllAppointmens(@PathParam("id") int userId){
    Reply reply = handler.getAllAppointment(userId);
    return Response.status(reply.getStatus().getCode()).entity(reply.getMessage()).build();
    }

    @POST
    @Path("/add")
    public Response addAppointment(Appointment appointment){
        Reply reply = handler.addAppointment(appointment);
        return Response.status(reply.getStatus().getCode()).entity(reply.getMessage()).build();
    }
    @PUT
    @Path("/edit")
    public Response editAppointment(Appointment appointment){
        Reply reply = handler.updateAppointment(appointment);
        return Response.status(reply.getStatus().getCode()).entity(reply.getMessage()).build();
    }
    @DELETE
    @Path("/delete/")
    public  Response deleteAppointment(int appointmentId){
        Reply reply = handler.removeAppointment(appointmentId);
        return Response.status(reply.getStatus().getCode()).entity(reply.getMessage()).build();
    }


}
