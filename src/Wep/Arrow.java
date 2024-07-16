package Wep;
public class Arrow extends Weapon {
    public Arrow(int damage) {
        super(damage, "Arrow");
    }

    @Override
    public int use() {
        return getDamage();
    }
}