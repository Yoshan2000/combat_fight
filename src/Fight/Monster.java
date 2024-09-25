package Fight;

public class Monster extends Fighter {
    public int handDamage;



    public Monster(String name) {
        super(name, 200);
        handDamage=15;

    }

    @Override
    public void hit(Fighter fighter) {
        if (getHealth() > 0 && fighter.getHealth() > 0) {
            fighter.decHealth(handDamage, this);
            System.out.println(getName() + " hits " + fighter.getName() + " with bare hands for " + handDamage + " damage. New health is " + fighter.getHealth());
        }
    }




}
