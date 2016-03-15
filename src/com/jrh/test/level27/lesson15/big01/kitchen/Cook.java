package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;
import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by CMI-USER on 1/14/2016.
 */
public class Cook extends Observable implements Runnable
{
    private String name;
    private volatile boolean stop = false;
    private LinkedBlockingQueue<Order> queue;
    private volatile boolean caught = false;

    public Cook(String name)
    {
        this.name = name;
    }

    @Override
    public void run()
    {
        while (!stop)
        {
            try
            {
                startCookingOrder(queue.take());
            }
            catch (InterruptedException e)
            {
            }
            try
            {
                Thread.sleep(100);
            }
            catch (InterruptedException e)
            {
                caught = true;
            }
            if (caught && queue.isEmpty())
            {
                stop = true;
            }
        }
    }

    public void setQueue(LinkedBlockingQueue<Order> queue)
    {
        this.queue = queue;
    }

    public void startCookingOrder(Order order)
    {
        ConsoleHelper.writeMessage("Start cooking - " + order + String.format(", cooking time %dmin", order.getTotalCookingTime()));
        StatisticEventManager.getInstance().register(new CookedOrderEventDataRow(order.getTablet().toString(), name, order.getTotalCookingTime() * 60, order.getDishes()));
        setChanged();
        notifyObservers(order);
        try
        {
            Thread.sleep(order.getTotalCookingTime() * 10);
        }
        catch (InterruptedException e)
        {
            caught = true;
        }
    }

    @Override
    public String toString()
    {
        return name;
    }
}
