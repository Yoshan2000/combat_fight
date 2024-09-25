package Wep;

import Fight.Fighter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class WeaponManager<T extends Weapon> {
    private List<T> weapons;
    private Random random;

    public WeaponManager(){
        weapons = new ArrayList<>();
        random = new Random();
    }

    public void addWeapon(T weapon) {
        weapons.add(weapon);
    }

    public void provideWeapons(Fighter player1, Fighter player2) {
        //Collections.shuffle(weapons);
        for(int i=0; i<weapons.size(); i++) {
            int randomWeapon=random.nextInt(weapons.size());

            T temp=weapons.get(i);
            weapons.set(i, weapons.get(randomWeapon));
            weapons.set(randomWeapon, temp);

        }

        if (weapons.size() >= 3) {
            player1.setWeapon(weapons.get(0));
            player2.setWeapon(weapons.get(1));
        }
    }
}