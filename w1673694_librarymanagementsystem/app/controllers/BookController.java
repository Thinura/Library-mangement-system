package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import dto.Book;
import play.mvc.Controller;
import play.mvc.Result;
import services.LibraryManager;
import services.WestminsterLibraryManager;

import java.util.Arrays;

public class BookController extends Controller {

    private LibraryManager libraryManager = new WestminsterLibraryManager();

    public Result addBook() {

        JsonNode body = request().body().asJson();

        int ISBN = body.get("ISBN").asInt();
        String title = body.get("title").asText();
        String sector = body.get("sector").asText();
        String publicationDate = body.get("publicationDate").asText();
        String authName = body.get("authName").asText();
        String pubComName = body.get("pubComName").asText();
        int pages = body.get("pages").asInt();

        String response = libraryManager.addItem(ISBN, title, sector, publicationDate, "Book", authName, pubComName, pages);

        return ok(response);
    }
}
