package models;

import io.ebean.Model;

import javax.persistence.*;
import java.util.List;

/**
 *
 */
@Entity
@Table(name = "w1673694_Books")
public class BookModel extends Model {

    @Id
    @GeneratedValue
    @Column(name = "bookId",nullable = false)
    private int bookId;

    @Column(name = "ISBN", nullable = false)
    private int ISBN;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "sector", nullable = false)
    private String sector;

    @Column(name = "publicationDate", nullable = false)
    private String publicationDate;

    @Column(name = "borrowedDate")
    private String borrowedDate;

    @ManyToOne
    @JoinColumn(name = "reader", referencedColumnName = "redId")
    private ReaderModel borrowedReader;

    @Column(name = "objectType", nullable = false)
    private String type;

    @ManyToMany(mappedBy = "w1673694_Books")
    private List<AuthorModel> authors;

    @ManyToOne(optional = false)
    @JoinColumn(name = "publisher", referencedColumnName = "pubId")
    private PublisherModel publisherModel;

    @Column(name = "pages", nullable = false)
    private int pages;

    public BookModel() {
    }

    /**
     *
     * @param ISBN
     * @param title
     * @param sector
     * @param publicationDate
     * @param type
     * @param authors
     * @param publisherModel
     * @param pages
     */
    public BookModel(int ISBN, String title, String sector, String publicationDate, String type,
                     List<AuthorModel> authors, PublisherModel publisherModel, int pages) {
        this.ISBN = ISBN;
        this.title = title;
        this.sector = sector;
        this.publicationDate = publicationDate;
        this.type = type;
        this.authors = authors;
        this.publisherModel = publisherModel;
        this.pages = pages;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(String borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public ReaderModel getBorrowedReader() {
        return borrowedReader;
    }

    public void setBorrowedReader(ReaderModel borrowedReader) {
        this.borrowedReader = borrowedReader;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<AuthorModel> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorModel> authors) {
        this.authors = authors;
    }

    public PublisherModel getPublisherModel() {
        return publisherModel;
    }

    public void setPublisherModel(PublisherModel publisherModel) {
        this.publisherModel = publisherModel;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

}
