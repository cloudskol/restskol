package com.cloudskol.restskol.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author tham (zarub2k@gmail.com)
 */
@XmlRootElement
public class Book {
    @XmlElement
    private String id;

    @XmlElement
    private String title;

    @XmlElement
    private String isbn;

    @XmlElement
    private String author;

    public Book() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
