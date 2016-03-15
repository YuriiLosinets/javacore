package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution
{
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
        String[] words = new String[list.size()];
        words = list.toArray(words);
        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words)
    {
        StringBuilder result = new StringBuilder();
        if (words == null || words.length == 0)
            return result;
        else if (words[0].equals(""))
            return result;
        else if (words.length == 1)
            return result.append(words[0]);
        else
        {
            List<String> list = new ArrayList<String>();
            list.addAll(Arrays.asList(words));

            while (true)
            {
                int count = 0;
                for (int i = 0; i <= list.size()-2; i++)
                {
                    char a = list.get(i).toUpperCase().toLowerCase().charAt(list.get(i).length() - 1);
                    char b = list.get(i + 1).toUpperCase().toLowerCase().charAt(0);
                    if (a == b)
                        count++;
                }
                if (count == list.size()-1)
                    break;
                else
                    Collections.shuffle(list);
            }

            for (int i = 0; i < list.size(); i++)
            {
                if (i == list.size() - 1) result.append(list.get(i));
                else result.append(list.get(i)).append(" ");
            }
        }
        return result;
    }
}
