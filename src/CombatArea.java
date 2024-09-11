import Fight.Fighter;
import Fight.Player1;
import Fight.Player2;
import Fight.Monster;

import Levels.LevelManager;
import Wep.*;

import java.util.Arrays;
import java.util.Scanner;

public class CombatArea {
    public Fighter player1, player2;
    private Monster monster;
    private WeaponManager<Weapon> weaponManager;
    private Scanner scanner;

    private int pause = 1000;
    private LevelManager levelManager;

    public CombatArea() {

        weaponManager = new WeaponManager<>();
        levelManager = new LevelManager(); // Initialize the LevelManager
        scanner = new Scanner(System.in); // Initialize Scanner
        initializeFighters();
        startGame(); // Now this handles multiple levels
    }

    private void initializeFighters() {
        System.out.println("Enter player 1 name: ");
        String player1Name = scanner.nextLine();
        player1 = new Player1(player1Name);
        System.out.println("Enter player 2 name: ");
        String player2Name = scanner.nextLine();
        player2 = new Player2(player2Name);

        monster = new Monster("Big Bad Monster");
        addWeapons(); // Add weapons to the weapon manager
        weaponManager.provideWeapons(player1, player2);
    }

    private void addWeapons() {
        weaponManager.addWeapon(new Arrow(15, "Arrow"));
        weaponManager.addWeapon(new Gun(20, "Gun"));
        weaponManager.addWeapon(new Sword(10, "Sword"));
    }


    private void startGame() {
        while (player1.getHealth() > 0 || player2.getHealth() > 0) {
            fight();

            if (monster.getHealth() <= 0) {
                System.out.println("The monster is defeated! Moving to the next level...");



                System.out.println("Do you want to continue to the next level? (Y/N): ");
                String input = scanner.nextLine().trim().toUpperCase();

                if (input.equals("N")) {
                    System.out.println("Game Over. You chose not to continue.");
                    break;
                } else if (input.equals("Y")) {
                    levelManager.levelUp(monster, Arrays.asList(player1, player2));
                } else {
                    System.out.println("Invalid input. Exiting game.");

                }

            } else if (player1.getHealth() <= 0 && player2.getHealth() <= 0) {
                System.out.println("Both players are defeated! Game Over.");
                break;
            }
        }
    }

    private void fight() {

        Thread player1Thread = new Thread(() -> {
            while (player1.getHealth() > 0 && monster.getHealth() > 0) {
                System.out.println("Thread " +  Thread.currentThread().getName());
                player1.hit(monster);
                sleep(pause);
                if (monster.getHealth() > 0) {
                    monster.hit(player1);
                    if(monster.getHealth() <= 0) {
                        break;
                    }

                }
                sleep(pause);
            }
        }, "Player1-Thread");


        Thread player2Thread = new Thread(() -> {
            while (player2.getHealth() > 0 && monster.getHealth() > 0) {
                System.out.println("Thread " +  Thread.currentThread().getName());
                player2.hit(monster);
                sleep(pause);
                if (monster.getHealth() > 0) {
                    monster.hit(player2);
                    player2.hit(monster, 1.5);
                    if(monster.getHealth() <= 0) {
                        break;
                    }
                }
                sleep(pause);
            }
        }, "Player2-Thread");


        player1Thread.start();
        player2Thread.start();


        try {
            player1Thread.join();
            player2Thread.join();
        } catch (InterruptedException e) {
            System.out.println("Threads interrupted.");
        }
    }

    public void sleep(int pause) {
        try {
            Thread.sleep(pause);
        } catch (InterruptedException e) {
            System.out.println("Threads2 interrupted.");
        }
    }

    public static void main(String[] args) {
        new CombatArea();
    }
}
