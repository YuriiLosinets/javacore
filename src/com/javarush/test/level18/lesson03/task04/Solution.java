package com.javarush.test.level18.lesson03.task04;

import java.io.*;
import java.util.*;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution
{
    public static List<Integer> integerList = new ArrayList<Integer>();
    public static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    public static List<Integer> countList = new ArrayList<Integer>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream inputStream = new FileInputStream(fileName);

        int count = 0;
        int minValue = 0;

        while(inputStream.available() > 0){
            int data = inputStream.read();
            integerList.add(data);
        }

        for (Integer i : integerList){
            count = Collections.frequency(integerList, i);
            map.put(i, count);
        }

        for(Map.Entry<Integer, Integer> pair : map.entrySet()){
            Integer value = pair.getValue();
            countList.add(value);

        }

        Collections.sort(countList);
        minValue = countList.get(0);

        for(Map.Entry<Integer, Integer> pair : map.entrySet())
        {
            Integer key = pair.getKey();

            if (pair.getValue().equals(minValue))
            {
                System.out.print(key + " ");
            }
        }
        reader.close();
        inputStream.close();
    }
}
