package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.ad.Advertisement;
import com.javarush.test.level27.lesson15.big01.ad.StatisticAdvertisementManager;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by CMI-USER on 1/15/2016.
 */
public class DirectorTablet
{
    private DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
    public void printAdvertisementProfit()
    {
        double total = 0d;
        for (Map.Entry<Date, Double> entry : StatisticEventManager.getInstance().getAdRevenue().entrySet())
        {
            double profit = entry.getValue();
            ConsoleHelper.writeMessage(String.format("%s - %.2f", df.format(entry.getKey()), profit));
            total += profit;
        }
        ConsoleHelper.writeMessage(String.format("Total - %.2f", total));
    }
    public void printCookWorkloading()
    {
        for (Map.Entry<Date, Map<String, Integer>> entry : StatisticEventManager.getInstance().getCookWorkload().entrySet())
        {
            ConsoleHelper.writeMessage(df.format(entry.getKey()));
            for (Map.Entry<String, Integer> cooksEntry : entry.getValue().entrySet())
            {
                ConsoleHelper.writeMessage(String.format("%s - %d min", cooksEntry.getKey(), cooksEntry.getValue()));
            }
            ConsoleHelper.writeMessage("");
        }
    }

    public void printActiveVideoSet()
    {
        List<Advertisement> advertisements = StatisticAdvertisementManager.getInstance().getActiveVideos();
        for (Advertisement advertisement : advertisements)
            ConsoleHelper.writeMessage(String.format("%s - %d", advertisement.getName(), advertisement.getHits()));
    }
    public void printArchivedVideoSet()
    {
        List<Advertisement> advertisements = StatisticAdvertisementManager.getInstance().getArchVideos();
        for (Advertisement advertisement : StatisticAdvertisementManager.getInstance().getArchVideos())
            ConsoleHelper.writeMessage(advertisement.getName());
    }
}
