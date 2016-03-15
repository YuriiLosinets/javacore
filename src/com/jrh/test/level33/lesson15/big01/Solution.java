package com.javarush.test.level33.lesson15.big01;

import com.google.common.collect.HashBiMap;
import com.javarush.test.level33.lesson15.big01.strategies.*;
import com.javarush.test.level33.lesson15.big01.tests.FunctionalTest;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by CMI-USER on 1/20/2016.
 */
public class Solution
{
    public static Set<Long> getIds(Shortener shortener, Set<String> strings)
    {
        Set<Long> result = new HashSet<>();
        for (String s : strings)
            result.add(shortener.getId(s));
        return result;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys)
    {
        Set<String> result = new HashSet<>();
        for (Long l : keys)
            result.add(shortener.getString(l));
        return result;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber)
    {
        Helper.printMessage(strategy.getClass().getSimpleName());
        Set<String> result = new HashSet<>();
        for (int i = 0; i < elementsNumber; i++)
            result.add(Helper.generateRandomString());

        Shortener shortener = new Shortener(strategy);

        Set<Long> idsSet;
        Date startTime1 = new Date();
        idsSet = getIds(shortener, result);
        Date finishTime1 = new Date();
        long msDelay1 = finishTime1.getTime() - startTime1.getTime();
        Helper.printMessage(Long.toString(msDelay1));

        Set<String> stringSet;
        Date startTime2 = new Date();
        stringSet = getStrings(shortener, idsSet);
        Date finishTime2 = new Date();
        long msDelay2 = finishTime2.getTime() - startTime2.getTime();
        Helper.printMessage(Long.toString(msDelay2));

        if (result.equals(stringSet))
            Helper.printMessage("Тест пройден.");
        else
            Helper.printMessage("Тест не пройден.");
    }

    public static void main(String[] args)
    {
        StorageStrategy strategy = new HashMapStorageStrategy();
        testStrategy(strategy, 10000);
        StorageStrategy strategy1 = new OurHashMapStorageStrategy();
        testStrategy(strategy1, 1000);
        StorageStrategy fileStorageStrategy = new FileStorageStrategy();
        testStrategy(fileStorageStrategy, 100);
        StorageStrategy ourHashBiMapStorageStrategy = new OurHashBiMapStorageStrategy();
        testStrategy(ourHashBiMapStorageStrategy, 1000);
        StorageStrategy hashBiMapStorageStrategy = new HashBiMapStorageStrategy();
        testStrategy(hashBiMapStorageStrategy, 1000);
        StorageStrategy dualHashBidiMapStorageStrategy = new DualHashBidiMapStorageStrategy();
        testStrategy(dualHashBidiMapStorageStrategy, 1000);

        Result result = JUnitCore.runClasses(FunctionalTest.class);
        for (Failure failure : result.getFailures())
        {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());

    }
}
