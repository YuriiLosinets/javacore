package com.javarush.test.level40.lesson08.task01;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;

/* Отправка GET-запроса через сокет
Перепиши реализацию метода getSite, он должен явно создавать и использовать сокетное соединение Socket с сервером.
Адрес сервера и параметры для GET-запроса получи из параметра url.
Порт используй дефолтный для http.
Классы HttpURLConnection, HttpClient и т.д. не использовать.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        getSite(new URL("http://javarush.ru/social.html"));
    }

    public static void getSite(URL url) {
        try {
            //HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //connection.setRequestMethod("GET");

            Socket s = new Socket(url.getHost(), url.getDefaultPort());
            OutputStream theOutput = s.getOutputStream();
            PrintWriter pw = new PrintWriter(theOutput, false);

            pw.print("GET " + url.getFile() + " HTTP/1.0\r\n");
            pw.print("Accept: text/plain, text/html, text/*\r\n");
            pw.print("\r\n");
            pw.flush();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String responseLine;

            while ((responseLine = bufferedReader.readLine()) != null) {
                System.out.println(responseLine);
            }
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}