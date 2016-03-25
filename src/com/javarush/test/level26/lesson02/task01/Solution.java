package com.javarush.test.level26.lesson02.task01;

import java.util.Arrays;
import java.util.Comparator;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution
{
    public static Integer[] sort(Integer[] array)
    {
        final double median;
        Arrays.sort(array);
        if (array.length%2!=0)
            median = array[array.length/2];
        else
            median = ((double)array[array.length/2-1]+(double)array[array.length/2])/2;

        Comparator<Integer> comparator = new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                double d = Math.abs(o1 - median) - Math.abs(o2 - median);
                if (d == 0) d = o1 - o2;
                return (int) d;
            }
        };
        Arrays.sort(array, comparator);
        return array;
    }

    public static void main(String[] args)
    {
        Integer[] array = {1,2,3,4,5,6,7,8,9};
        array = sort(array);
        for (Integer i : array)
            System.out.print(i + " ");
    }
}
