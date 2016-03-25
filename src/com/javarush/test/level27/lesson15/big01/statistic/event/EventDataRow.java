package com.javarush.test.level27.lesson15.big01.statistic.event;

import java.util.Date;

/**
 * Created by CMI-USER on 1/14/2016.
 */
public interface EventDataRow
{
    Date getDate();
    EventType getType();
    int getTime();
}
