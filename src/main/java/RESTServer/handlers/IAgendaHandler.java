package RESTServer.handlers;
import models.Appointment;
import response.Reply;

import java.util.Date;

public interface IAgendaHandler {

    Reply getAllAppointment(int userId);
    Reply GetAppoinment(int AppointmentId);
    Reply addAppointment(Appointment appointment);
    Reply removeAppointment(int appointmentId);
    Reply updateAppointment(Appointment appointment);

}
