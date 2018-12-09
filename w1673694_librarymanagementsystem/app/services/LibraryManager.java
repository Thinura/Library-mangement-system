package services;

import dto.LibraryItem;

import java.util.List;

/**
 *
 */

public interface LibraryManager {

    /**
     *
     */
    List<LibraryItem> generateReport();

    /**
     *
     */
    String addItem(int ISBN, String title, String sector, String publicationDate, String type,
                 String authors, String publisher, int pages);

    /**
     *
     */
    String addItem(int ISBN, String title, String sector, String publicationDate, String type,
                 String producer, String actors, String avaLang, String avaSub);

    /**
     *
     */
    String addReader(int redId, String redName, long redMobileNum, String redEmail);

    /**
     *
     */
    List<LibraryItem> displayItem();

    /**
     *
     */
    String borrowItem(int isbn, String reader, String dateBorrowed);

    /**
     *
     */
    String returnItem(int isbn, String reader, String dateReturned);

    /**
     *
     */
    LibraryItem searchTitle(String title);

}
