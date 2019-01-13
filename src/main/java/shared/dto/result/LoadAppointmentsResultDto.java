package shared.dto.result;

import models.Appointment;
import shared.dto.BaseResultDto;

import java.util.ArrayList;

public class LoadAppointmentsResultDto extends BaseResultDto {
    ArrayList<Appointment> appointments;

    public LoadAppointmentsResultDto(ArrayList<Appointment> appointments) {
        this.appointments = appointments;
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }
}
