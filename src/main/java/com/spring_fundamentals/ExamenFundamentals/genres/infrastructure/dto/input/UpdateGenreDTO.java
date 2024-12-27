package com.spring_fundamentals.ExamenFundamentals.genres.infrastructure.dto.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UpdateGenreDTO {

    @NotBlank
    @Size(min = 3, max = 10, message = "Genre name should be a value between {min} and {max}")
    @JsonProperty(value = "new_name")
    private String newName;

    @NotBlank
    @Size(min = 5, message = "Genre description should be a value with at least {min} characters")
    @JsonProperty(value = "new_description")
    private String newDescription;

    public UpdateGenreDTO() {
    }

    public UpdateGenreDTO(String newName, String newDescription) {
        this.newName = newName;
        this.newDescription = newDescription;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getNewDescription() {
        return newDescription;
    }

    public void setNewDescription(String newDescription) {
        this.newDescription = newDescription;
    }
}
