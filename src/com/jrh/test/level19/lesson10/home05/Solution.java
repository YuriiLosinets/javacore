package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args)  throws IOException
    {
        File file1 = new File(args[0]);
        File file2 = new File(args[1]);
        BufferedReader reader = new BufferedReader(new FileReader(file1));
        FileWriter writer = new FileWriter(file2);
        String line;
        while ((line = reader.readLine())!= null)
        {
            String[] arr = line.split(" ");
            for (int i =0; i < arr.length; i++)
            {
                if (arr[i].matches(".*\\d+.*"))
                {
                    writer.write(arr[i] + " ");
                }
            }

        }
        reader.close();
        writer.close();
    }
}
