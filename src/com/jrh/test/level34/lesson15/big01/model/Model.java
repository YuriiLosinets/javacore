package com.javarush.test.level34.lesson15.big01.model;

import com.javarush.test.level34.lesson15.big01.controller.EventListener;

import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by CMI-USER on 1/25/2016.
 */
public class Model
{
    public final static int FIELD_SELL_SIZE = 20;
    private EventListener eventListener;
    private GameObjects gameObjects;
    private int currentLevel = 1;
    private LevelLoader levelLoader = new LevelLoader(Paths.get("D:\\Java\\JavaRushHomeWork\\src\\com\\javarush\\test\\level34\\lesson15\\big01\\res\\levels.txt"));

    public void setEventListener(EventListener eventListener)
    {
        this.eventListener = eventListener;
    }

    public GameObjects getGameObjects()
    {
        return gameObjects;
    }

    public void restartLevel(int level)
    {
        gameObjects = levelLoader.getLevel(level);
    }

    public void restart()
    {
        restartLevel(currentLevel);
    }

    public void startNextLevel()
    {
        currentLevel++;
        restart();
    }

    public void move(Direction direction)
    {
        if (checkWallCollision(gameObjects.getPlayer(), direction) || checkBoxCollision(direction) ) return;

        gameObjects.getPlayer().move(
                direction == Direction.LEFT ? -FIELD_SELL_SIZE :
                        direction == Direction.RIGHT ? FIELD_SELL_SIZE : 0,
                direction == Direction.UP ? -FIELD_SELL_SIZE :
                        direction == Direction.DOWN ? FIELD_SELL_SIZE : 0
        );

        checkCompletion();
    }

    public boolean checkWallCollision(CollisionObject gameObject, Direction direction)
    {
        for (Wall wall : gameObjects.getWalls())
            if (gameObject.isCollision(wall, direction))
                return true;
        return false;
    }

    public boolean checkBoxCollision(Direction direction)
    {
        for (Box box : gameObjects.getBoxes())
            if (gameObjects.getPlayer().isCollision(box, direction))
            {
                if (checkWallCollision(box, direction)) return true;
                    for (Box boxOther : gameObjects.getBoxes())
                        if (!(box.getX() == boxOther.getX() && box.getY() == boxOther.getY()) &&
                                box.isCollision(boxOther, direction)) return true;

                box.move(direction == Direction.LEFT ? -FIELD_SELL_SIZE :
                                direction == Direction.RIGHT ? FIELD_SELL_SIZE : 0,
                                direction == Direction.UP ? -FIELD_SELL_SIZE :
                                direction == Direction.DOWN ? FIELD_SELL_SIZE : 0);
                return false;
            }
        return false;
    }

    public void checkCompletion()
    {
        int count = 0;
        for (Home home : gameObjects.getHomes())
            for (Box box : gameObjects.getBoxes())
                if (box.getX() == home.getX() && box.getY() == home.getY()) count++;
        if (count == gameObjects.getHomes().size()) eventListener.levelCompleted(currentLevel);
    }
}
