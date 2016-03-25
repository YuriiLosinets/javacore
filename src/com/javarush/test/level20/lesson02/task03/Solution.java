package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution
{
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap()
    {
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            File file = new File(reader.readLine());
            InputStream inputStream = new FileInputStream(file);
            load(inputStream);
            inputStream.close();
        }
        catch (Exception e)
        {
            System.out.println("Foo!");
        }
    }

    public void save(OutputStream outputStream) throws Exception
    {
        Properties prop1 = new Properties();
        for (Map.Entry<String, String> entry: properties.entrySet())
        {
            prop1.setProperty(entry.getKey(), entry.getValue());
        }
        prop1.store(outputStream, null);
    }

    public void load(InputStream inputStream) throws Exception
    {
        Properties prop = new Properties();
        prop.load(inputStream);
        Enumeration<?> e = prop.propertyNames();
        while (e.hasMoreElements())
        {
            String key = (String) e.nextElement();
            String value = prop.getProperty(key);
            properties.put(key, value);
        }
    }
}
