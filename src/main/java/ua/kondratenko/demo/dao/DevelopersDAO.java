package ua.kondratenko.demo.dao;

import ua.kondratenko.demo.model.Developer;

import java.util.Set;

public interface DevelopersDAO {

    Set<Developer> findAll();

    Developer findById(Long id);

    Developer save(Developer developer);

    void deleteById(Long id);

}