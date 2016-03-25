package com.javarush.test.level05.lesson07.task05;

/* Создать класс прямоугольник (Rectangle)
Создать класс прямоугольник (Rectangle). Его данными будут top, left, width, height (левая координата, верхняя, ширина и высота). Создать для него как можно больше методов initialize(…)
Примеры:
-	заданы 4 параметра: left, top, width, height
-	ширина/высота не задана (оба равны 0)
-	высота не задана (равно ширине) создаём квадрат
-	создаём копию другого прямоугольника (он и передаётся в параметрах)
*/

public class Rectangle
{
    private int top;
    private int left;
    private int width;
    private int height;

    public void initialize (int top)
    {
        this.top = top;
        left = 0;
        width = 0;
        height = 0;
    }

    public void initialize (int top, int left)
    {
        this.top = top;
        this.left = left;
        width = 0;
        height = 0;
    }

    public void initialize (int top, int left, int width)
    {
        this.top = top;
        this.left = left;
        this.width = width;
        height = width;
    }

    public void initialize (Rectangle rect)
    {
        this.top = rect.top;
        this.left = rect.left;
        this.width = rect.width;
        this.height = rect.height;
    }

}
