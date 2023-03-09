package com.example.librarybrowser;

import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Date;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

public class LibraryBrowserTest {

    @Test
    public void getBookTest() throws Exception {

        String deathlyHallowsIsbn = "OL82586W";
        var lib = new LibraryBrowser();
        var book = lib.getBookByIsbn(deathlyHallowsIsbn);

        assertEquals("Title", "Harry Potter and the Deathly Hallows", book.getTitle());
        assertEquals("Year created", book.getYearCreated(), 2007);
    }

}
