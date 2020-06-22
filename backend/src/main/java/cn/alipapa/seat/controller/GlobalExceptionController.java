package cn.alipapa.seat.controller;

import cn.alipapa.seat.bean.HttpResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionController {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionController.class);

    @ExceptionHandler(value = HttpMessageConversionException.class)
    @ResponseBody
    public HttpResponseBody invalidFormatExceptionHandler(HttpServletRequest req, Exception e) {
        logger.error("Exception caught:", e);
        var res = new HttpResponseBody();
        res.setStatus(400);
        res.setError("参数解析错误");
        return res;
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public HttpResponseBody exceptionHandler(HttpServletRequest req, Exception e) {
        logger.error("Exception caught:", e);
        var res = new HttpResponseBody();
        res.setStatus(500);
        res.setError("服务器未知异常，请稍后再试");
        return res;
    }
}
