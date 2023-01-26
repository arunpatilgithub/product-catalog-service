package com.ap.productcatalogservice.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

/**
 * Model representation for a Book.
 */
public record Book(
        @NotBlank(message = "The book ISBN cannot be blank.")
        @Pattern(regexp = "^([0-9]{10}|[0-9]{13})$", message = "The ISBN format must be valid.")
        String isbn,

        @NotBlank(message = "The book title cannot be blank.")
        String title,

        @NotBlank(message = "The book author cannot be blank.")
        String author,

        @NotNull(message = "The book price cannot be blank.")
        @Positive(message = "The book price must be greater than zero.")
        Double price

) {
}
