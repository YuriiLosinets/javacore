package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.ad.AdvertisementManager;
import com.javarush.test.level27.lesson15.big01.ad.NoVideoAvailableException;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;
import com.javarush.test.level27.lesson15.big01.kitchen.TestOrder;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;
import com.javarush.test.level27.lesson15.big01.statistic.event.NoAvailableVideoEventDataRow;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Created by CMI-USER on 1/14/2016.
 */
public class Tablet { public static java.util.logging.Logger logger = Logger.getLogger(Tablet.class.getName());

    private final int number;
    private LinkedBlockingQueue<Order> queue;
    public Tablet(int number)
    {
        this.number = number;
    }
    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }
    public void createOrder(){
        Order order = null;
        try
        {
            order = new Order(this);
            ConsoleHelper.writeMessage(order.toString());
            if(!order.isEmpty())
            {
                queue.add(order);
                AdvertisementManager advertisementManager = new AdvertisementManager(order.getTotalCookingTime() * 60);
                advertisementManager.processVideos();
            }
        }
        catch (NoVideoAvailableException e)
        {
            logger.log(Level.INFO,"No video is available for the order " + order);
        }
        catch (IOException e)
        {
            logger.log(Level.SEVERE,"Console is unavailable.");
        }
    }
    public void createTestOrder(){
        TestOrder testOrder = null;
        try
        {
            testOrder = new TestOrder(this);
            ConsoleHelper.writeMessage(testOrder.toString());
            if(!testOrder.isEmpty())
            {
                try {
                    queue.put(testOrder);
                } catch (InterruptedException e) {
                }
                AdvertisementManager advertisementManager = new AdvertisementManager(testOrder.getTotalCookingTime() * 60);
                advertisementManager.processVideos();
            }
        }
        catch (NoVideoAvailableException e)
        {
            logger.log(Level.INFO,"No video is available for the order " + testOrder);
        }
        catch (IOException e)
        {
            logger.log(Level.SEVERE,"Console is unavailable.");
        }
    }
    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }
}
