package com.javarush.test.level20.lesson10.bonus04;

import java.io.*;
import java.util.*;

/* Свой список
Посмотреть, как реализован LinkedList.
Элементы следуют так: 1->2->3->4  и так 4->3->2->1
По образу и подобию создать Solution.
Элементы должны следовать так:
1->3->7->15
    ->8...
 ->4->9
    ->10
2->5->11
    ->12
 ->6->13
    ->14
Удалили 2 и 9
1->3->7->15
    ->8
 ->4->10
Добавили 16,17,18,19,20 (всегда добавляются на самый последний уровень к тем элементам, которые есть)
1->3->7->15
       ->16
    ->8->17
       ->18
 ->4->10->19
        ->20
Удалили 18 и 20
1->3->7->15
       ->16
    ->8->17
 ->4->10->19
Добавили 21 и 22 (всегда добавляются на самый последний уровень к тем элементам, которые есть.
Последний уровень состоит из 15, 16, 17, 19. 19 последний добавленный элемент, 10 - его родитель.
На данный момент 10 не содержит оба дочерних элемента, поэтому 21 добавился к 10. 22 добавляется в следующий уровень.)
1->3->7->15->22
       ->16
    ->8->17
 ->4->10->19
        ->21

Во внутренней реализации элементы должны добавляться по 2 на каждый уровень
Метод getParent должен возвращать элемент, который на него ссылается.
Например, 3 ссылается на 7 и на 8, т.е.  getParent("8")=="3", а getParent("13")=="6"
Строки могут быть любыми.
При удалении элемента должна удаляться вся ветка. Например, list.remove("5") должен удалить "5", "11", "12"
Итерироваться элементы должны в порядке добавления
Доступ по индексу запрещен, воспользуйтесь при необходимости UnsupportedOperationException
Должно быть наследование AbstractList<String>, List<String>, Cloneable, Serializable
Метод main в тестировании не участвует
*/
public class Solution extends AbstractList<String> implements List<String>, Cloneable, Serializable
{
    int size = 0;

    Node<String> root = new Node<>(null, null);
    Node<String> parent = root;

    @Override
    protected Solution clone() throws CloneNotSupportedException
    {
        return (Solution) super.clone();
    }


    public static void main(String[] args)
    {
        List<String> list = new Solution();
        for (int i = 1; i < 16; i++)
        {
            list.add(String.valueOf(i));
        }

        System.out.println("Expected 3, actual is " + ((Solution) list).getParent("8"));
        list.remove("5");
        System.out.println("Expected null, actual is " + ((Solution) list).getParent("11"));

        for (char i = 'a'; i < 'f'; i++)
        {
            list.add(String.valueOf((i)));
        }

        System.out.println("Expected 2, actual is " + ((Solution) list).getParent("a"));
        System.out.println("Expected a, actual is " + ((Solution) list).getParent("b"));
        System.out.println("Expected a, actual is " + ((Solution) list).getParent("c"));
        System.out.println("Expected 7, actual is " + ((Solution) list).getParent("d"));
        System.out.println("Expected 8, actual is " + ((Solution) list).getParent("e"));
    }

    public Queue<Node<String>> getSubTree(Node<String> top)
    {
        Queue<Node<String>> queue = new LinkedList<>();
        Queue<Node<String>> subTree = new LinkedList<>();
        if (top != root)
            subTree.add(top);
        do
        {
            if (top.left != null) queue.add(top.left);
            if (top.right != null) queue.add(top.right);
            if (!queue.isEmpty()) top = queue.poll();
            subTree.add(top);
        }
        while (!queue.isEmpty());
        return subTree;
    }

    @Override
    public boolean remove(Object value)
    {
        Queue<Node<String>> queueForRemove = getSubTree(findNode((String) value));

        parent = findNode((String) value).parent;
        for (Node<String> node : queueForRemove)
        {
            if (node.parent != null && node.left != null && node.parent.left.equals(node))
                node.parent.left = null;
            else if (node.parent != null)
                node.parent.right = null;
            node = null;
        }
        return true;
    }

    public String getParent(String value)
    {
        Node<String> searchingNode = findNode(value);
        if (searchingNode == null)
            return null;
        return (searchingNode.parent == null) ? null : searchingNode.parent.value;
    }

    Node<String> findNode(String value)
    {
        Queue<Node<String>> wholeTree = getSubTree(root);
        for (Node<String> node : wholeTree)
        {
            if (node.value == null)
                return null;
            if (node.value.equals(value))
                return node;
        }
        return null;
    }

    @Override
    public boolean add(String value)
    {
        Node<String> newNode = new Node<>(value, parent);

        if (parent.left == null)
        {
            newNode.parent = parent;
            parent.left = newNode;
            size++;
        }
        else if (parent.right == null)
        {
            newNode.parent = parent;
            parent.right = newNode;
            size++;
        }
        else
        {
            Queue<Node<String>> wholeTree = getSubTree(root);
            for (Node<String> node : wholeTree)
            {
                if (node.left == null || node.right == null)
                {
                    parent = node;
                    break;
                }
            }
            add(value);
        }

        return true;
    }

    private static class Node<String>
    {
        String value;
        Node<String> parent;
        Node<String> left;
        Node<String> right;

        private Node(String value, Node<String> parent)
        {
            this.value = value;
            this.parent = parent;
        }
    }

    @Override
    public String get(int index)
    {
        return null;
    }

    @Override
    public int size()
    {
        return size;
    }
}
