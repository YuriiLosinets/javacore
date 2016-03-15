package com.javarush.test.level20.lesson10.home06;

import java.io.*;

/* Запрет сериализации
Запретите сериализацию класса SubSolution используя NotSerializableException.
Сигнатуры классов менять нельзя
*/
public class Solution implements Serializable
{
    private static final long serialVersionUID = 1L;

    public static class SubSolution extends Solution
    {
        private static final long serialVersionUID = 2L;

        private void writeObject(ObjectOutputStream out) throws IOException, InterruptedException
        {
            throw new NotSerializableException();
        }
        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
        {
            throw new NotSerializableException();
        }
    }
}
