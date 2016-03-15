package com.javarush.test.level19.lesson03.task03;

/* Адаптация нескольких интерфейсов
Адаптировать IncomeData к Customer и Contact.
Классом-адаптером является IncomeDataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
Дополнить телефонный номер нулями до 10 цифр при необходимости (смотри примеры)
Обратите внимание на формат вывода фамилии и имени человека
*/

import java.util.HashMap;
import java.util.Map;

public class Solution
{
    public static Map<String, String> countries = new HashMap<String, String>();
    static
    {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }
    public static class IncomeDataAdapter implements Customer, Contact
    {
        private IncomeData incomeData;

        public IncomeDataAdapter(IncomeData incomeData)
        {
            this.incomeData = incomeData;
        }

        @Override
        public String getName()
        {
            return incomeData.getContactLastName() + ", " + incomeData.getContactFirstName();
        }

        @Override
        public String getPhoneNumber()
        {
            String s = String.valueOf(incomeData.getPhoneNumber());
            for (int i = s.length(); i < 10; i++) s = "0" + s;
            return String.format("+%1$d(%2$3s)%3$3s-%4$2s-%5$2s"
                    , incomeData.getCountryPhoneCode()
                    , s.substring(0,3)
                    , s.substring(3,6)
                    , s.substring(6,8)
                    , s.substring(8));
        }

        @Override
        public String getCompanyName()
        {
            return incomeData.getCompany();
        }

        @Override
        public String getCountryName()
        {
            return countries.get(incomeData.getCountryCode());
        }
    }

    public static interface IncomeData
    {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer
    {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact
    {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }
}