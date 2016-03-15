package com.javarush.test.level19.lesson03.task04;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution
{
    public static class PersonScannerAdapter implements PersonScanner
    {
        private Scanner scanner;

        public PersonScannerAdapter(Scanner scanner)
        {
            this.scanner = scanner;
        }

        @Override
        public Person read() throws IOException
        {
            String s = this.scanner.nextLine();
            String[] parse = s.split(" ");
            SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
            Person person = null;
            try
            {
                person = new Person(parse[1], parse[2], parse[0], formatter.parse(parse[3] + parse[4] + parse[5]));
            }
            catch (ParseException e)
            {

            }
            return person;
        }

        @Override
        public void close() throws IOException
        {
            this.scanner.close();
        }
    }
}
