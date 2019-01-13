package shared.dto.result;

import models.Appointment;
import shared.dto.BaseResultDto;

public class AddAppointmentResultDto extends BaseResultDto {

    Appointment appointment;

    public AddAppointmentResultDto(Appointment appointment) {
        this.appointment = appointment;
    }

    public Appointment getAppointment() {
        return appointment;
    }
}
