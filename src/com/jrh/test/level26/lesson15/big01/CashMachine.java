package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.command.CommandExecutor;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by CMI-USER on 12/18/2015.
 */
public class CashMachine
{
    public static final String RESOURCE_PATH = "com.javarush.test.level26.lesson15.big01.resources.";
    public static void main(String[] args) throws IOException
    {
        ResourceBundle res = ResourceBundle.getBundle(RESOURCE_PATH + "common_en", Locale.ENGLISH);
        Locale.setDefault(Locale.ENGLISH);
        try
        {
            CommandExecutor.execute(Operation.LOGIN);
            Operation operation;
            do
            {
                ConsoleHelper.writeMessage(res.getString("choose.operation") + " \n" +
                        res.getString("operation.INFO") + ": 1;\n" +
                        res.getString("operation.DEPOSIT") + ": 2;\n" +
                        res.getString("operation.WITHDRAW") + ": 3;\n" +
                        res.getString("operation.EXIT") + ": 4");
                operation = ConsoleHelper.askOperation();

                CommandExecutor.execute(operation);
            }
            while (operation != Operation.EXIT);
        }
        catch (InterruptOperationException e)
        {
            try
            {
                CommandExecutor.execute(Operation.EXIT);
            }
            catch (InterruptOperationException e1)
            {
            }
            ConsoleHelper.printExitMessage();
        }
    }
}
