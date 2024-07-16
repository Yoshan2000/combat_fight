import Fight.Fighter;
import Fight.Player1;
import Fight.Player2;
import Fight.Monster;
import Wep.*;
import java.util.Random;

public class CombatArea {
    private Fighter player1, player2, monster;
    private final WeaponManager<Weapon> weaponManager = new WeaponManager<>();
    private Random rand = new Random();
    private Fighter[] fighters;  // Array to hold the players

    public CombatArea() {
        weaponManager.addWeapon(new Arrow(3));
        weaponManager.addWeapon(new Gun(5));
        weaponManager.addWeapon(new Sword(4));
        initializeFighters();
        fight();
    }

    private void initializeFighters() {
        player1 = new Player1("Baracho");
        player2 = new Player2("Skeletor");
        monster = new Monster("Big Bad Monster", 300, 15);
        weaponManager.provideWeapons(player1, player2);
        fighters = new Fighter[]{player1, player2};
    }

    private void fight() {
        while ((player1.getHealth() > 0 || player2.getHealth() > 0) && monster.getHealth() > 0) {
            player1.hit(monster);
            if (monster.getHealth() > 0) {
                player2.hit(monster);
            }
            if (monster.getHealth() > 0) {
                Fighter target = fighters[rand.nextInt(fighters.length)];
                monster.hit(target);
            }
        }

        if (monster.getHealth() <= 0) {
            System.out.println("The monster is defeated!");
        } else {
            System.out.println("Both players are defeated!");
        }
    }

    public static void main(String[] args) {
        new CombatArea();
    }
}
