package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution
{
    private static List<String> list = new ArrayList<String>();
    public static void main(String[] args) throws IOException
    {
        if (args[0].equals("-c"))
        {
            BufferedReader consolereader = new BufferedReader(new InputStreamReader(System.in));
            File file = new File(consolereader.readLine());
            consolereader.close();
            list = getListWithAllLines(file);
            list.add(createNewLine(args, list));
            writeAllToFile(file, list);
        }
    }

    public static List<String> getListWithAllLines(File file) throws IOException
    {
        List<String> list = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) if (!line.isEmpty()) if (line.substring(0,8).trim().matches("[0-9]+")) list.add(line);
        reader.close();
        return list;
    }

    public static String getNewID(List<String> list)
    {
        int newID = 1;
        for (String s : list)
        {
            int ID = Integer.parseInt(s.substring(0,8).trim());
            if (ID >= newID) newID = ID + 1;  if (newID > 99999999) newID = 99999999;
        }
        return Integer.toString(newID);
    }

    public static String createNewLine(String[] args, List<String> list)
    {
        String name = "";
        for (int i = 1; i < args.length-2; i++) name = name + args[i] + " ";
        return String.format("%-8.8s%-30.30s%-8.8s%-4.4s",getNewID(list),name,args[args.length-2],args[args.length-1]);
    }

    public static void writeAllToFile(File file, List<String> list) throws IOException
    {
        FileWriter writer = new FileWriter(file, false);
        for (String eachLine : list)
        {
            if(!(eachLine.isEmpty()) && !(eachLine.equals("")))
            {
                writer.write(eachLine);
                writer.write(System.getProperty("line.separator"));
            }
        }
        writer.close();
    }
}
