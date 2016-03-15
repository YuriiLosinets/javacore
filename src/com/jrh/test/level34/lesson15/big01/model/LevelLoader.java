package com.javarush.test.level34.lesson15.big01.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by CMI-USER on 1/25/2016.
 */
public class LevelLoader
{
    private Path levels;
    public LevelLoader(Path levels)
    {
        this.levels = levels;
    }
    public GameObjects getLevel(int level){
        if(level > 60) {
            level = level % 60;
        }

        Player player = null;
        Set<Home> homeSet = new HashSet<>();
        Set<Box> boxSet = new HashSet<>();
        Set<Wall> wallSet = new HashSet<>();

        String fileContent = "";
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(levels.toFile()));
            while (reader.ready())
            {
                fileContent += reader.readLine() + "\n";
            }
            reader.close();
        }
        catch (IOException e) {  }

        String[] levels = fileContent.split("\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*");

        for (int i = 1; i < levels.length - 1; i++)
        {
            String[] array = levels[i].split("\n");
            int fileLevel = Integer.parseInt(array[1].replace("Maze:", "").trim());
            if (fileLevel == level)
            {
                int width = Integer.parseInt(array[3].replace("Size X:", "").trim());
                int height = Integer.parseInt(array[4].replace("Size Y:", "").trim());

                char[][] matrix = new char[height][width];
                for (int j = 0; j < height; j++) {
                    for (int k = 0; k < width; k++) {
                        String str = array[8 + j];
                        char[] charArray = str.toCharArray();
                        matrix[j][k] = charArray[k];
                    }
                }
                for (int j = 0; j < height; j++)
                {
                    for (int k = 0; k < width; k++)
                    {
                        int X = Model.FIELD_SELL_SIZE / 2 + Model.FIELD_SELL_SIZE * k;
                        int Y = Model.FIELD_SELL_SIZE / 2 + Model.FIELD_SELL_SIZE * j;
                        switch (matrix[j][k])
                        {
                            case 'X':
                                wallSet.add(new Wall(X, Y));
                                break;
                            case '*':
                                boxSet.add(new Box(X, Y));
                                break;
                            case '.':
                                homeSet.add(new Home(X, Y));
                                break;
                            case '&':
                                boxSet.add(new Box(X, Y));
                                homeSet.add(new Home(X, Y));
                                break;
                            case '@':
                                player = new Player(X, Y);
                                break;
                        }
                    }
                }
                GameObjects gameObjects = new GameObjects(wallSet, boxSet, homeSet, player);
                return gameObjects;
            }
        }
        return null;
    }
}
