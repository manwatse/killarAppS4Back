package shared.dto.result;

import models.Appointment;
import shared.dto.BaseResultDto;

public class UpdateAppointmentResultDto extends BaseResultDto {

    Appointment appointment;

    public UpdateAppointmentResultDto(Appointment appointment) {
        this.appointment = appointment;
    }

    public Appointment getAppointment() {
        return appointment;
    }
}
