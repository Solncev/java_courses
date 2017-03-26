package com.solncev;

import com.solncev.entity.Warrior;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Created by Марат on 20.02.2017.
 */
public class Main {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Warrior warrior = context.getBean(Warrior.class);
        warrior.attack();
    }
}
