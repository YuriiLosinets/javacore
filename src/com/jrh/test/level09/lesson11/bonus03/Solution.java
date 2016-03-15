package com.javarush.test.level09.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел). Слова вывести в возрастающем порядке, числа - в убывающем.
Пример ввода:
Вишня
1
Боб
3
Яблоко
2
0
Арбуз
Пример вывода:
Арбуз
3
Боб
2
Вишня
1
0
Яблоко
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true)
        {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        //sort(array);
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<String> list2 = new ArrayList<String>();
        for (int i = 0; i < array.length; i++)
        {
            try
            {
                list1.add(Integer.valueOf(array[i]));
            }
            catch (Exception e)
            {
                list2.add(array[i]);
            }
        }
        Collections.sort(list1, Collections.reverseOrder());
        Collections.sort(list2);
        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < array.length; i++)
        {
            try
            {
                Integer.valueOf(array[i]);
                array[i] = list1.get(i1).toString();
                i1++;
            }
            catch (Exception e)
            {
                array[i] = list2.get(i2);
                i2++;
            }
        }
        for (String x : array)
        {
            System.out.println(x);
        }
    }

  /*  public static void sort(String[] array)
    {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<String> list2 = new ArrayList<String>();
        for (int i = 0; i < array.length; i++)
        {
            try
            {
                list1.add(Integer.valueOf(array[i]));
            }
            catch (Exception e)
            {
                list2.add(array[i]);
            }
        }
        Collections.sort(list1, Collections.reverseOrder());
        Collections.sort(list2);
        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < array.length; i++)
        {
            if (list1.contains(array[i]))
            {
                array[i] = list1.get(i1).toString();
                i1++;
            }
            else
            {
                array[i] = list2.get(i2);
                i2++;
            }
        }
    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b)
    {
        return a.compareTo(b) > 0;
    }


    //строка - это на самом деле число?
    public static boolean isNumber(String s)
    {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            char c = chars[i];
            if ((i != 0 && c == '-') //есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-') ) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }*/
}
