package com.javarush.test.level26.lesson15.big01.command;

/**
 * Created by CMI-USER on 1/13/2016.
 */
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.IOException;


interface Command
{
    void execute() throws InterruptOperationException;
}
