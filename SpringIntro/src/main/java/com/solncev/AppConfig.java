package com.solncev;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by Марат on 20.02.2017.
 */
@EnableAspectJAutoProxy
@Configuration
@ComponentScan("com.solncev.entity")
public class AppConfig {

}
