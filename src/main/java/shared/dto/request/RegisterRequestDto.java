package shared.dto.request;

import shared.dto.BaseRequestDto;

public class RegisterRequestDto extends BaseRequestDto {
    String email;
    String password;

    public RegisterRequestDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
