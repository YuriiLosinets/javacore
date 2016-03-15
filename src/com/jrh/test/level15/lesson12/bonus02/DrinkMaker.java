package com.javarush.test.level15.lesson12.bonus02;

/**
 * Created by CMI-USER on 11/23/2015.
 */
public abstract class DrinkMaker
{
    abstract void getRightCup();
    abstract void putIngredient();
    abstract void pour();

    void makeDrink()
    {
        getRightCup();
        putIngredient();
        pour();
    }
}
