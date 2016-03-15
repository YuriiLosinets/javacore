package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by CMI-USER on 1/14/2016.
 */
public class Restaurant
{
    private final static int ORDER_CREATING_INTERVAL = 100;
    private final static LinkedBlockingQueue<Order> queue = new LinkedBlockingQueue<>();
    public static void main(String[] args) throws InterruptedException
    {
        Locale.setDefault(Locale.ENGLISH);
        Cook cook1 = new Cook("Amigo");
        Cook cook2 = new Cook("Ogima");
        cook1.setQueue(queue);
        cook2.setQueue(queue);
        Thread cook1Thread=new Thread(cook1);
        cook1Thread.start();
        Thread cook2Thread=new Thread(cook2);
        cook2Thread.start();
        Waitor waitor = new Waitor();
        cook1.addObserver(waitor);
        cook2.addObserver(waitor);
        List<Tablet> tabletList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Tablet tablet = new Tablet(i);
            tablet.setQueue(queue);
            tabletList.add(tablet);
        }
        Thread randomOrderThread = new Thread(new RandomOrderGeneratorTask(tabletList, ORDER_CREATING_INTERVAL));
        randomOrderThread.start();
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
        }
        randomOrderThread.interrupt();
        cook1Thread.interrupt();
        cook2Thread.interrupt();
        try {
            cook1Thread.join();
            cook2Thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }
}
