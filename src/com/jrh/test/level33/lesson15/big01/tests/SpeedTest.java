package com.javarush.test.level33.lesson15.big01.tests;

import com.javarush.test.level33.lesson15.big01.Helper;
import com.javarush.test.level33.lesson15.big01.Shortener;
import com.javarush.test.level33.lesson15.big01.strategies.HashBiMapStorageStrategy;
import com.javarush.test.level33.lesson15.big01.strategies.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by CMI-USER on 1/22/2016.
 */
public class SpeedTest
{
    public long getTimeForGettingIds(Shortener shortener, Set<String> strings, Set<Long> ids)
    {
        Date startTime = new Date();
        for (String s : strings)
            ids.add(shortener.getId(s));
        Date finishTime = new Date();
        long msDelay = finishTime.getTime() - startTime.getTime();
        return msDelay;
    }

    public long getTimeForGettingStrings(Shortener shortener, Set<Long> ids, Set<String> strings)
    {
        Date startTime = new Date();
        for (Long l : ids)
            strings.add(shortener.getString(l));
        Date finishTime = new Date();
        long msDelay = finishTime.getTime() - startTime.getTime();
        return msDelay;
    }

    @Test
    public void testHashMapStorage()
    {
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());

        Set<String> origStrings = new HashSet<>();
        Set<Long> ids = new HashSet<>();
        for (int i = 0; i < 1000; i++)
            origStrings.add(Helper.generateRandomString());

        Long l1 = getTimeForGettingIds(shortener1, origStrings, ids);
        Long l2 = getTimeForGettingIds(shortener2, origStrings, ids);

        Assert.assertTrue(l1>l2);

        Long l11 = getTimeForGettingStrings(shortener1, ids, origStrings);
        Long l22 = getTimeForGettingStrings(shortener2, ids, origStrings);
        Assert.assertEquals(l11, l22, 5L);
    }
}
