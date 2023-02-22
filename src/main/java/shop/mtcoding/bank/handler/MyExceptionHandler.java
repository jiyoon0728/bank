package shop.mtcoding.bank.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;

import shop.mtcoding.bank.handler.ex.CustomException;

public class MyExceptionHandler {
    // 자바스크립트를 응답
    @ExceptionHandler(CustomException.class)
    public String basicException(Exception e) {
        StringBuilder sb = new StringBuilder();
        sb.append("<script>");
        sb.append("alert('" + e.getMessage() + "');");
        sb.append("history.back();");
        sb.append("</script>");
        return sb.toString();
    }
    // DTO를 응답
}