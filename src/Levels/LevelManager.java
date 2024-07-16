package Levels;

import Fight.Fighter;

import java.util.ArrayList;

public class LevelManager {
    private int levelIndex = 0;
    private ArrayList<ArrayList<Fighter>> levels;
    private boolean doubleChampNextLevel = false; // Flag to check if next level should have two champs

    public LevelManager() {
        levels = new ArrayList<>();
 // Initialize the levels when creating the LevelManager
    }

    // Method to initialize levels


    public ArrayList<Fighter> getNextLevel() {
        if (levelIndex < levels.size()) {
            ArrayList<Fighter> level = new ArrayList<>(levels.get(levelIndex));
            if (doubleChampNextLevel) {
                // Add two champs to the level if flagged
                level.add(new Fighter("The Champ"));
                level.add(new Fighter("The Champ"));
                doubleChampNextLevel = false;  // Reset flag after use
            }
            levelIndex++;  // Increment the level index after fetching the level
            return level;
        }
        return null;
    }

    public void doubleChampNextLevel() {
        doubleChampNextLevel = true;  // Set flag to add two champs in the next level
    }


}
