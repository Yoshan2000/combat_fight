package Levels;

import Fight.Fighter;
import Fight.Monster;
import Wep.Weapon;
import java.util.List;

public class LevelManager {
    private int currentLevel;
    private static final double MONSTER_HEALTH_MULTIPLIER = 1.5;
    private static final double MONSTER_DAMAGE_MULTIPLIER = 1.2;
    private  static final double WEAPON_DAMAGE_MULTIPLIER = 1;
    private  static  final int PLAYER_HEALTH_RESET = 100;
    private int baseMonsterHealth;

    public LevelManager() {
        currentLevel = 1;
        baseMonsterHealth = 150;
    }

    public void levelUp(Monster monster, List<Fighter> players) {


        // Increase monster health and damage
        if (monster.getHealth() <= 0) {
            baseMonsterHealth = (int) (baseMonsterHealth * MONSTER_HEALTH_MULTIPLIER);
            monster.setHealth(baseMonsterHealth);
        } else {
            int newMonsterHealth = (int) (monster.getHealth() * MONSTER_HEALTH_MULTIPLIER);
            monster.setHealth(newMonsterHealth);
        }

        int newMonsterDamage = (int) (monster.getHandDamage() * MONSTER_DAMAGE_MULTIPLIER);
        monster.setHandDamage(newMonsterDamage);


        System.out.println("New Monster Health: " + monster.getHealth() + ", New Monster Damage: " + newMonsterDamage);


        for (Fighter player : players) {
            player.setHealth(PLAYER_HEALTH_RESET);

            Weapon weapon = player.getWeapon();
            if (weapon != null) {
                int newWeaponDamage = (int) (weapon.getDamage() * WEAPON_DAMAGE_MULTIPLIER);
                weapon.setDamage(newWeaponDamage);
                System.out.println(player.getName() + " - New weapon damage for " + weapon.getType() + ": " + newWeaponDamage);
            }
        }


        currentLevel++;
        System.out.println("Level " + currentLevel + " starts now!");
    }
}
