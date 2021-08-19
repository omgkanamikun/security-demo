package ua.kondratenko.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.kondratenko.demo.dao.DevelopersDAO;

@Service
@RequiredArgsConstructor
public class DeveloperService {

    private final DevelopersDAO developersDAO;


}