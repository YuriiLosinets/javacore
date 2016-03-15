package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by CMI-USER on 1/18/2016.
 */
public class BotClient extends Client
{
    private static int botsCounter = 0;
    @Override
    protected SocketThread getSocketThread()
    {
        return new BotSocketThread();
    }

    @Override
    protected String getUserName()
    {
        if(botsCounter == 99)

        {
            botsCounter = 0;
        }

        return"date_bot_" + botsCounter++;
    }

    @Override
    protected boolean shouldSentTextFromConsole()
    {
        return false;
    }

    public static void main(String[] args)
    {
        new BotClient().run();
    }

    public class BotSocketThread extends SocketThread
    {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException
        {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message)
        {

            ConsoleHelper.writeMessage(message);

            String senderName = "";
            String senderMessageText;

            if (message.contains(": "))
            {
                senderName = message.substring(0, message.indexOf(": "));
                senderMessageText = message.substring(message.indexOf(": ") + 2);
            }
            else
            {
                senderMessageText = message;
            }

            SimpleDateFormat format = null;
            switch (senderMessageText)
            {
                case "дата":
                {
                    format = new SimpleDateFormat("d.MM.YYYY");
                    break;
                }

                case "день":
                {
                    format = new SimpleDateFormat("d");
                    break;
                }

                case "месяц":
                {
                    format = new SimpleDateFormat("MMMM");
                    break;
                }

                case "год":
                {
                    format = new SimpleDateFormat("YYYY");
                    break;
                }

                case "время":
                {
                    format = new SimpleDateFormat("H:mm:ss");
                    break;
                }

                case "час" :
                {
                    format = new SimpleDateFormat("H");
                    break;
                }

                case "минуты" :
                {
                    format = new SimpleDateFormat("m");
                    break;
                }

                case "секунды" :
                {
                    format = new SimpleDateFormat("s");
                    break;
                }
            }

            if (format != null)
            {
                sendTextMessage("Информация для " + senderName + ": " + format.format(Calendar.getInstance().getTime()));
            }
        }
    }
}
