package ua.kondratenko.demo.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ua.kondratenko.demo.exception.DeveloperAlreadyExists;
import ua.kondratenko.demo.exception.DeveloperNotFoundException;
import ua.kondratenko.demo.domain.model.Developer;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

import static java.lang.String.format;

@Slf4j
@Component
public class InMemoryDevelopersDAOImpl implements DevelopersDAO {

    public static final String NOT_FOUND = "Developer with id: %s not found";

    private final Set<Developer> DEVELOPERS_DAO = new HashSet<>() {{
        add(new Developer(1L, "Alina", "Kondratenko"));
        add(new Developer(2L, "Vlad", "Kondratenko"));
        add(new Developer(3L, "Valeriy", "Omelchenko"));
    }};

    @Override
    public Set<Developer> findAll() {
        return DEVELOPERS_DAO;
    }

    @Override
    public Developer findById(Long id) {
        return DEVELOPERS_DAO.stream()
                .filter(equalById(id))
                .findFirst()
                .orElseThrow(() -> new DeveloperNotFoundException(format(NOT_FOUND, id)));
    }

    @Override
    public Developer save(Developer developer) {

        if (!DEVELOPERS_DAO.add(developer)) {

            log.error("{} already exists", developer);

            throw new DeveloperAlreadyExists(format("%s already exists", developer));
        }

        return developer;
    }

    @Override
    public void deleteById(Long id) {
        if (!DEVELOPERS_DAO.removeIf(developer -> developer.id().equals(id))) {
            throw new DeveloperNotFoundException(format(NOT_FOUND, id));
        }
    }

    private Predicate<? super Developer> equalById(Long id) {
        return developer -> developer.id().equals(id);
    }

}