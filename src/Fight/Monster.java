package Fight;

import java.util.Random;

public class Monster extends Fighter {
    private final int handDamage;

    public Monster(String name, int health, int handDamage) {
        super(name, health);
        this.handDamage = handDamage;
    }


    public void hit(Fighter fighter) {
        if (getHealth() > 0 && fighter.getHealth() > 0) {
            fighter.decHealth(handDamage, this);
            System.out.println(getName() + " hits " + fighter.getName() + " with " + handDamage + " damage. " + fighter.getName() + "'s new health is " + fighter.getHealth());
        }
    }
}
