package Fight;

import Wep.Weapon;

public class Fighter {
    private String name;
    private int health;
    private Weapon weapon;
    //private int damage;
    public Fighter(String name) {
        this.name = name;
        this.health = 100;
    }

    public void setWeapon(Weapon weapon){
        this.weapon=weapon;
    }

    public void hit(Fighter ft){
        if(health>0 && weapon !=null){
            int damage= weapon.use();
            ft.decHealth(damage);

        }
    }

    public void decHealth(int damage){
        health -= damage;
        if(health>0){
            System.out.println(name + " got hits the new health is " + health);
        }else{
            System.out.println(name + "is dead");
        }
    }

    public String getName(){
        return name;
    }

    public int getHealth(){
        return health;
    }


}
