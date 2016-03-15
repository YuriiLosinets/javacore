package com.javarush.test.level27.lesson15.big01.statistic.event;

import com.javarush.test.level27.lesson15.big01.ad.Advertisement;

import java.util.Date;
import java.util.List;

/**
 * Created by CMI-USER on 1/14/2016.
 */
public class VideoSelectedEventDataRow implements EventDataRow
{
    List<Advertisement> optimalVideoSet;
    long amount;
    int totalDuration;
    Date currentDate;

    public long getAmount()
    {
        return amount;
    }

    public VideoSelectedEventDataRow(List<Advertisement> optimalVideoSet, long amount, int totalDuration)
    {
        this.optimalVideoSet = optimalVideoSet;
        this.amount = amount;
        this.totalDuration = totalDuration;
        currentDate = new Date();
    }

    @Override
    public Date getDate()
    {
        return currentDate;
    }

    @Override
    public EventType getType()
    {
        return EventType.SELECTED_VIDEOS;
    }

    @Override
    public int getTime()
    {
        return totalDuration;
    }
}
