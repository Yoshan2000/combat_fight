package Wep;

public abstract class Weapon {
    private int damage;

    public Weapon(int damage) {
        this.damage = damage;
    }

    public abstract int use();

    public int getDamage() {
        return damage;
    }
}
