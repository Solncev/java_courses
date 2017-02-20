package com.solncev.entity.impl;

import com.solncev.entity.Armor;
import org.springframework.stereotype.Component;

/**
 * Created by Марат on 20.02.2017.
 */
@Component
public class Shield implements Armor {
    private String material;

    public Shield(String material) {
        this.material = material;
    }

    public void toProtect() {
        System.out.println("protect");
    }
}
