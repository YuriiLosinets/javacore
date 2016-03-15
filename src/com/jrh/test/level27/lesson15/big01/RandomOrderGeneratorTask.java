package com.javarush.test.level27.lesson15.big01;

import java.util.List;

/**
 * Created by CMI-USER on 1/15/2016.
 */
public class RandomOrderGeneratorTask implements Runnable
{
    private int interval;
    private List<Tablet> tablets;
    public RandomOrderGeneratorTask(List<Tablet> tablets, int interval)
    {
        this.tablets = tablets;
        this.interval = interval;
    }
    @Override
    public void run()
    {
        while (!Thread.currentThread().isInterrupted())
        {
            try
            {
                Tablet t = tablets.get((int)(Math.random()*tablets.size()));
                t.createTestOrder();
                Thread.sleep(interval);
            }
            catch (InterruptedException e)
            {
                Thread.currentThread().interrupt();
            }
        }
    }
}
