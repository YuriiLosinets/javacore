package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.Connection;
import com.javarush.test.level30.lesson15.big01.ConsoleHelper;
import com.javarush.test.level30.lesson15.big01.Message;
import com.javarush.test.level30.lesson15.big01.MessageType;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by CMI-USER on 1/18/2016.
 */
public class Client
{
    protected Connection connection;
    private volatile boolean clientConnected = false;

    public static void main(String[] args)
    {
        Client client = new Client();
        client.run();
    }

    public void run()
    {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
        try
        {
            synchronized (this)
            {
                this.wait();
            }
        }
        catch (InterruptedException e)
        {
            ConsoleHelper.writeMessage("Error");
            return;
        }

        if (clientConnected)
        {
            ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
            while (clientConnected)
            {
                String message;
                if (!(message = ConsoleHelper.readString()).equals("exit"))
                {
                    if (shouldSentTextFromConsole())
                    {
                        sendTextMessage(message);
                    }
                }
                else
                {
                    return;
                }
            }
        }
        else
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
    }

    public class SocketThread extends Thread
    {
        @Override
        public void run()
        {
           try
           {
               Socket socket = new Socket(getServerAddress(), getServerPort());
               Client.this.connection = new Connection(socket);
               clientHandshake();
               clientMainLoop();

           }
           catch (IOException e)
           {
               notifyConnectionStatusChanged(false);
           }
           catch (ClassNotFoundException e)
           {
               notifyConnectionStatusChanged(false);
           }

        }

        protected void processIncomingMessage(String message)
        {
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName)
        {
            ConsoleHelper.writeMessage(userName + " connected to chat");
        }

        protected void informAboutDeletingNewUser(String userName)
        {
            ConsoleHelper.writeMessage(userName + " leave chat");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected)
        {
            Client.this.clientConnected = clientConnected;

            synchronized (Client.this)
            {
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException
        {
            while (true)
            {
                Message message = connection.receive();
                switch (message.getType())
                {

                    case NAME_REQUEST:
                    {

                        String userName = getUserName();
                        connection.send(new Message(MessageType.USER_NAME, userName));
                        break;
                    }

                    case NAME_ACCEPTED:
                    {

                        notifyConnectionStatusChanged(true);
                        return;
                    }

                    default:
                    {
                        throw new IOException("Unexpected MessageType");
                    }
                }
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException
        {
            while (true)
            {
                Message message = connection.receive();
                switch (message.getType())
                {

                    case TEXT:
                    {

                        processIncomingMessage(message.getData());
                        break;
                    }

                    case USER_ADDED:
                    {

                        informAboutAddingNewUser(message.getData());
                        break;
                    }

                    case USER_REMOVED:
                    {

                        informAboutDeletingNewUser(message.getData());
                        break;
                    }

                    default:
                    {
                        throw new IOException("Unexpected MessageType");
                    }
                }
            }
        }
    }

    protected String getServerAddress()
    {
        ConsoleHelper.writeMessage("Please enter server address:");
        return ConsoleHelper.readString();
    }

    protected int getServerPort()
    {
        ConsoleHelper.writeMessage("Please enter server port:");
        return ConsoleHelper.readInt();
    }

    protected String getUserName()
    {
        ConsoleHelper.writeMessage("Please enter username");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSentTextFromConsole()
    {
        return true;
    }

    protected SocketThread getSocketThread()
    {
        return new SocketThread();
    }

    protected void sendTextMessage(String text)
    {
        try
        {
            connection.send(new Message(MessageType.TEXT, text));
        }
        catch (IOException e)
        {
            ConsoleHelper.writeMessage("Sending message error");
            clientConnected = false;
        }
    }
}
