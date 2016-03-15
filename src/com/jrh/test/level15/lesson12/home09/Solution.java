package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;


public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        URL url = new URL(reader.readLine());
        splitQuery(url);
    }

    public static void alert(double value)
    {
        System.out.println("double " + value);
    }

    public static void alert(String value)
    {
        System.out.println("String " + value);
    }

    public static void splitQuery(URL url) throws UnsupportedEncodingException
    {
        Map<String, String> query_pairs = new LinkedHashMap<String, String>();
        String query = url.getQuery();
        String[] pairs = query.split("&");
        for (String pair : pairs)
        {
            if (pair.contains("="))
            {
                int idx = pair.indexOf("=");
                query_pairs.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"), URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
            }
            else
            {
                query_pairs.put(pair, "");
            }
        }
       String result = "";
        for (Map.Entry entry : query_pairs.entrySet())
        {
            String k = (String) entry.getKey();
            result += k + " ";
        }
        System.out.println(result);
        for (Map.Entry entry : query_pairs.entrySet())
        {
            if (entry.getKey().equals("obj"))
            {
                try
                {
                    Double d = Double.parseDouble((String) entry.getValue());
                    alert(d);
                }
                catch(Exception e)
                {
                    alert((String) entry.getValue());
                }
            }
        }
    }
}
