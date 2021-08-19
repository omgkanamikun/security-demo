package ua.kondratenko.demo.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import ua.kondratenko.demo.dao.DevelopersDAO;
import ua.kondratenko.demo.model.Developer;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping(path = "/api/v1/developers")
@RequiredArgsConstructor
public class DeveloperRestControllerV1 {

    private final DevelopersDAO developersDAO;

    @GetMapping
    public Set<Developer> getAll() {
        var developers = developersDAO.findAll();
        log.info("found {} developers", developers.size());
        return developers;
    }

    @GetMapping(path = "/{id}")
    public Developer getById(@PathVariable(name = "id") Long id) {
        log.info("called getById method with id: {}", id);
        return developersDAO.findById(id);
    }

    @PostMapping
    public Developer save(@Valid @RequestBody Developer developer) {
        var inDB = developersDAO.save(developer);
        log.info("saved new developer: {}", developer);
        return inDB;
    }

    @DeleteMapping(path = "/{id}")
    public void deleteById(@PathVariable(name = "id") Long id) {
        developersDAO.deleteById(id);
        log.info("deleted developer with id: {}", id);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {

        final Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {

            final var fieldName = ((FieldError) error).getField();
            final var errorMessage = error.getDefaultMessage();

            errors.put(fieldName, errorMessage);
        });

        return errors;
    }

}