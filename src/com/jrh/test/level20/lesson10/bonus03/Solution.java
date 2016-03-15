package com.javarush.test.level20.lesson10.bonus03;

import java.util.ArrayList;
import java.util.List;

/* Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endY) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> list = detectAllWords(crossword, "fsgr");
        for (Word word : list)
            System.out.println(word);
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words)
    {
        int rows = crossword.length;
        int columns = crossword[0].length;
        int startX;
        int startY;
        int endX;
        int endY;
        List<Word> list = new ArrayList<Word>();
        for (String word : words)
        {
            char[] w = word.toCharArray();
            for (int i = 0; i < rows; i++)
            {
                for (int j = 0; j < columns; j++)
                {
                    if (crossword[i][j]==(w[0]))
                    {
                        startX = j;
                        startY = i;
                        int q = w.length-1;
                        List<endXY> end = new ArrayList<endXY>();
                        try {if (crossword[startY][startX-q] == w[q]) end.add(new endXY(startX-q, startY));} catch (IndexOutOfBoundsException e) {}
                        try {if (crossword[startY-q][startX] == w[q]) end.add(new endXY(startX, startY-q));} catch (IndexOutOfBoundsException e) {}
                        try {if (crossword[startY-q][startX-q] == w[q]) end.add(new endXY(startX-q, startY-q));} catch (IndexOutOfBoundsException e) {}
                        try {if (crossword[startY][startX+q] == w[q]) end.add(new endXY(startX+q, startY));} catch (IndexOutOfBoundsException e) {}
                        try {if (crossword[startY+q][startX] == w[q]) end.add(new endXY(startX, startY+q));} catch (IndexOutOfBoundsException e) {}
                        try {if (crossword[startY+q][startX-q] == w[q]) end.add(new endXY(startX-q, startY+q));} catch (IndexOutOfBoundsException e) {}
                        try {if (crossword[startY-q][startX+q] == w[q]) end.add(new endXY(startX+q, startY-q));} catch (IndexOutOfBoundsException e) {}
                        try {if (crossword[startY+q][startX+q] == w[q]) end.add(new endXY(startX+q, startY+q));} catch (IndexOutOfBoundsException e) {}
                        if (!end.isEmpty())
                        {
                            for (endXY endxy: end)
                            {
                                String res = String.valueOf((char)crossword[startY][startX]);
                                if (startX == endxy.x && startY == endxy.y)
                                {
                                    Word wo = new Word(res);
                                    wo.setStartPoint(startX,startY);
                                    wo.setEndPoint(endxy.x,endxy.y);
                                    list.add(wo);
                                }
                                else if (startX != endxy.x && startY == endxy.y)
                                {
                                    if (startX>endxy.x) for (int u = startX-1; u >= endxy.x; u--) res = res + String.valueOf((char)crossword[startY][u]);
                                    else if (startX<endxy.x)
                                        for (int u = startX+1; u <= endxy.x; u++)
                                            res = res + String.valueOf((char)crossword[startY][u]);

                                    if (res.equals(String.valueOf(w)))
                                    {
                                        Word wo = new Word(res);
                                        wo.setStartPoint(startX,startY);
                                        wo.setEndPoint(endxy.x,endxy.y);
                                        list.add(wo);
                                    }
                                }
                                else if (startX == endxy.x && startY != endxy.y)
                                {
                                    if (startY>endxy.y) for (int u = startY-1; u >= endxy.y; u--) res = res + String.valueOf((char)crossword[u][startX]);
                                    else if (startY<endxy.y) for (int u = startY+1; u <= endxy.y; u++) res = res + String.valueOf((char)crossword[u][startX]);

                                    if (res.equals(String.valueOf(w)))
                                    {
                                        Word wo = new Word(res);
                                        wo.setStartPoint(startX,startY);
                                        wo.setEndPoint(endxy.x,endxy.y);
                                        list.add(wo);
                                    }
                                }
                                else
                                {
                                    if (startX>endxy.x && startY>endxy.y)
                                    {
                                        for (int u = startX-1; u >= endxy.x;)
                                        {
                                            for (int d = startY-1; d >= endxy.y;)
                                            {
                                                res = res + String.valueOf((char)crossword[d][u]);
                                                u--;
                                                d--;
                                            }
                                        }
                                    }
                                    else if (startX>endxy.x && startY<endxy.y)
                                    {
                                        for (int u = startX-1; u >= endxy.x;)
                                        {
                                            for (int d = startY+1; d <= endxy.y;)
                                            {
                                                res = res + String.valueOf((char)crossword[d][u]);
                                                u--;
                                                d++;
                                            }
                                        }
                                    }
                                    else if (startX<endxy.x && startY>endxy.y)
                                    {
                                        for (int u = startX+1; u <= endxy.x;)
                                        {
                                            for (int d = startY-1; d >= endxy.y;)
                                            {
                                                res = res + String.valueOf((char)crossword[d][u]);
                                                u++;
                                                d--;
                                            }
                                        }
                                    }
                                    else if (startX<endxy.x && startY<endxy.y)
                                    {
                                        for (int u = startX+1; u <= endxy.x;)
                                        {
                                            for (int d = startY+1; d <= endxy.y;)
                                            {
                                                res = res + String.valueOf((char)crossword[d][u]);
                                                u++;
                                                d++;
                                            }
                                        }
                                    }

                                    if (res.equals(String.valueOf(w)))
                                    {
                                        Word wo = new Word(res);
                                        wo.setStartPoint(startX,startY);
                                        wo.setEndPoint(endxy.x,endxy.y);
                                        list.add(wo);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return list;
    }
    private static class endXY
    {
        int x, y;

        public endXY( int x, int y )
        {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString()
        {
            return "(" + x + "," + y + ")";
        }
    }

    public static class Word
    {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text)
        {
            this.text = text;
        }

        public void setStartPoint(int i, int j)
        {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j)
        {
            endX = i;
            endY = j;
        }

        @Override
        public String toString()
        {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
