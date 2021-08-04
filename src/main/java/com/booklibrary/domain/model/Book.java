package com.booklibrary.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Getter
@Setter
@Accessors(chain = true)
@Entity
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

    @Override
    public String toString() {
        StringBuffer s = new StringBuffer("book: ");
        s.append("bookId:" + bookId);
        s.append("author:" + author + ",");
        s.append("description:" + description + ",");
        s.append("rating:" + rating + ",");
        s.append("publisher:" + publisher + ",");
        s.append("pageCount:" + pageCount + ",");
        s.append("isbn:" + isbn);
        return s.toString();
    }

}
