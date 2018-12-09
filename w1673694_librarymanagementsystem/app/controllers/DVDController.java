package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import play.mvc.Controller;
import play.mvc.Result;
import services.LibraryManager;
import services.WestminsterLibraryManager;

public class DVDController extends Controller {

    private LibraryManager libraryManager = new WestminsterLibraryManager();

    public Result addDVD() {

        JsonNode body = request().body().asJson();

        int ISBN = body.get("ISBN").asInt();
        String title = body.get("title").asText();
        String sector = body.get("sector").asText();
        String publicationDate = body.get("publicationDate").asText();
        String producer = body.get("producer").asText();
        String actors = body.get("actors").asText();
        String avaLang = body.get("avaLang").asText();
        String avaSub = body.get("avaSub").asText();

        String response = libraryManager.addItem(ISBN, title, sector, publicationDate, "DVD", producer, actors, avaLang, avaSub);

        return ok(response);
    }
}
