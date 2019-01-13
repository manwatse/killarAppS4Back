package RESTServer.handlers;

import com.google.gson.Gson;
import dal.repository.AppointmentRepository;
import logging.Logger;
import models.Appointment;
import response.AppointmentJson;
import response.ErrorJson;
import response.Reply;
import response.Status;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppointmentHandler implements IAppointmentHandler {

    private AppointmentRepository appointmentRepository;
    private Gson gson;

    public AppointmentHandler(AppointmentRepository appointmentRepository){
        this.appointmentRepository=appointmentRepository;
        this.gson = new Gson();
    }

    @Override
    public Reply getAppointments() {
        try {
            List<AppointmentJson> appointmentReponse = new ArrayList<>();

            for (Appointment a : appointmentRepository.findAll()) {
                appointmentReponse.add(new AppointmentJson(a.getId(), a.getName(),a.getBeginDate(),a.getEndDate()));
            }

            String json = gson.toJson(appointmentReponse);
            return new Reply(Status.OK, json);
        } catch (Exception e) {
            Logger.getInstance().log(e);
            ErrorJson errorJson = new ErrorJson("Something went wrong");

            return new Reply(Status.ERROR, gson.toJson(errorJson));
        }
    }

    @Override
    public Reply getAppointment(int appointmentid) {
        Appointment appointment = appointmentRepository.findOne(appointmentid);

        if (appointment != null) {
            String json = gson.toJson(appointment);

            return new Reply(Status.OK, json);
        }

        ErrorJson errorJson = new ErrorJson("Something went wrong");
        return new Reply(Status.ERROR, gson.toJson(errorJson));
    }

    @Override
    public Reply saveAppointment(Appointment appointment) {
        Appointment saved = appointmentRepository.save(appointment);

        if (saved != null) {
            String json = gson.toJson(saved);

            return new Reply(Status.OK, json);
        }

        ErrorJson errorJson = new ErrorJson("Something went wrong");
        return new Reply(Status.ERROR, gson.toJson(errorJson));
    }

    @Override
    public Reply deleteAppointment(int appointmentid) {
        try {
            appointmentRepository.delete(appointmentid);
            ErrorJson messageJson = new ErrorJson("Deleted");

            return new Reply(Status.OK, gson.toJson(messageJson));
        } catch (Exception e) {
            ErrorJson errorJson = new ErrorJson("Something went wrong");

            return new Reply(Status.ERROR, gson.toJson(errorJson));
        }
    }

    @Override
    public Reply updateAppointment(Appointment appointment) {
        Appointment saved = appointmentRepository.save(appointment);

        if (saved.getId() == appointment.getId()) {
            return new Reply(Status.OK, gson.toJson(saved));
        }

        ErrorJson errorJson = new ErrorJson("Something went wrong");
        return new Reply(Status.ERROR, gson.toJson(errorJson));
    }
    @Override
    public void addAppointmentTest(){

        Date date = new Date();
        Appointment appointment1=new Appointment(1,"name",date,date);
        Appointment appointment2=new Appointment(1,"name",date,date);
        Appointment appointment3=new Appointment(1,"name",date,date);
        Appointment appointment4=new Appointment(1,"name",date,date);
        Appointment appointment5=new Appointment(1,"name",date,date);

        appointmentRepository.save(appointment1);
        appointmentRepository.save(appointment2);
        appointmentRepository.save(appointment3);
        appointmentRepository.save(appointment4);
        appointmentRepository.save(appointment5);

    }
}
