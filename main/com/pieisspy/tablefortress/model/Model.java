package main.com.pieisspy.tablefortress.model;

import main.com.pieisspy.tablefortress.model.levelhandler.Level;

public class Model {
    public Model() {
        level = null;
        levelNumProgress = 0;
    }

    public void incrementProgress() {
        levelNumProgress++;
    }

    public void createLevel() {
        level = new Level(levelNumProgress);
    }

    public void destroyLevel() {
        level = null;
    }

    public Level getLevel() {
        return level;
    }

    public int getLevelNumProgress() {
        return levelNumProgress;
    }

    public Level level;
    public int levelNumProgress;
}