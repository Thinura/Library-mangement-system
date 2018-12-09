package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import play.mvc.Controller;
import play.mvc.Result;
import services.LibraryManager;
import services.WestminsterLibraryManager;

public class ReaderController extends Controller {

    private LibraryManager libraryManager = new WestminsterLibraryManager();

    public Result addReader() {

        JsonNode body = request().body().asJson();

        int redId = body.get("redId").asInt();
        String redName = body.get("redName").asText();
        long redMobileNum = body.get("redMobileNum").asLong();
        String redEmail = body.get("redEmail").asText();


        String response = libraryManager.addReader(redId, redName, redMobileNum, redEmail);

        return ok(response);
    }
}
