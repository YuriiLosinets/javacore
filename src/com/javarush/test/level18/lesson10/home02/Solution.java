package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        FileInputStream inputStream = new FileInputStream(args[0]);
        int chars = 0;
        int space = 0;
        while (inputStream.available() > 0)
        {
            int data = inputStream.read();
            if (data == 32)
            {
                chars++;
                space++;
            }
            else
                chars ++;
        }
        double result = (double) space/chars * 100;


        inputStream.close();
        System.out.println(new BigDecimal(result).setScale(2, BigDecimal.ROUND_DOWN));
    }
}
