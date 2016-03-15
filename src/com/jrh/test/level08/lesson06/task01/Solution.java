package com.javarush.test.level08.lesson06.task01;

import java.util.*;

/* Создать два списка LinkedList и ArrayList
Нужно создать два списка – LinkedList и ArrayList.
*/

public class Solution
{
    public static void main(String[] args)
    {
        createArrayList();
        createLinkedList();
    }
    public static Object createArrayList()
    {
        List<Object> arlist = new ArrayList<Object>();
        return arlist;
    }

    public static Object createLinkedList()
    {
        List<Object> arlist1 = new LinkedList<Object>();
        return arlist1;
    }
}
