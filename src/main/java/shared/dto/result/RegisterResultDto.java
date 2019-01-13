package shared.dto.result;

import models.User;
import shared.dto.BaseResultDto;

public class RegisterResultDto extends BaseResultDto {
    User user;

    public RegisterResultDto(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
