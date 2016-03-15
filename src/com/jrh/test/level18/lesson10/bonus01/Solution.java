package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        if (args[0].equals("-e"))
        {
            String sourceFile = args[1];
            String destinationFile = args[2];
            int k = 3;
            FileInputStream fileInputStream = new FileInputStream(sourceFile);
            FileOutputStream fileOutputStream = new FileOutputStream(destinationFile);
            while (fileInputStream.available()>0)
            {
                int i = fileInputStream.read();
                i += k;
                fileOutputStream.write(i);
            }
        }
        else if (args[0].equals("-d"))
        {
            String sourceFile = args[1];
            String destinationFile = args[2];
            int k = 3;
            FileInputStream fileInputStream = new FileInputStream(sourceFile);
            FileOutputStream fileOutputStream = new FileOutputStream(destinationFile);
            while (fileInputStream.available()>0)
            {
                int i = fileInputStream.read();
                i -= k;
                fileOutputStream.write(i);
            }
        }

    }

}
