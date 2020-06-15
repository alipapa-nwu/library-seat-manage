package cn.alipapa.seat.conf;

import cn.alipapa.seat.bean.HttpResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

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
