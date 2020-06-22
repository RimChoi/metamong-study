package com.metamong.account;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class SignUpForm {
    @NotBlank
    @Length(min = 3, max = 20)
    @Pattern(regexp = "^[a-z0-9ㄱ-ㅎ가-힣_-]{3,20}$")
    private String nickname;

    @NotBlank
    private String email;

    @NotBlank
    @Length(min = 8, max = 30)
    private String password;
}
