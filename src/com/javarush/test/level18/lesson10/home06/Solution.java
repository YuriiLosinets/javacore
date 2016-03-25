package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.awt.font.FontRenderContext;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        FileInputStream inputStream = new FileInputStream(args[0]);
//        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
//        FileInputStream inputStream = new FileInputStream(new File(rd.readLine()));

        byte[] symbols = new byte[inputStream.available()];
        inputStream.read(symbols);
        Arrays.sort(symbols);

        HashMap<Byte, Integer> map = new HashMap<Byte, Integer>();

        int count;


        for (byte x : symbols) {
            count = 0;

            for (byte x1 : symbols) {
                if (x == x1) {
                    count++;
                }
            }

            if (!map.containsKey(x))
            {
                map.put(x, count);
                System.out.println((char) x + " " + count);
            }


        }
        inputStream.close();

    }
}
