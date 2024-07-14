package Wep;

import Fight.Fighter;

import java.util.ArrayList;
import java.util.List;

public class WeaponManager <T extends Weapon> {
    private List<T> weapons;

    public WeaponManager(){
        weapons = new ArrayList<T>();
    }

    public void addWeapon(T weapon){
        weapons.add(weapon);
    }


    public T getWeapon(int index){
        if(index<0 || index>= weapons.size()){
            throw new IndexOutOfBoundsException("Weapon is not found");
        }
        return weapons.get(index);
    }

    public void provideWeapon(Fighter fighter){
        if(!weapons.isEmpty()){
            int WeaponSelected=(int) (Math.random()*weapons.size());
            try{
                fighter.setWeapon(getWeapon(WeaponSelected));
            }catch(IndexOutOfBoundsException e){
                System.out.println("ERROR occurred while selecting the weapon");
            }
        }
    }
}
