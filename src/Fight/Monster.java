package Fight;

public class Monster extends Fighter {
    private int handDamage;



    public Monster(String name) {
        super(name, 150);
        handDamage=15;

    }

    @Override
    public void hit(Fighter fighter) {
        if (getHealth() > 0 && fighter.getHealth() > 0) {
            fighter.decHealth(handDamage, this);
            System.out.println(getName() + " hits " + fighter.getName() + " with bare hands for " + handDamage + " damage. New health is " + fighter.getHealth());
        }
    }

    public int getHandDamage() {
        return handDamage;
    }
    public void setHandDamage(int handDamage) {
        this.handDamage = handDamage;
    }


}
