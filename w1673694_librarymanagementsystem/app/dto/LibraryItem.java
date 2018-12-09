package dto;

import org.jetbrains.annotations.NotNull;
import services.LibraryManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class LibraryItem implements Comparable<LibraryItem> {

    private int ISBN;
    private String title;
    private String sector;
    private String publicationDate;
    private String borrowedDate;
    private Reader borrowedReader;
    private String type;

    public LibraryItem(int ISBN, String title, String sector, String publicationDate,
                       String borrowedDate, Reader borrowedReader, String type) {
        this.ISBN = ISBN;
        this.title = title;
        this.sector = sector;
        this.publicationDate = publicationDate;
        this.borrowedDate = borrowedDate;
        this.borrowedReader = borrowedReader;
        this.type = type;
    }

    public LibraryItem() {}

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public Reader getBorrowedReader() {
        return borrowedReader;
    }

    public void setBorrowedReader(Reader borrowedReader) {
        this.borrowedReader = borrowedReader;
    }

    private Date getDateByString(String dt) {
        if (dt != null) {
            String[] bwDateTime = dt.split("T");
            String borrowDateTime = bwDateTime[0] + " " + bwDateTime[1];
            SimpleDateFormat currentDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            try {
                return currentDateFormat.parse(borrowDateTime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return new Date();
    }

    /**
     *
     */
    @Override
    public int compareTo(@NotNull LibraryItem o) {
        return getDateByString(getBorrowedDate()).compareTo(getDateByString(o.getBorrowedDate()));
    }
}
