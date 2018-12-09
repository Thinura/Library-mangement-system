package dto;

import java.util.Collections;
import java.util.List;

public class LibraryItemSorter {
    private List<LibraryItem> libraryItems;

    public LibraryItemSorter(List<LibraryItem> libraryItems) {
        this.libraryItems = libraryItems;
    }

    public List<LibraryItem> getLibraryItems() {
        Collections.sort(libraryItems);
        return libraryItems;
    }
}
