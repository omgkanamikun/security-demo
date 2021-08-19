package ua.kondratenko.demo.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public record Developer(@NotNull(message = "id cant be null") Long id,
                        @NotEmpty(message = "firstName cant be null") String firstName,
                        @NotEmpty(message = "lastName cant be null") String lastName) {
}