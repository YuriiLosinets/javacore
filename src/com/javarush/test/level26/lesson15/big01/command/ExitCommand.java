package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by CMI-USER on 1/13/2016.
 */
class ExitCommand implements Command
{
    ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "exit_en", Locale.ENGLISH);
    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("exit.question.y.n"));

        if (res.getString("yes").equalsIgnoreCase(ConsoleHelper.readString().trim()))
            ConsoleHelper.writeMessage(res.getString("thank.message"));
    }
}
