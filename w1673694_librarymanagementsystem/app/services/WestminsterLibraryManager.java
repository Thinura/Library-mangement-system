package services;

import dto.*;
import io.ebean.Ebean;
import io.ebean.SqlUpdate;
import models.*;
import org.joda.time.*;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class WestminsterLibraryManager implements LibraryManager {

    /**
     * This method will accept isbn, title, sector, publicationDate, type(type of the object), author, publisher and pages
     * as parameters to create a Book object.
     */
    @Override
    public String addItem(int ISBN, String title, String sector, String publicationDate,
                          String type, String authors, String publisher, int pages) {

        BookModel bookModel = Ebean.find(BookModel.class).where().eq("isbn", ISBN).findOne();

        if (bookModel == null) {

            AuthorModel authorModel = new AuthorModel(authors);
            Ebean.save(authorModel);

            PublisherModel publisherModel = new PublisherModel(publisher);
            Ebean.save(publisherModel);

            bookModel = new BookModel(ISBN, title, sector, publicationDate, type,
                    Arrays.asList(authorModel), publisherModel, pages);

            Ebean.save(bookModel);

            return "Successfully added to the library.";

        }
        return "Book already exist";
    }

    /**
     * This method will accept isbn, title, sector, publicationDate, type(type of the object), producer, actors,
     * avaLang and avaSub as parameters to create a DVD object.
     */
    @Override
    public String addItem(int ISBN, String title, String sector, String publicationDate, String type,
                          String producer, String actors, String avaLang, String avaSub) {

        DVDModel dvdModel = Ebean.find(DVDModel.class).where().eq("isbn", ISBN).findOne();

        if (dvdModel == null) {

            ProducerModel producerModel = new ProducerModel(producer);
            Ebean.save(producerModel);

            ActorModel actorModel = new ActorModel(actors);
            Ebean.save(actorModel);

            dvdModel = new DVDModel(ISBN, title, sector, publicationDate, type, producerModel,
                    Arrays.asList(actorModel), avaLang, avaSub);

            Ebean.save(dvdModel);
            return "Successfully added to the library.";

        }
        return "DVD already exist";

    }

    /**
     * This method will accept readerId, name, mobileNum and email as parameters to create a Reader object.
     */
    @Override
    public String addReader(int redId, String redName, long redMobileNum, String redEmail) {
        ReaderModel readerModel = Ebean.find(ReaderModel.class).where().eq("redName", redName).findOne();
        if (readerModel == null) {
            readerModel = new ReaderModel(redId, redName, redMobileNum, redEmail);
            Ebean.save(readerModel);
            return "Successfully added to the library.";
        }
        return "Reader already exist";
    }

    /**
     * This method will return all the items in the library.
     */
    @Override
    public List<LibraryItem> displayItem() {

        List<BookModel> bookModels = Ebean.find(BookModel.class).findList();
        List<DVDModel> dvdModels = Ebean.find(DVDModel.class).findList();

        List<LibraryItem> item = new ArrayList<>();

        for (BookModel bookModel : bookModels) {
            Book book = getBookDTObyModel(bookModel);
            item.add(book);
        }

        for (DVDModel dvdModel : dvdModels) {
            DVD dvd = getDVDDTObyModel(dvdModel);
            item.add(dvd);
        }

        LibraryItemSorter libraryItemSorter = new LibraryItemSorter(item);

        return libraryItemSorter.getLibraryItems();
    }

    /**
     * This method will take isbn, reader, date borrowed as parameters and update item details as borrowed.
     */
    @Override
    public String borrowItem(int isbn, String reader, String dateBorrowed) {

        BookModel bookModel = Ebean.find(BookModel.class).where().eq("isbn", isbn).findOne();
        DVDModel dvdModel = Ebean.find(DVDModel.class).where().eq("isbn", isbn).findOne();
        ReaderModel readerModel = Ebean.find(ReaderModel.class).where().eq("redname", reader).findOne();

        if (readerModel != null) {
            if (bookModel != null) {
                if (bookModel.getBorrowedReader() == null) {
                    String borrowItemBook = "UPDATE `w1673694_books` SET `borroweddate` = :borrowDate, `reader` = :readerId WHERE `w1673694_books`.`bookid` = :bookId ";
                    SqlUpdate sqlUpdateBook = Ebean.createSqlUpdate(borrowItemBook);

                    sqlUpdateBook.setParameter("borrowDate", dateBorrowed);
                    sqlUpdateBook.setParameter("readerId", readerModel.getRedId());
                    sqlUpdateBook.setParameter("bookId", bookModel.getBookId());

                    Ebean.execute(sqlUpdateBook);
                    return "Successfully borrowed the Book.";
                } else {
                    return "Book has been borrowed";
                }
            } else if (dvdModel != null) {
                if (dvdModel.getBorrowedReader() == null) {
                    String borrowItemDVD = "UPDATE `w1673694_dvd` SET `borroweddate` = :borrowDate, `reader` = :readerId WHERE `w1673694_dvd`.`dvdid` = :dvdId ";
                    SqlUpdate sqlUpdateDVD = Ebean.createSqlUpdate(borrowItemDVD);

                    sqlUpdateDVD.setParameter("borrowDate", dateBorrowed);
                    sqlUpdateDVD.setParameter("readerId", readerModel.getRedId());
                    sqlUpdateDVD.setParameter("dvdId", dvdModel.getDvdId());

                    Ebean.execute(sqlUpdateDVD);
                    return "Successfully borrowed the DVD.";
                } else {
                    return "DVD has been borrowed";
                }
            } else {
                return "ISBN number is wrong.";
            }
        }
        return "Reader isn't available.";
    }

    /**
     * This method will except isbn, reader, date returned and update item details as returned.
     */
    @Override
    public String returnItem(int isbn, String reader, String dateReturned) {
        BookModel bookModel = Ebean.find(BookModel.class).where().eq("isbn", isbn).findOne();
        DVDModel dvdModel = Ebean.find(DVDModel.class).where().eq("isbn", isbn).findOne();
        ReaderModel readerModel = Ebean.find(ReaderModel.class).where().eq("redname", reader).findOne();

        if (readerModel != null) {
            if (bookModel != null) {
                if (bookModel.getBorrowedReader() != null) {
                    String borrowItemBook = "UPDATE `w1673694_books` SET `borroweddate` = null, `reader` = null WHERE `w1673694_books`.`bookid` = :bookId ";
                    SqlUpdate sqlUpdateBook = Ebean.createSqlUpdate(borrowItemBook);

                    sqlUpdateBook.setParameter("bookId", bookModel.getBookId());

                    Ebean.execute(sqlUpdateBook);
                    return "Successfully returned the Book.";
                } else {
                    return "Book has not been borrowed.";
                }
            } else if (dvdModel != null) {
                if (dvdModel.getBorrowedReader() != null) {
                    String borrowItemDVD = "UPDATE `w1673694_dvd` SET `borroweddate` = null, `reader` = null WHERE `w1673694_dvd`.`dvdid` = :dvdId ";
                    SqlUpdate sqlUpdateDVD = Ebean.createSqlUpdate(borrowItemDVD);

                    sqlUpdateDVD.setParameter("dvdId", dvdModel.getDvdId());

                    Ebean.execute(sqlUpdateDVD);
                    return "Successfully returned the DVD.";
                } else {
                    return "DVD has not been borrowed.";
                }
            } else {
                return "ISBN number is wrong.";
            }
        }
        return "Reader isn't available.";
    }

    /**
     * This method will generate a report regarding who are the readers' that has overdue fees.
     */
    @Override
    public List<LibraryItem> generateReport() {

        List<BookModel> bookModels = Ebean.find(BookModel.class).findList();
        List<DVDModel> dvdModels = Ebean.find(DVDModel.class).findList();

        List<LibraryItem> objectList = new ArrayList<>();

        Date currentDate = new Date();
        SimpleDateFormat currentDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        String[] bwDateTime;
        String borrowDateTime;

        for (BookModel bookModel : bookModels) {

            Book book = getBookDTObyModel(bookModel);

            if (book.getBorrowedDate() == null) {
                break;
            }

            bwDateTime = book.getBorrowedDate().split("T");
            borrowDateTime = bwDateTime[0] + " " + bwDateTime[1];
            Overdue overdueBook = getOverdueByItem(null, book, currentDateFormat, borrowDateTime, currentDate);
            if (overdueBook != null)
                objectList.add(overdueBook);
        }

        for (DVDModel dvdModel : dvdModels) {

            DVD dvd = getDVDDTObyModel(dvdModel);

            if (dvd.getBorrowedDate() == null) {
                break;
            }

            bwDateTime = dvd.getBorrowedDate().split("T");
            borrowDateTime = bwDateTime[0] + " " + bwDateTime[1];
            Overdue overdueDVD = getOverdueByItem(dvd, null, currentDateFormat, borrowDateTime, currentDate);
            if (overdueDVD != null)
                objectList.add(overdueDVD);
        }

        LibraryItemSorter libraryItemSorter = new LibraryItemSorter(objectList);

        return libraryItemSorter.getLibraryItems();
    }

    /**
     *
     */
    @Override
    public LibraryItem searchTitle(String title) {
        BookModel bookModel = Ebean.find(BookModel.class).where().eq("title", title).findOne();
        DVDModel dvdModel = Ebean.find(DVDModel.class).where().eq("title", title).findOne();
        LibraryItem libraryItem = new LibraryItem() {};
        if (bookModel != null) {
            libraryItem = getBookDTObyModel(bookModel);
        } else if (dvdModel != null) {
            libraryItem = getDVDDTObyModel(dvdModel);
        }
        return libraryItem;
    }


    /**
     *
     */
    private Book getBookDTObyModel(BookModel bookModel) {
        Book book = new Book(bookModel.getISBN(), bookModel.getTitle(), bookModel.getSector(),
                bookModel.getPublicationDate(), null, null, bookModel.getType(),
                bookModel.getBookId(), getAuthorListDTObyModel(bookModel.getAuthors()), getPublisherDTObyModel(bookModel.getPublisherModel()), bookModel.getPages());

        if (bookModel.getBorrowedReader() != null) {
            Reader reader = getReaderDTObyModel(bookModel.getBorrowedReader());
            book.setBorrowedReader(reader);
            book.setBorrowedDate(bookModel.getBorrowedDate());
        }
        return book;
    }

    /**
     *
     */
    private Reader getReaderDTObyModel(ReaderModel readerModel) {
        return new Reader(readerModel.getRedId(), readerModel.getRedName(),
                readerModel.getRedMobileNum(), readerModel.getRedEmail());
    }
    /**
     *
     */
    private DVD getDVDDTObyModel(DVDModel dvdModel) {

        DVD dvd = new DVD(dvdModel.getISBN(), dvdModel.getTitle(), dvdModel.getSector(), dvdModel.getPublicationDate(),
                null, null, dvdModel.getType(), dvdModel.getDvdId(),
                getProducerDTObyModel(dvdModel.getProducerModel()), getActorListDTObyModel(dvdModel.getActorModels()),
                dvdModel.getAvaLang(), dvdModel.getAvaSub());
        if (dvdModel.getBorrowedReader() != null) {
            Reader reader = getReaderDTObyModel(dvdModel.getBorrowedReader());
            dvd.setBorrowedReader(reader);
            dvd.setBorrowedDate(dvdModel.getBorrowedDate());
        }
        return dvd;
    }

    /**
     *
     */
    private Actor getActorDTObyModel(ActorModel actorModel) {
        return new Actor(actorModel.getActId(), actorModel.getActName());
    }

    /**
     *
     */
    private Publisher getPublisherDTObyModel(PublisherModel publisherModel) {
        return new Publisher(publisherModel.getPubId(), publisherModel.getPubComName());
    }

    /**
     *
     */
    private Author getAuthorDTObyModel(AuthorModel authorModel) {
        return new Author(authorModel.getAuthId(), authorModel.getAuthName());
    }

    /**
     *
     */
    private Producer getProducerDTObyModel(ProducerModel producerModel) {
        return new Producer(producerModel.getProId(), producerModel.getProName());
    }

    /**
     *
     */
    private List<Actor> getActorListDTObyModel(List<ActorModel> actorModels) {

        List<Actor> actor = new ArrayList<>();
        for (ActorModel actorModel : actorModels) {
            actor.add(getActorDTObyModel(actorModel));
        }
        return actor;
    }

    /**
     *
     */
    private List<Author> getAuthorListDTObyModel(List<AuthorModel> authorModel) {

        List<Author> author = new ArrayList<>();
        for (AuthorModel authModel : authorModel) {
            author.add(getAuthorDTObyModel(authModel));
        }

        return author;
    }

    /**
     *
     */
    private Overdue getOverdueByItem(DVD dvd, Book book, SimpleDateFormat currentDateFormat,
                                     String borrowDateTime, Date currentDate) {
        try {
            Date d1 = currentDateFormat.parse(borrowDateTime);
            Date d2 = currentDateFormat.parse(currentDateFormat.format(currentDate));

            DateTime dt1 = new DateTime(d1);
            DateTime dt2 = new DateTime(d2);
            if (Hours.hoursBetween(dt1, dt2).getHours() > 144) {
                double balance = ((Hours.hoursBetween(dt1, dt2).getHours() - 144) * 0.5) + (0.2 * 72);
                balance = Math.round(balance * 100.0) / 100.0;
                return addOverdueItem(dvd, book, balance, currentDateFormat, currentDate);
            } else if (Hours.hoursBetween(dt1, dt2).getHours() > 72) {
                double balance = ((Hours.hoursBetween(dt1, dt2).getHours() - 72) * 0.2);
                balance = Math.round(balance * 100.0) / 100.0;
                return addOverdueItem(dvd, book, balance, currentDateFormat, currentDate);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     */
    private Overdue addOverdueItem(DVD dvd, Book book, double balance, SimpleDateFormat currentDateFormat,
                                   Date currentDate) {

        if (dvd != null) {
            return new Overdue(dvd.getISBN(), dvd.getTitle(), dvd.getSector(), dvd.getPublicationDate(),
                    dvd.getBorrowedDate(), dvd.getBorrowedReader(), dvd.getType(), balance, currentDateFormat.format(currentDate));
        }
        return new Overdue(book.getISBN(), book.getTitle(), book.getSector(), book.getPublicationDate(),
                book.getBorrowedDate(), book.getBorrowedReader(), book.getType(), balance, currentDateFormat.format(currentDate));
    }

}