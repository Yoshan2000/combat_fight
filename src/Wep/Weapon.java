package Wep;


import java.util.Random;

public abstract class Weapon {
    private int damage;
    private String type;

    public Weapon(int damage, String type) {

        this.type = type;
        this.damage=damage;
    }

    public abstract int use();

    public int getDamage() {
        return damage;
    }


    public String getType() {

        return type;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
}
