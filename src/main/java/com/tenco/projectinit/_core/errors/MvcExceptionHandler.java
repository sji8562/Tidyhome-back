package com.tenco.projectinit._core.errors;

import com.tenco.projectinit._core.errors.exception.CustomRestfullException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MvcExceptionHandler {

    @ExceptionHandler(CustomRestfullException.class)
    public String basicException(CustomRestfullException e) {

        System.out.println("여기로 왔어??????" + e.getMessage());

        StringBuffer sb = new StringBuffer();
        sb.append("<script>");
        sb.append("alert( '" + e.getMessage() + "' );");
        sb.append("history.back()");
        sb.append("</script>");

        return sb.toString();
    }
}