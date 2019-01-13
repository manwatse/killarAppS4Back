package shared.dto.request;

import models.User;

public class UpdateAppointmentRequestDto {
    int userid;
    User user;

    public UpdateAppointmentRequestDto(int userid, User user) {
        this.userid = userid;
        this.user = user;
    }

    public int getUserid() {
        return userid;
    }

    public User getUser() {
        return user;
    }
}
