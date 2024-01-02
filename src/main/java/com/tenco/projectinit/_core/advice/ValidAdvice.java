package com.tenco.projectinit._core.advice;

import com.tenco.projectinit._core.errors.exception.Exception400;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.List;

@Aspect
@Component
public class ValidAdvice {
    // 별칭 등록

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void postMapping() {
    }

    // 공통 기능
    @Before("postMapping()")
    public void checkValid(JoinPoint jp) {
        Object[] args = jp.getArgs();
        for (Object arg : args) {
            if (arg instanceof Errors) {
                Errors errors = (Errors) arg;

                if (errors.hasErrors()) {
                    List<FieldError> fieldErrors = errors.getFieldErrors();
                    throw new Exception400(
                            fieldErrors.get(0).getDefaultMessage() + ":" + fieldErrors.get(0).getField());
                }
            }
        }
    }
}
