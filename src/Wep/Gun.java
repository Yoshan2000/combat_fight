package Wep;

import java.util.Random;

public class Gun extends Weapon {
    private Random random;
    public Gun(int damage, String type) {
        super(damage, type);
        random = new Random();

    }

    @Override
    public int use() {
        int variation=(int)(getDamage()*0.2);
        int randomDamage=random.nextInt(variation + 2+1)-variation;
        return getDamage() +randomDamage;
    }
}
