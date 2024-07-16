package Wep;

public class Sword extends Weapon {
    public Sword(int damage) {
        super(damage, "Sword");
    }

    @Override
    public int use() {
        return getDamage();
    }
}
