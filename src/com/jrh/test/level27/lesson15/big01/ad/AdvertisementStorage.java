package com.javarush.test.level27.lesson15.big01.ad;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CMI-USER on 1/14/2016.
 */
class AdvertisementStorage
{
    private static AdvertisementStorage ourInstance = new AdvertisementStorage();
    private final List<Advertisement> videos = new ArrayList<>();

    public static AdvertisementStorage getInstance()
    {
        return ourInstance;
    }

    private AdvertisementStorage()
    {
        Object someContent = new Object();
        add(new Advertisement(someContent, "First Video", 5000, 100, 3 * 60));
        add(new Advertisement(someContent, "second video", 100, 10, 15 * 60));
        add(new Advertisement(someContent, "Third Video", 400, 1, 10 * 60));
        add(new Advertisement(someContent, "четвертое видео", 400, 1, 20 * 60));
        add(new Advertisement(someContent, "fifth video", 400, 2, 40 * 60));
        add(new Advertisement(someContent, "шестое видео", 400, 2, 30 * 60));
        add(new Advertisement(someContent, "седьмое видео", 400, 1, 50 * 60));
        add(new Advertisement(someContent, "Eight video", 150, 2, 20 * 60));
        add(new Advertisement(someContent, "Ninth video", 7000, 1, 10 * 60));
    }

    public List<Advertisement> list()
    {
        return videos;
    }

    public void add(Advertisement advertisement)
    {
        videos.add(advertisement);
    }
}
