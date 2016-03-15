package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        private String name;
        private int age;
        private boolean sex;
        private int salary;
        private Human Dad;
        private Human Mom;

        public Human(String name)
        {
            this.name = name;
        }

        public Human(String name, int age)
        {
            this.name = name;
            this.age = age;
        }

        public Human(String name, int age, boolean sex)
        {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        public Human(String name, int age, boolean sex, int salary)
        {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.salary = salary;
        }

        public Human(String name, int age, boolean sex, int salary, Human Dad)
        {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.salary = salary;
            this.Dad = Dad;
        }

        public Human(String name, int age, boolean sex, int salary, Human Dad, Human Mom)
        {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.salary = salary;
            this.Dad = Dad;
            this.Mom = Mom;
        }

        public Human(String name, Human Dad, Human Mom)
        {
            this.name = name;
            this.Dad = Dad;
            this.Mom = Mom;
        }

        public Human(String name, boolean sex, int salary, Human Dad, Human Mom)
        {
            this.name = name;
            this.sex = sex;
            this.salary = salary;
            this.Dad = Dad;
            this.Mom = Mom;
        }

        public Human(String name, boolean sex, int salary)
        {
            this.name = name;
            this.sex = sex;
            this.salary = salary;
        }

        public Human(String name, int age, boolean sex, Human Dad, Human Mom)
        {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.Dad = Dad;
            this.Mom = Mom;
        }
    }
}
