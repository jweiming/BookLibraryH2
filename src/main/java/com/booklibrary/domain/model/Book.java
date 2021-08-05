package com.booklibrary.domain.model;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Accessors(chain = true)
public class Book extends BaseDomainObject {

    @Id
    private String bookId;

    private String isbn;

    private String author;

    private String title;

    private String description;

    private Float rating;

    private String publisher;

    private Long pageCount;

}
