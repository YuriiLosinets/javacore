package com.javarush.test.level13.lesson11.home07;

/* ��������� SimpleObject
1. ������ ����� StringObject.
2. � ������ StringObject �������� ��������� SimpleObject � ���������� ���� String.
3. ��������� ������ ���������������.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
       SimpleObject<String> stringObject = new StringObject<Object>();
    }

    interface SimpleObject<T>
    {
        SimpleObject<T> getInstance();
    }

    public static class StringObject<Object> implements SimpleObject<String> {
        @Override
        public StringObject<String> getInstance() {
            return new StringObject<String>();
        }


    }

}