package com.solncev;

import com.solncev.entity.impl.Archer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Марат on 20.02.2017.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
//        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Archer archer = context.getBean("archer", Archer.class);
        archer.attack();
        archer.toProtect();
    }
}
