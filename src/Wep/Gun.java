package Wep;

public class Gun extends Weapon {
    public Gun(int damage) {
        super(damage, "Gun");
    }

    @Override
    public int use() {
        return getDamage();
    }
}
