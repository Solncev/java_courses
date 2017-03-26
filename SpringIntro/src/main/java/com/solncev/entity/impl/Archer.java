package com.solncev.entity.impl;

import com.solncev.entity.Armor;
import com.solncev.entity.Warrior;
import com.solncev.entity.Weapon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Марат on 20.02.2017.
 */
@Component
public class Archer implements Warrior {

    private Armor armor;
    private Weapon weapon;
    private int health = 100;

    @Autowired
    public Archer(Armor armor, Weapon weapon) {
        this.armor = armor;
        this.weapon = weapon;
    }

    public void attack() {
        System.out.print("archer ");
        weapon.attack();
    }

    public void toProtect() {
        System.out.print("archer ");
        armor.toProtect();
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
