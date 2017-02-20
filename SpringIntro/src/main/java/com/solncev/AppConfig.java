package com.solncev;

import com.solncev.entity.impl.Archer;
import com.solncev.entity.impl.Bow;
import com.solncev.entity.impl.Shield;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Марат on 20.02.2017.
 */
@Configuration
@ComponentScan("com.solncev")
public class AppConfig {
    @Bean
    public Archer archer() {
        Archer archer = new Archer();
        return archer;
    }

    @Bean
    public Bow bow() {
        Bow bow = new Bow();
        bow.setDamage(10);
        return bow;
    }

    @Bean
    public Shield shield() {
        Shield shield = new Shield("wood");
        return shield;
    }
}
