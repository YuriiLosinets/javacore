package com.javarush.test.level05.lesson12.bonus03;

import java.io.*;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sN = reader.readLine();
        Integer N = Integer.parseInt(sN);
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++)
        {
            String sM = reader.readLine();
            Integer M = Integer.parseInt(sM);
            numbers[i] = M;
        }
        int maximum = max(numbers);
        System.out.println(maximum);
    }
    public static int max(int[] numbers)
    {
        int maxNumber = Integer.MIN_VALUE;

        for (int number : numbers)
        {
            maxNumber = (number > maxNumber) ? number : maxNumber;
        }

        return maxNumber;
    }
}
