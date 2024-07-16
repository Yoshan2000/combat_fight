package Wep;

import Fight.Fighter;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


public class WeaponManager<T extends Weapon> {
    private List<T> weapons = new ArrayList<>();

    public void addWeapon(T weapon) {
        weapons.add(weapon);
    }

    public void provideWeapons(Fighter player1, Fighter player2) {
        Collections.shuffle(weapons);
        if (weapons.size() >= 2) {
            player1.setWeapon(weapons.get(0));
            player2.setWeapon(weapons.get(1));
        }
    }
}