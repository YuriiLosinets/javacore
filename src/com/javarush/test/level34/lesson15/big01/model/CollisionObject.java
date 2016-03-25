package com.javarush.test.level34.lesson15.big01.model;

/**
 * Created by CMI-USER on 1/25/2016.
 */
public abstract class CollisionObject extends GameObject
{
    public CollisionObject(int x, int y)
    {
        super(x, y);
    }

    public boolean isCollision(GameObject gameObject, Direction direction)
    {
        switch (direction)
        {
            case UP:    return getY() - Model.FIELD_SELL_SIZE == gameObject.getY() && getX() == gameObject.getX();
            case DOWN:  return getY() + Model.FIELD_SELL_SIZE == gameObject.getY() && getX() == gameObject.getX();
            case RIGHT: return getY() == gameObject.getY() && getX() + Model.FIELD_SELL_SIZE == gameObject.getX();
            case LEFT:  return getY() == gameObject.getY() && getX() - Model.FIELD_SELL_SIZE == gameObject.getX();
            default:    return false;
        }
    }
}
