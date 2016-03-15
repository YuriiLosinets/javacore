package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution
{
    String name;
    int i;
    boolean b;
    double d;
    char ch;
    float f;

    Solution()
    {

    }
    Solution(String name)
    {
        this.name = name;
    }
    Solution(String name, int i)
    {
        this.name = name;
        this.i = i;
    }
    public Solution(int i, String name)
    {
        this.name = name;
        this.i = i;
    }
    public Solution(int i, double d)
    {
        this.d = d;
        this.i = i;
    }
    public Solution(double d, int i)
    {
        this.d = d;
        this.i = i;
    }
    private Solution(double d, char ch)
    {
        this.d = d;
        this.ch = ch;
    }
    private Solution(char ch, double d)
    {
        this.d = d;
        this.ch = ch;
    }
    private Solution(double d, String name)
    {
        this.d = d;
        this.name = name;
    }
    protected Solution(float f, char ch)
    {
        this.f = f;
        this.ch = ch;
    }
    protected Solution(char ch, String name)
    {
        this.name = name;
        this.ch = ch;
    }
    protected Solution(char ch, float f)
    {
        this.f = f;
        this.ch = ch;
    }
}

