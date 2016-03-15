package com.javarush.test.level15.lesson04.task02;

/* ООП - Перегрузка
Перегрузите метод printMatrix 8 различными способами. В итоге должно получиться 10 различных методов printMatrix.
*/

public class Solution
{
    public static void main(String[] args)
    {
        printMatrix(2.0, 3, "8");
        printMatrix(2, 3, "8");
        printMatrix(2, "8", 3);
        printMatrix(2, 3, "8");
        printMatrix(2, "8", 3);
        printMatrix("8", 2, 3);
        printMatrix("8", 2, 3);
    }

    public static void printMatrix(int m, int n, String value)
    {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }
    public static void printMatrix(double m, int n, String value)
    {
        System.out.println("Заполняем объектами String");
        printMatrix((int) m, n, (Object) value);
    }
    public static void printMatrix(double m, double n, String value)
    {
        System.out.println("Заполняем объектами String");
        printMatrix((int) m, (int) n, (Object) value);
    }
    public static void printMatrix(int m, String value, int n)
    {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }
    public static void printMatrix(String value, int m, int n)
    {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }


    public static void printMatrix(int m, int n, Object value)
    {
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                System.out.print(value);
            }
            System.out.println();
        }
    }
    public static void printMatrix(double m, int n, Object value)
    {
        for (int i = 0; i < (int) m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                System.out.print(value);
            }
            System.out.println();
        }
    }
    public static void printMatrix(double m, double n, Object value)
    {
        for (int i = 0; i < (int) m; i++)
        {
            for (int j = 0; j < (int) n; j++)
            {
                System.out.print(value);
            }
            System.out.println();
        }
    }
    public static void printMatrix(int m, Object value, int n)
    {
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                System.out.print(value);
            }
            System.out.println();
        }
    }
    public static void printMatrix(Object value, int m, int n)
    {
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                System.out.print(value);
            }
            System.out.println();
        }
    }
}
