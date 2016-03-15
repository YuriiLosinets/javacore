package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution
{
    public static void main(String[] args)
    {
        StringBuilder stringBuilder = new StringBuilder();
        try
        {
            BufferedReader creader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader reader = new BufferedReader(new FileReader(new File(creader.readLine())));
            String lines;
            while ((lines = reader.readLine()) != null) stringBuilder.append(lines);
            reader.close();
            creader.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        String line = stringBuilder.toString();
        Pattern p1 = Pattern.compile("<"+args[0], Pattern.CASE_INSENSITIVE);
        Pattern p2 = Pattern.compile("</"+args[0]+">", Pattern.CASE_INSENSITIVE);
        Matcher m1 = p1.matcher(line);
        Matcher m2 = p2.matcher(line);
        List<Integer> start = new ArrayList<Integer>();
        List<Integer> end = new ArrayList<Integer>();
        List<String> res = new ArrayList<String>();
        while (m1.find())
        {
            start.add(m1.start());
        }
        while (m2.find())
        {
            end.add(m2.end());
        }
        for (;!start.isEmpty();)
        {
            int i = start.size()-1;
            int j = 0;
            while (start.get(i)>=end.get(j))
            {
                j++;
            }
            res.add(line.substring(start.get(i),end.get(j)));
            start.remove(i);
            end.remove(j);
        }
        Collections.reverse(res);
        for (String s : res)
        {
            System.out.println(s);
        }
    }
}


























