package com.javarush.test.level14.lesson08.home05;

/**
 * Created by CMI-USER on 11/19/2015.
 */
public class Computer
{
    private Keyboard Keyboard;
    private Mouse Mouse;
    private Monitor Monitor;

    public Computer(com.javarush.test.level14.lesson08.home05.Keyboard keyboard, com.javarush.test.level14.lesson08.home05.Mouse mouse, com.javarush.test.level14.lesson08.home05.Monitor monitor)
    {
        Keyboard = keyboard;
        Mouse = mouse;
        Monitor = monitor;
    }

    public Computer()
    {
        this(new Keyboard(), new Mouse(), new Monitor());
    }

    public Keyboard getKeyboard()
    {
        return Keyboard;
    }

    public Mouse getMouse()
    {
        return Mouse;
    }

    public Monitor getMonitor()
    {
        return Monitor;
    }
}
