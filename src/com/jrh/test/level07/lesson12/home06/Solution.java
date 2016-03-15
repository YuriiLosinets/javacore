package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        Human Ded1 = new Human("Ded1", true, 76);
        Human Ded2 = new Human("Ded2", true, 78);
        Human Babka1 = new Human("Babaka1", false, 72);
        Human Babka2 = new Human("Babaka2", false, 74);
        Human Dad = new Human("Dad", true, 50, Ded1, Babka1);
        Human Mom = new Human("Mom", false, 45, Ded2, Babka2);
        Human Son1 = new Human("Son1", true, 25, Dad, Mom);
        Human Son2 = new Human("Son2", true, 30, Dad, Mom);
        Human Don = new Human("Don", false, 22, Dad, Mom);

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
        private int age;
        private Human father;
        private Human mother;

        public Human(String name, boolean sex, int age)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
