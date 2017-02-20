package com.solncev.entity.impl;

import com.solncev.entity.Weapon;
import org.springframework.stereotype.Component;

/**
 * Created by Марат on 20.02.2017.
 */
@Component
public class Bow implements Weapon {
    private int damage;

    public void attack() {
        System.out.println("attack");
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
