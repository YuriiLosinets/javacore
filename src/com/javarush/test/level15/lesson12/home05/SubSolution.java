package com.javarush.test.level15.lesson12.home05;

/**
 * Created by CMI-USER on 11/23/2015.
 */
public class SubSolution extends Solution
{
    SubSolution()
    {

    }
    SubSolution(String name)
    {
        super(name);
    }
    SubSolution(String name, int i)
    {
        super(name,i);
    }
    public SubSolution(int i, String name)
    {
        super(i, name);
    }
    public SubSolution(int i, double d)
    {
        super(i, d);
    }
    public SubSolution(double d, int i)
    {
        super(d,i);
    }
    private SubSolution(double d, char ch)
    {
        super(d,ch);
    }
    private SubSolution(char ch, double d)
    {
        super(ch,d);
    }
    private SubSolution(double d, String name)
    {
        super((char) d, name); //шо за нах?
    }
    protected SubSolution(float f, char ch)
    {
        super(f, ch);
    }
    protected SubSolution(char ch, String name)
    {
        super(ch, name);
    }
    protected SubSolution(char ch, float f)
    {
        super(ch, f);
    }
}
