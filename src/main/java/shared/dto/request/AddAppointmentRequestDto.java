package shared.dto.request;

import models.Appointment;
import models.User;

public class AddAppointmentRequestDto {
    int userid;
    Appointment appointment;

    public AddAppointmentRequestDto(int userid, Appointment appointment) {
        this.userid = userid;
        this.appointment = appointment;
    }

    public int getUserid() {
        return userid;
    }

    public Appointment getAppointment() {
        return appointment;
    }
}
