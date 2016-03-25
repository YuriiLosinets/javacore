package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int i = Integer.parseInt(reader.readLine());
        int j = Integer.parseInt(reader.readLine());
        System.out.println(findGCD(i,j));

    }
    private static int findGCD(int i, int j)
    {
        if(j == 0)
        {
            return i;
        }
        return findGCD(j, i%j);
    }
}
