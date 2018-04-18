package com.eliastin.echo;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author Elias 2018/04/18 20:02
 */
@Aspect
@Component
public class LogAspect {

    @Before(value = "@annotation(Loggable) && @annotation(loggable)")
    public void log(Loggable loggable) {
        System.out.printf("打印日志：%s", loggable.value());
    }
}
