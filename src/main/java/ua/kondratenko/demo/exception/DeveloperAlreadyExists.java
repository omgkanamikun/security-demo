package ua.kondratenko.demo.exception;

public class DeveloperAlreadyExists extends RuntimeException {

    public DeveloperAlreadyExists(String message) {
        super(message);
    }

}