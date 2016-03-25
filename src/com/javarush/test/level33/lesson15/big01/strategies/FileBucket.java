package com.javarush.test.level33.lesson15.big01.strategies;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by CMI-USER on 1/20/2016.
 */
public class FileBucket
{

    private Path path;

    public FileBucket()
    {
        try
        {
            path = Files.createTempFile(null, null);
        }
        catch (IOException e) {}
        path.toFile().deleteOnExit();
    }

    public long getFileSize()
    {
       return path.toFile().length();
    }

    public void putEntry(Entry entry)
    {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(Files.newOutputStream(path)))
        {
            Entry e = entry;
            while (e != null)
            {
                objectOutputStream.writeObject(e);
                e = e.next;
            }
        }
        catch (IOException e) {}
    }

    public Entry getEntry()
    {
        if (getFileSize() == 0)
            return null;

        try (ObjectInputStream s = new ObjectInputStream(Files.newInputStream(path)))
        {
            Entry result = (Entry) s.readObject();
            /*Entry last = result;
            Entry temp;
            while ((temp = (Entry)s.readObject()) != null)
            {
                last.next = temp;
                last = temp;
            }*/
            return result;
        }
        catch (IOException | ClassNotFoundException e)
        {
            return null;
        }

    }

    public void remove()
    {
        try
        {
            Files.delete(path);
        }
        catch (IOException e) {}
    }
}
