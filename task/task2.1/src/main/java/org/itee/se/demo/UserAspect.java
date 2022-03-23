package org.itee.se.demo;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.itee.se.demo.Service.UserServiceImpl;
import org.itee.se.demo.pojo.UserCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class UserAspect {
    private static Logger logger = Logger.getLogger(UserServiceImpl.class);
    @Autowired
    private UserCache cache;

    @After(value = "execution(* org.itee.se.demo.*.*(..))")
    public void after(JoinPoint jp) {
        logger.debug("debug访问日志");
        System.out.println("被after增强的方法名：" + jp.getSignature().toLongString());
        System.out.println("方法参数个数：" + jp.getArgs().length);
        System.out.println("参数：" + Arrays.toString(jp.getArgs()));
        System.out.println("==========after完成====================");
    }

    @Around(value = "execution(* org.itee.se.demo.*.addUser(..))")
    public Object around1(ProceedingJoinPoint pjp) {
        Object obj = null;
        String userName = cache.getUserName();
        if (userName.equals("admin")) {
            try {
                obj = pjp.proceed();
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
        else System.out.println("权限不足，不能addUser");
        return obj;
    }

    @Around(value = "execution(* org.itee.se.demo.*.deleteUser(..))")
    public Object around2(ProceedingJoinPoint pjp) {
        Object obj = null;
        String userName = cache.getUserName();
        if (userName.equals("admin")) {
            try {
                obj = pjp.proceed();
            } catch (Throwable e) {
                e.printStackTrace();
                System.out.println("权限不足");
            }
        }
        else System.out.println("权限不足，不能deleteUser");
        return obj;
    }
}
