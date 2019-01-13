package RESTServer.service;

import RESTServer.handlers.IAppointmentHandler;
import models.Appointment;
import response.Reply;
import utils.GsonUtils;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
@Path("/appointments")
public class AppointmentService {

    private  static RESTServer.handlers.IAppointmentHandler handler;


    public static void setHandler(IAppointmentHandler iAppointmentHandler)
    { AppointmentService.handler = iAppointmentHandler;}


    @GET
    @Path("/all")
    public Response getAllAppointment() {
        Reply reply = handler.getAppointments();
        return Response.status(reply.getStatus().getCode()).entity(reply.getMessage()).build();
    }

    @GET
    @Path("/{id}")
    public Response GetAppoinment(int AppointmentId) {
        Reply reply = handler.getAppointment(AppointmentId);
        return Response.status(reply.getStatus().getCode()).entity(reply.getMessage()).build();
    }

    @POST
    @Path("/save")
    @Consumes("application/json")
    public Response addAppointment(String data) {
        Appointment appointment1 = GsonUtils.fromJson(data, Appointment.class);
        Reply reply = handler.saveAppointment(appointment1);
        return Response.status(reply.getStatus().getCode()).entity(reply.getMessage()).build();
    }

    @DELETE
    @Path("delete/{id}")
    @Consumes("application/json")
    public Response removeAppointment(@PathParam("id") int appointmentId) {
        Reply reply = handler.deleteAppointment(appointmentId);

        return Response.status(reply.getStatus().getCode()).entity(reply.getMessage()).build();
    }

    @PUT
    @Path("/edit")
    @Consumes("application/json")
    public Response updateAppointment(String data) {
        Appointment appointment= GsonUtils.fromJson(data, Appointment.class);
        Reply reply = handler.updateAppointment(appointment);
        return Response.status(reply.getStatus().getCode()).entity(reply.getMessage()).build();
    }


}
