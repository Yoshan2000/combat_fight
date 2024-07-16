

import Fight.Fighter;
import Fight.Player1;
import Fight.Player2;
import Levels.LevelManager;
import Wep.*;

import java.util.ArrayList;



import java.util.ArrayList;



import Wep.*;

public class CombatArea {
    private Fighter player1, player2;
    private WeaponManager<Weapon> weaponManager = new WeaponManager<>();

    public CombatArea() {
        setupWeapons();
        initializePlayers();
        fight();
    }

    private void setupWeapons() {
        weaponManager.addWeapon(new Arrow(3));
        weaponManager.addWeapon(new Gun(5));
        weaponManager.addWeapon(new Sword(4));
    }

    private void initializePlayers() {
        player1 = new Player1("Baracho");
        player2 = new Player2("Skeletor");
        weaponManager.provideWeapons(player1, player2);
    }

    private void fight() {
        while (player1.getHealth() > 0 && player2.getHealth() > 0) {
            player1.hit(player2);
            if (player2.getHealth() > 0) {
                player2.hit(player1);
            }
        }

        if (player1.getHealth() <= 0) {
            System.out.println(player1.getName() + " is defeated!");
        } else {
            System.out.println(player2.getName() + " is defeated!");
        }
    }

    public static void main(String[] args) {
        new CombatArea();
    }
}
