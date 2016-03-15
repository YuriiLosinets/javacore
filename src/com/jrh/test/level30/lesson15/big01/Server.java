package com.javarush.test.level30.lesson15.big01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by CMI-USER on 1/18/2016.
 */
public class Server
{
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    private static class Handler extends Thread
    {
        private Socket socket;

        public Handler(Socket socket)
        {
            this.socket = socket;
        }

        @Override
        public void run()
        {
            ConsoleHelper.writeMessage(socket.getRemoteSocketAddress() + "connection");
            String clientName = null;
            try (Connection connection = new Connection(socket))
            {
                clientName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, clientName));
                sendListOfUsers(connection, clientName);
                serverMainLoop(connection, clientName);
            }
            catch (IOException e)
            {
                ConsoleHelper.writeMessage("Error");
            }
            catch (ClassNotFoundException e1)
            {
                ConsoleHelper.writeMessage("Error");
            }

            connectionMap.remove(clientName);
            sendBroadcastMessage(new Message(MessageType.USER_REMOVED, clientName));
            ConsoleHelper.writeMessage("Connection closed");
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException
        {
            while (true)
            {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message message = connection.receive();

                if (message.getType() == MessageType.USER_NAME)
                {
                    if (message.getData() != null && !message.getData().isEmpty())
                    {
                        if (connectionMap.get(message.getData()) == null)
                        {
                            connectionMap.put(message.getData(), connection);
                            connection.send(new Message(MessageType.NAME_ACCEPTED));
                            return message.getData();
                        }
                    }
                }
            }
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException
        {
            for (String s : connectionMap.keySet())
            {
                if (!s.equalsIgnoreCase(userName))
                    connection.send(new Message(MessageType.USER_ADDED, s));
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException
        {
            while (true)
            {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT)
                {
                    String s = userName + ": " + message.getData();
                    Message formattedMessage = new Message(MessageType.TEXT, s);
                    sendBroadcastMessage(formattedMessage);
                }
                else
                    ConsoleHelper.writeMessage("Error");
            }
        }
    }

    public static void main(String[] args)
    {
        ConsoleHelper.writeMessage("Please enter server port:");
        int serverPort = ConsoleHelper.readInt();
        try (ServerSocket serverSocket = new ServerSocket(serverPort))
        {

            ConsoleHelper.writeMessage("Сервер запущен");

            while (true)
            {
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.start();
            }
        }
        catch (Exception e)
        {
            ConsoleHelper.writeMessage("Error");
        }
    }

    public static void sendBroadcastMessage(Message message)
    {
        try
        {

            for (Connection connection : connectionMap.values())
            {
                connection.send(message);
            }

        }
        catch (IOException e)
        {
            ConsoleHelper.writeMessage("Message doesn't send");
        }

    }

}
