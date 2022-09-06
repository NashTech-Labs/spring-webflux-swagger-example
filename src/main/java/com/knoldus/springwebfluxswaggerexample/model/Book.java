package com.knoldus.springwebfluxswaggerexample.model;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private String id;

    @NotNull
    @NotBlank
    private String name;


    // TODO add validation rules according to standard definition
    @NotNull
    private String isbn;
}
