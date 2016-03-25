package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        FileOutputStream outputStream = new FileOutputStream(reader.readLine());
        FileOutputStream outputStream1 = new FileOutputStream(reader.readLine());
        int q1 = inputStream.available();
        int q2 = inputStream.available()/2;
        while (inputStream.available() > 0)
        {
            if (q1>q2)
            {
                int i = inputStream.read();
                outputStream.write(i);
                q1--;
            }
            else
            {
                int i = inputStream.read();
                outputStream1.write(i);
            }
        }
        reader.close();
        inputStream.close();
        outputStream.close();
        outputStream1.close();
    }
}
