package RESTServer.handlers;

import com.google.gson.Gson;
import dal.repository.AgendaRepository;
import dal.repository.UserRepository;
import models.Appointment;
import models.PasswordHasher;
import response.Reply;

import java.util.Date;

public class AgendaHandler implements IAgendaHandler{

    private AgendaRepository repository;
    private Gson gson;
    private PasswordHasher passwordHasher;



    public AgendaHandler(AgendaRepository repository) {
        this.repository = repository;
        this.gson = new Gson();
        this.passwordHasher = new PasswordHasher();
    }
    //TODO: Add checks + error handling + implement
    @Override
    public Reply getAllAppointment(int userId) {
        return null;
    }

    @Override
    public Reply GetAppoinment(int AppointmentId) {
        return null;
    }

    @Override
    public Reply addAppointment(Appointment appointment) {
        return null;
    }

    @Override
    public Reply removeAppointment(int appointmentId) {
        return null;
    }

    @Override
    public Reply updateAppointment(Appointment appointment) {
        return null;
    }







}