package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        Human Son1 = new Human("Son1", true, 25);
        Human Son2 = new Human("Son2", true, 23);
        Human Don = new Human("Don", false, 21);
        Human Dad = new Human("Dad", true, 45, Son1, Son2, Don);
        Human Mom = new Human("Mom", false, 40, Son1, Son2, Don);
        Human Ded1 = new Human("Ded1", true, 65, Dad);
        Human Ded2 = new Human("Ded2", true, 67, Mom);
        Human Babka1 = new Human("Babka1", false, 62, Dad);
        Human Babka2 = new Human("Babka2", false, 60, Mom);

        System.out.println(Ded1);
        System.out.println(Ded2);
        System.out.println(Babka1);
        System.out.println(Babka2);
        System.out.println(Dad);
        System.out.println(Mom);
        System.out.println(Son1);
        System.out.println(Son2);
        System.out.println(Don);
    }

    public static class Human
    {
        private String name;
        private boolean sex;
        private  int age;
        private ArrayList<Human> children = new ArrayList<Human>();

        public Human(String name, boolean sex, int age)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human x1)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children.add(x1);
        }
        public Human(String name, boolean sex, int age, Human x1, Human x2, Human x3)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children.add(x1);
            this.children.add(x2);
            this.children.add(x3);
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
