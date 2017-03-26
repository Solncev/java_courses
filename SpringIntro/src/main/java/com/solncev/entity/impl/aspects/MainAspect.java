package com.solncev.entity.impl.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by Марат on 07.03.2017.
 */
@Component
@Aspect
public class MainAspect {
    @After("execution(* com.solncev.entity.impl.Archer.attack(..))")
    public void start(JoinPoint joinPoint) {
        System.out.println("attack method was launched");
    }
}
