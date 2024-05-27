package dev.priyanshuvishnoi.springsecurityjwt.auth.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class RegisterUserReq {
    @NotBlank
    @Length(min = 3)
    private String username;

    @NotBlank
    @Length(min = 6, max = 30)
    private String password;
}
