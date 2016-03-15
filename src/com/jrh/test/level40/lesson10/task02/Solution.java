package com.javarush.test.level40.lesson10.task02;

/* Работа с Joda Time
Выполни задание, используя библиотеку Joda Time версии 2.9.1
Реализуй метод printDate(String date).
Он должен в качестве параметра принимать дату (в одном из 3х форматов)
и выводить ее в консоль в соответсвии с примером:

1) Для "21.4.2014 15:56:45" вывод должен быть:
День: 21
День недели: 2
День месяца: 21
День года: 111
Неделя месяца: 4
Неделя года: 17
Месяц: 3
Год: 2014
Эра: 1
AM или PM: 1
Часы: 3
Часы дня: 15
Минуты: 56
Секунды: 45

2) Для "21.4.2014":
День: 21
День недели: 2
День месяца: 21
День года: 111
Неделя месяца: 4
Неделя года: 17
Месяц: 3
Год: 2014
Эра: 1

3) Для "17:33:40":
AM или PM: 1
Часы: 5
Часы дня: 17
Минуты: 33
Секунды: 40
*/

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Solution {
    public static void main(String[] args)
    {
        printDate("06.1.2012 15:56:45");
        //System.out.println();
        //printDate("21.4.2014");
        //System.out.println();
        //printDate("17:33:40");
    }

    public static void printDate(String date)
    {
        if (date.length() == 18)
        {
            DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("dd.M.yyyy HH:mm:ss");
            DateTime dateTime = dateTimeFormatter.parseDateTime(date);
            System.out.println(String.format("День: %d\n" +
                            "День недели: %d\n" +
                            "День месяца: %d\n" +
                            "День года: %d\n" +
                            "Неделя месяца: %d\n" +
                            "Неделя года: %d\n" +
                            "Месяц: %d\n" +
                            "Год: %d\n" +
                            "Эра: %d\n" +
                            "AM или PM: %d\n" +
                            "Часы: %d\n" +
                            "Часы дня: %d\n" +
                            "Минуты: %d\n" +
                            "Секунды: %d",
                    dateTime.getDayOfMonth(),
                    dateTime.getDayOfWeek(),
                    dateTime.getDayOfMonth(),
                    dateTime.getDayOfYear(),
                    dateTime.weekOfWeekyear(),
                    dateTime.weekOfWeekyear().get(),
                    dateTime.getMonthOfYear(),
                    dateTime.getYear(),
                    dateTime.getEra(),
                    dateTime.getHourOfDay() >= 12 ? 1 : 0,
                    dateTime.getHourOfDay() % 12,
                    dateTime.getHourOfDay(),
                    dateTime.getMinuteOfHour(),
                    dateTime.getSecondOfMinute()));
        }
        else if (date.length() == 9)
        {
            DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("dd.M.yyyy");
            DateTime dateTime = dateTimeFormatter.parseDateTime(date);
            System.out.println(String.format("День: %d\n" +
                            "День недели: %d\n" +
                            "День месяца: %d\n" +
                            "День года: %d\n" +
                            "Неделя месяца: %d\n" +
                            "Неделя года: %d\n" +
                            "Месяц: %d\n" +
                            "Год: %d\n" +
                            "Эра: %d",
                    dateTime.getDayOfMonth(),
                    (dateTime.getDayOfWeek() % 7 + 1),
                    dateTime.getDayOfMonth(),
                    dateTime.getDayOfYear(),
                    ((dateTime.getDayOfYear() > 350 && dateTime.getWeekOfWeekyear() < 50) ? 53 : dateTime.getWeekOfWeekyear())-dateTime.withDayOfMonth(1).getWeekOfWeekyear()+1,
                    (dateTime.getMonthOfYear() < 10 && dateTime.getWeekOfWeekyear() > 50) ? 1 : dateTime.getWeekOfWeekyear(),
                    dateTime.getMonthOfYear()-1,
                    dateTime.getYear(),
                    dateTime.getEra()));
        }
        else if (date.length() == 8)
        {
            DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("HH:mm:ss");
            DateTime dateTime = dateTimeFormatter.parseDateTime(date);
            System.out.println(String.format(
                            "AM или PM: %d\n" +
                            "Часы: %d\n" +
                            "Часы дня: %d\n" +
                            "Минуты: %d\n" +
                            "Секунды: %d",
                    dateTime.getHourOfDay() >= 12 ? 1 : 0,
                    dateTime.getHourOfDay() % 12,
                    dateTime.getHourOfDay(),
                    dateTime.getMinuteOfHour(),
                    dateTime.getSecondOfMinute()));
        }
    }
}
