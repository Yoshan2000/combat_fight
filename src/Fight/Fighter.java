package Fight;

import Wep.Weapon;

public class Fighter {
    private String name;
    private int health;
    private Weapon weapon;  // This will be null for the monster

    public Fighter(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void hit(Fighter opponent) {
        if (health > 0 && weapon != null) {
            int damage = weapon.use();
            opponent.decHealth(damage, this);
        }
    }

    public void decHealth(int damage, Fighter attacker) {
        this.health -= damage;
        System.out.println(attacker.getName() + " hits " + this.getName() + " with " + damage + " damage, new health is " + this.getHealth());
        if (this.getHealth() <= 0) {
            System.out.println(this.getName() + " is defeated.");
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
}
