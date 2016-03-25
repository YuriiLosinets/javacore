package com.javarush.test.level22.lesson13.task02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution
{
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException
    {
        if (args.length == 2)
        {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            FileWriter writer = new FileWriter(args[1]);
            while (reader.ready())
            {
                String result = new String(reader.readLine().getBytes("windows-1251"), Charset.forName("UTF-8"));
                writer.write(result);
            }
            reader.close();
            writer.close();
        }
    }
}
