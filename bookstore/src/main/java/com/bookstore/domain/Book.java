package com.bookstore.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {
    private static final long serialVersionUID = 425345L;

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long id;

    private String title;
    private String author;
    private String publisher;
    private String publicationDate;
    private String language;
    private String category;
    private int numberOfPages;
    private String format;
    private String isbn;
    private double shippingWeight;
    private double listPrice;
    private double ourPrice;
    private boolean active = true;

    @Column( columnDefinition = "text" )
    private String description;
    private int inStockNumber;

    @Transient
    private MultipartFile bookImage;


}
