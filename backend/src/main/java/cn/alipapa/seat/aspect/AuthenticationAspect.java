package cn.alipapa.seat.aspect;

import cn.alipapa.seat.dao.UserDao;
import cn.alipapa.seat.exception.AccessDeniedException;
import cn.alipapa.seat.exception.LoginException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(Ordered.HIGHEST_PRECEDENCE)
public class AuthenticationAspect {

    @Autowired
    UserDao userDao;

    @Pointcut("@annotation(cn.alipapa.seat.annotation.PrivateRequestHandler)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object authenticateRequest(ProceedingJoinPoint joinPoint) throws Throwable {
        // 获取参数
        var args = joinPoint.getArgs();
        // 获取认证信息，约定第二个参数为openId, 第三个为sessionId
        var openId = ((String) args[1]);
        var sessionId = ((String) args[2]);
        // 查找user表，校验认证信息
        var user = userDao.getUserInformation(openId);
        // 错误处理
        if (user == null) {
            throw new LoginException("登录失败：用户不存在");
        } else if (!user.getSession_id().equals(sessionId)) {
            throw new AccessDeniedException("登陆失败：认证已过期");
        }
        // 约定第四个参数为获取到的用户信息
        args[3] = user;
        return joinPoint.proceed(args);
    }
}
