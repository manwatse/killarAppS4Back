package RESTServer.handlers;

import models.Appointment;
import response.Reply;

public interface IAppointmentHandler {
    Reply getAppointments();
    Reply getAppointment(int appointmentid);
    Reply saveAppointment(Appointment appointment);
    Reply deleteAppointment(int appointmentid);
    Reply updateAppointment(Appointment appointment);
    void addAppointmentTest();
}
