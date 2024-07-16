package Wep;


public abstract class Weapon {
    private int damage;
    private String type;

    public Weapon(int damage, String type) {
        this.damage = damage;
        this.type = type;
    }

    public abstract int use();

    public int getDamage() {
        return damage;
    }

    public String getType() {
        return type;
    }
}
