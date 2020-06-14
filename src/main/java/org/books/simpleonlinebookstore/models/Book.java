package org.books.simpleonlinebookstore.models;

import lombok.*;
import org.books.simpleonlinebookstore.models.base.BaseEntity;
import org.books.simpleonlinebookstore.services.commercial.Priceable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table(name = "books")
@Builder
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class Book extends BaseEntity implements Priceable {

    @NonNull
    @NotEmpty
    private String title;

    @NonNull
    @NotEmpty
    private String authors;

    @NonNull
    @NotEmpty
    private String publisher;

    @Column(scale = 2)
    @NotEmpty
    private Double price;

    @NonNull
    @NotEmpty
    private String isbn;

    @NonNull
    private String genre;

    private Date publishedDate = new Date();

    @Override
    public Double calculatePrice() {
        return this.price;
    }
}
