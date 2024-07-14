package Wep;

public class Sword extends Weapon{

    public Sword(int damage){
        super(damage);
    }

    @Override
    public int use(){
        return getDamage() + (int)(Math.random()*8);
    }
}
