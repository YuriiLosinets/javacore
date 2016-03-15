package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

/**
 * Created by CMI-USER on 1/25/2016.
 */
public class Home extends GameObject
{
    @Override
    public void draw(Graphics graphics)
    {
        graphics.setColor(Color.RED);
        int leftUpperCornerX = getX() - getWidth() / 2;
        int leftUpperCornerY = getY() - getHeight() / 2;
        graphics.drawOval(leftUpperCornerX, leftUpperCornerY, getWidth(), getHeight());

    }

    public Home(int x, int y)
    {
        super(x, y);
        this.setHeight(2);
        this.setWidth(2);
    }
}
