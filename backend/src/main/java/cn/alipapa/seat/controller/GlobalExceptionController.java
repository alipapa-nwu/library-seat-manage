package cn.alipapa.seat.controller;

import cn.alipapa.seat.bean.HttpResponseBody;
import cn.alipapa.seat.exception.CustomException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalExceptionController {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionController.class);

    @ExceptionHandler(value = HttpMessageConversionException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HttpResponseBody invalidFormatExceptionHandler(HttpServletRequest req, HttpServletResponse res, Exception e) {
        logger.error("Exception caught:", e);
        var body = new HttpResponseBody();
        body.setStatus(400);
        body.setError("参数解析错误");
        return body;
    }

    @ExceptionHandler(value = CustomException.class)
    @ResponseBody
    public HttpResponseBody customExceptionHandler(HttpServletRequest req, HttpServletResponse res, CustomException e) {
        logger.error("Exception caught:", e);
        res.setStatus(e.httpStatus());
        var body = new HttpResponseBody();
        body.setStatus(e.httpStatus());
        body.setError(e.getMessage());
        return body;
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public HttpResponseBody exceptionHandler(HttpServletRequest req, HttpServletResponse res, Exception e) {
        logger.error("Exception caught:", e);
        var body = new HttpResponseBody();
        body.setStatus(500);
        body.setError("服务器未知异常，请稍后再试");
        return body;
    }
}
