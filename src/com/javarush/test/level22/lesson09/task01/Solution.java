package com.javarush.test.level22.lesson09.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution
{
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader consolereader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader filereader = new BufferedReader(new FileReader(consolereader.readLine()));
        List<String> list = new ArrayList<String>();
        while (filereader.ready())
        {
            list.addAll(Arrays.asList(filereader.readLine().split(" ")));
        }
        consolereader.close();
        filereader.close();
        for (int i = 0; i < list.size(); i++)
        {
            for (int j = 0; j < list.size();)
            {
                if (list.get(j).equals(new StringBuilder(list.get(i)).reverse().toString()) && j != i)
                {
                    Pair pair = new Pair();
                    pair.first = list.get(j);
                    pair.second = list.get(i);
                    result.add(pair);
                    list.remove(j);
                    list.remove(i);
                    j = 0;
                }
                else
                    j++;
            }
        }


    }

    public static class Pair
    {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
