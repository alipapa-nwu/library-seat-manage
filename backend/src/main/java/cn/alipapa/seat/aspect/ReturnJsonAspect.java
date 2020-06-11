package cn.alipapa.seat.aspect;

import cn.alipapa.seat.bean.HttpResponseBody;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ReturnJsonAspect {
    @Pointcut("execution(public Object cn.alipapa.seat.service..*(*))")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object aroundBeanToString(ProceedingJoinPoint joinPoint) throws Throwable {
        // 正常执行方法，获取返回值
        var args = joinPoint.getArgs();
        var res = joinPoint.proceed(args);
        // 如果res为空，抛异常
        if (res == null)
            throw new NullPointerException("null return value of service " + joinPoint.getThis().getClass().getName());
        // 创建一个返回结构
        var returnJson = new HttpResponseBody();
        // 状态码200
        returnJson.setStatus(200);
        // 设置原方法返回值为返回json的data字段
        returnJson.setData(res);
        // 替换返回值
        return returnJson;
    }
}
