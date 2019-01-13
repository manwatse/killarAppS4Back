package RESTServer.service;

import com.google.gson.Gson;

import models.Appointment;
import shared.dto.BaseResultDto;

import shared.dto.result.AddAppointmentResultDto;
import shared.dto.result.BoolResultDto;

import shared.dto.result.LoadAppointmentsResultDto;
import shared.dto.result.LoginResultDto;

import java.util.ArrayList;

public class ResponseHelper {
    private ResponseHelper() {
    }

    private static final Gson gson = new Gson();

    public static String getErrorResponseString() {
        BaseResultDto response = new BaseResultDto();
        response.setSuccess(false);
        return gson.toJson(response);
    }

    public static String getBoolResultDtoString(boolean check){
        BoolResultDto response = new BoolResultDto(check);
        response.setSuccess(true);
        return gson.toJson(response);
    }

    public static String getLoginResultDtoString(int userId){
        LoginResultDto response = new LoginResultDto(userId);
        response.setSuccess(true);
        return gson.toJson(response);
    }

    public static String getAddAppointmentResultDtoString(Appointment appointment){
        AddAppointmentResultDto response = new AddAppointmentResultDto(appointment);
        response.setSuccess(true);
        return gson.toJson(response);
    }

    public static String getLoadBooksResultDtoString(ArrayList<Appointment> appointments){
        LoadAppointmentsResultDto response = new LoadAppointmentsResultDto(appointments);
        response.setSuccess(true);
        return gson.toJson(response);
    }
}
