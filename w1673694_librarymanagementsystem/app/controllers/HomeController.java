package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import dto.LibraryItem;
import io.ebean.Ebean;
import io.ebean.SqlUpdate;
import models.BookModel;
import models.DVDModel;
import play.libs.Json;
import play.mvc.*;
import services.LibraryManager;
import services.WestminsterLibraryManager;

import java.util.List;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    private LibraryManager libraryManager = new WestminsterLibraryManager();

    public Result index() {
        return ok(views.html.index.render());
    }

    public Result displayItem() {

        List<LibraryItem> objects = libraryManager.displayItem();

        return ok(Json.toJson(objects));

    }

    public Result deleteItem(String isbn) {
        int isbnInt = Integer.parseInt(isbn);

        BookModel bookModel = Ebean.find(BookModel.class).where().eq("isbn", isbnInt).findOne();
        DVDModel dvdModel = Ebean.find(DVDModel.class).where().eq("isbn", isbnInt).findOne();

        if (bookModel != null) {
            String deleteItem = "DELETE FROM `w1673694_author_w1673694_books` WHERE `w1673694_author_w1673694_books`.`w1673694_author_auth_id` = :bookId AND `w1673694_author_w1673694_books`.`w1673694_books_book_id` = :bookId";
            String deleteItemBook = "DELETE FROM `w1673694_books` WHERE `w1673694_books`.`bookid` = :bookId";

            SqlUpdate sqlUpdate = Ebean.createSqlUpdate(deleteItem);
            SqlUpdate sqlUpdateBook = Ebean.createSqlUpdate(deleteItemBook);

            sqlUpdate.setParameter("bookId", bookModel.getBookId());
            sqlUpdateBook.setParameter("bookId", bookModel.getBookId());

            Ebean.execute(sqlUpdate);
            Ebean.execute(sqlUpdateBook);
            return ok("Book item deleted.");
        }

        if (dvdModel != null) {
            String deleteItem = "DELETE FROM `w1673694_actor_w1673694_dvd` WHERE `w1673694_actor_w1673694_dvd`.`w1673694_actor_act_id` = :dvdId AND `w1673694_actor_w1673694_dvd`.`w1673694_dvd_dvd_id` = :dvdId";
            String deleteItemDvd = "DELETE FROM `w1673694_dvd` WHERE `w1673694_dvd`.`dvdid` = :dvdId";

            SqlUpdate sqlUpdate = Ebean.createSqlUpdate(deleteItem);
            SqlUpdate sqlUpdateDvd = Ebean.createSqlUpdate(deleteItemDvd);

            sqlUpdate.setParameter("dvdId", dvdModel.getDvdId());
            sqlUpdateDvd.setParameter("dvdId", dvdModel.getDvdId());

            Ebean.execute(sqlUpdate);
            Ebean.execute(sqlUpdateDvd);
            return ok("DVD item deleted.");
        }

        return ok("ISBN number is wrong");
    }

    public Result borrowItem() {

        JsonNode jsonNode = request().body().asJson();

        int isbn = jsonNode.get("isbn").asInt();
        String reader = jsonNode.get("reader").asText();
        String dateBorrowed = jsonNode.get("dateBorrowed").asText();

        String response = libraryManager.borrowItem(isbn, reader, dateBorrowed);

        return ok(response);
    }

    public Result returnItem() {

        JsonNode jsonNode = request().body().asJson();

        int isbn = jsonNode.get("isbn").asInt();
        String reader = jsonNode.get("reader").asText();
        String dateReturned = jsonNode.get("dateReturned").asText();

        String response = libraryManager.returnItem(isbn, reader, dateReturned);

        return ok(response);
    }

    public Result generateReport() {

        List<LibraryItem> objects = libraryManager.generateReport();
        return ok(Json.toJson(objects));

    }

    public Result getTotalItem() {
        List<LibraryItem> objects = libraryManager.displayItem();
        int totalItem = objects.size();
        return ok(Json.toJson(totalItem));
    }

    public Result searchTitle(String title){
        LibraryItem libraryItem = libraryManager.searchTitle(title);
        return ok(Json.toJson(libraryItem));
    }
}
