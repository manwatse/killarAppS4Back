package shared.dto.request;

import models.User;

public class DeleteAppointmentRequestDto {
    int userid;
    User user;

    public DeleteAppointmentRequestDto(int userid, User user) {
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
