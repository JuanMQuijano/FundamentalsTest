package com.spring_fundamentals.ExamenFundamentals.genres.infrastructure.dto.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public class GenreDTO implements Serializable {

    @NotBlank
    @Size(min = 3, max = 10, message = "Genre name should be a value between {min} and {max}")
    private String name;

    @NotBlank
    @Size(min = 5, message = "Genre description should be a value with at least {min} characters")
    private String description;

    public GenreDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
