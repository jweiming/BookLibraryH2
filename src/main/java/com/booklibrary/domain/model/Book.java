package com.booklibrary.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@ToString
public class Book extends BaseDomainObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    /*
    * purposely omitted price to keep things simple
    * Reason being that introduces some complexity handling
    * - with accuracy issues (like using BigDecimal vs Float/double)
    * - and different currency types.
    */

    @Column
    private String author;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private Float rating;

    @Column
    private String publisher;

    @Column
    private Long pageCount;

    @Column(unique = true)
    private String isbn;

}
