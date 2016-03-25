package com.javarush.test.level12.lesson04.task05;

/* Три метода возвращают максимальное из двух переданных в него чисел
Написать public static методы: int max(int, int), long max (long, long), double max (double, double).
Каждый метод должен возвращать максимальное из двух переданных в него чисел.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static int max(int i1, int i2)
    {
        if (i1 > i2)
            return i1;
        else
            return i2;
    }
    public static long max(long i1, long i2)
    {
        if (i1 > i2)
            return i1;
        else
            return i2;
    }
    public static double max(double i1, double i2)
    {
        if (i1 > i2)
            return i1;
        else
            return i2;
    }
}
