package Fight;

public class Fighter {
    private String name;
    private int health;
    public Fighter(String name) {
        this.name = name;
        this.health = 100;
    }
    public void hit(int damage){
        health -= damage;
        if(health>0){
            System.out.println(name + " got hits the new health is " + health);
        }else{
            System.out.println(name + "is dead");
        }

    }
}
