package com.javarush.test.level07.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 20 чисел и выводит их в убывающем порядке.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++)
        {
            list.add(Integer.parseInt(reader.readLine()));
        }

        sort(list);

        for (int x = list.size() - 1; x >= 0; x--)
        {
            System.out.println(list.get(x));
        }
    }

    public static void sort(ArrayList<Integer> list)
    {
        Collections.sort(list);
    }
}
