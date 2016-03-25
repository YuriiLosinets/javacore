package com.javarush.test.level26.lesson15.big01;

import java.util.*;

/**
 * Created by CMI-USER on 12/18/2015.
 */
public final class CurrencyManipulatorFactory
{
    static Map<String, CurrencyManipulator> map = new HashMap<String, CurrencyManipulator>();
    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode)
    {
        if (map.containsKey(currencyCode)) return map.get(currencyCode);
        else
        {
            map.put(currencyCode, new CurrencyManipulator(currencyCode));
            return map.get(currencyCode);
        }
    }

    private CurrencyManipulatorFactory()
    {
    }
    public static Collection<CurrencyManipulator> getAllCurrencyManipulators()
    {
        return map.values();
    }

}
