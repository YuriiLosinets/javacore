package com.javarush.test.level06.lesson11.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Нужно добавить в программу новую функциональность
Задача: У каждой кошки есть имя и кошка-мама. Создать класс, который бы описывал данную ситуацию. Создать два объекта: кошку-дочь и кошку-маму. Вывести их на экран.
Новая задача: У каждой кошки есть имя, кошка-папа и кошка-мама. Изменить класс Cat так, чтобы он мог описать данную ситуацию.
Создать 6 объектов: маму, папу, сына, дочь, бабушку(мамина мама) и дедушку(папин папа).
Вывести их всех на экран в порядке: дедушка, бабушка, папа, мама, сын, дочь.

Пример ввода:
дедушка Вася
бабушка Мурка
папа Котофей
мама Василиса
сын Мурчик
дочь Пушинка

Пример вывода:
Cat name is дедушка Вася, no mother, no father
Cat name is бабушка Мурка, no mother, no father
Cat name is папа Котофей, no mother, father is дедушка Вася
Cat name is мама Василиса, mother is бабушка Мурка, no father
Cat name is сын Мурчик, mother is мама Василиса, father is папа Котофей
Cat name is дочь Пушинка, mother is мама Василиса, father is папа Котофей
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String granpaName = reader.readLine();
        Cat catGranpa = new Cat(granpaName);

        String granmaName = reader.readLine();
        Cat catGranma = new Cat(granmaName);

        String dadName = reader.readLine();
        Cat catDad = new Cat(dadName, catGranpa, null);

        String momName = reader.readLine();
        Cat catMom= new Cat(momName, null, catGranma);

        String sonName = reader.readLine();
        Cat catSon = new Cat(sonName, catDad, catMom);

        String doterName = reader.readLine();
        Cat catDoter = new Cat(doterName, catDad, catMom);

        System.out.println(catGranpa);
        System.out.println(catGranma);
        System.out.println(catDad);
        System.out.println(catMom);
        System.out.println(catSon);
        System.out.println(catDoter);
    }

    public static class Cat
    {
        private String name;
        private Cat pa;
        private Cat ma;

        public Cat(String name)
        {
            this.name = name;
        }

        public Cat(String name, Cat pa, Cat ma)
        {
            this.name = name;
            this.pa = pa;
            this.ma = ma;
        }

        @Override
        public String toString()
        {
            if ((ma == null)&&(pa == null))
                return "Cat name is " + name + ", no mother, no father";
            else if (pa == null)
                return "Cat name is " + name + ", mother is " + ma.name + ", no father";
            else if (ma == null)
                return "Cat name is " + name + ", no mother, father is " + pa.name;
            else
                return "Cat name is " + name + ", mother is " + ma.name + ", father is " + pa.name;
        }
    }

}
