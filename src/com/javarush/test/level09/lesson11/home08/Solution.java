package com.javarush.test.level09.lesson11.home08;

import java.util.ArrayList;

/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел. Добавить в список пять объектов–массивов длиной 5, 2, 4, 7, 0 соответственно. Заполнить массивы любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList()
    {
        ArrayList<int[]> list = new ArrayList<int[]>();
        int[] i1 = new int[5];
        for (int i = 0; i < i1.length; i++)
        {
            i1[i] = i;
        }
        list.add(i1);
        int[] i2 = new int[2];
        for (int i = 0; i < i2.length; i++)
        {
            i2[i] = i;
        }
        list.add(i2);
        int[] i3 = new int[4];
        for (int i = 0; i < i3.length; i++)
        {
            i3[i] = i;
        }
        list.add(i3);
        int[] i4 = new int[7];
        for (int i = 0; i < i4.length; i++)
        {
            i4[i] = i;
        }
        list.add(i4);
        int[] i5 = new int[0];
        list.add(i5);
        return list;
    }

    public static void printList(ArrayList<int[]> list)
    {
        for (int[] array: list )
        {
            for (int x: array)
            {
                System.out.println(x);
            }
        }
    }
}
