package com.booklibrary.api.v1.request.book;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateBookRequest {

    @NotNull(message = "{constraints.NotEmpty.message}")
    private String author;

    @NotNull(message = "{constraints.NotEmpty.message}")
    private String title;

    @NotNull(message = "{constraints.NotEmpty.message}")
    private String description;

    @NotNull(message = "{constraints.NotEmpty.message}")
    private String isbn;

    private Float rating;
    private String publisher;
    private Long pageCount;

}
