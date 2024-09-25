package Fight;

import Wep.Weapon;

public class Fighter {
    private String name;
    private int health;
    private Weapon weapon;

    private int damage;

    public Fighter(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }



    public void hit(Fighter opponent) {
        if (health > 0 && weapon != null) {
            damage = weapon.use();
            opponent.decHealth(damage, this);
            System.out.println(name + " hits " + opponent.getName() + " with " + weapon.getType() + " for " + damage + " damage. New health is " + opponent.getHealth());

        }
    }
    public void hit(Fighter opponent, double multiplier){
        if(health > 0 && opponent.health > 0 && weapon != null){
            damage = (int)(weapon.use()*multiplier);
            opponent.decHealth(damage, this);
            System.out.println(name + " hit  " + opponent.getName() + " with power  " + weapon.getType() + " for " + damage + " damage. New health after power hit is  " + opponent.getHealth());

        }
    }
    public void hit(Fighter opponent, int multiplier){
        hit(opponent, (double)multiplier);
    }


    public void decHealth(int damage, Fighter attacker) {
        this.health -= damage;
        if (health <0) {
            this.health=0;
        }
    }


    public String getName() {
        return name;
    }
    public int getHealth() {
        return health;
    }


    public Weapon getWeapon() {
        return weapon;
    }

    public void setHealth(int health) {
        this.health = health;
    }


}
