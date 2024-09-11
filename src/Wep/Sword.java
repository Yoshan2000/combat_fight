package Wep;

import java.util.Random;

public class Sword extends Weapon {


    public Sword(int damage, String type) {
        super(damage, type);

    }

    @Override
    public int use() {
        return getDamage() ;
    }
}
