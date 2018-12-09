package dto;

import java.util.List;

public class Book extends LibraryItem {

    private int bookId;
    private List<Author> authors;
    private Publisher publisher;
    private int pages;

    public Book(int ISBN, String title, String sector, String publicationDate, String borrowedDate,
                Reader borrowedReader, String type, int bookId, List<Author> authors, Publisher publisher, int pages) {
        super(ISBN, title, sector, publicationDate, borrowedDate, borrowedReader, type);
        this.bookId = bookId;
        this.authors = authors;
        this.publisher = publisher;
        this.pages = pages;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

}
