package com.metamong.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class SignUpFormValidator implements Validator {
    /**
     * 빈이 생성자가 1개이고, 파라메터 가 빈으로 등록되어 있다면,
     * 스프링 4.2 이후 버전 이상에서는 자동으로 빈을 주입해준다.
     * @autowired
     */
    private final AccountRepository accountRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(SignUpForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {

        //TODO E-MAIL, NICKNAME 검증
        SignUpForm signUpForm = (SignUpForm) target;

        if (accountRepository.existsByNickname(signUpForm.getNickname())) {
            errors.rejectValue("nickname",
                    "invalid.nickname",
                    new Object[]{signUpForm.getNickname()},
                    "이미 사용중인 닉네임 입니다."
            );
        }

        if (accountRepository.existsByEmail(signUpForm.getEmail())) {
            errors.rejectValue("email",
                    "invalid.email",
                    new Object[]{signUpForm.getEmail()},
                    "이미 사용중인 이메일 입니다."
            );
        }

    }
}
