package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.List;

/**
 * Created by CMI-USER on 1/15/2016.
 */
public interface Strategy
{
    public List<Vacancy> getVacancies(String searchString);
}
