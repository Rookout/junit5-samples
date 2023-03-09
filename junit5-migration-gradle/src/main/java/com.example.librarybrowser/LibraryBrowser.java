package com.example.librarybrowser;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.example.librarybrowser.Book;

public class LibraryBrowser {

    public LibraryBrowser () {

    }

    public Book getBookByIsbn(String isbn) throws Exception {
        String url = host + booksPrefix + isbn + jsonSuffix;
        var client = HttpClient.newHttpClient();
        var uri = URI.create(url);
        var differentUri = new URI(url);
        var request = HttpRequest.newBuilder(uri)
                .header("accept", "application/json")
                .build();
        var differentRequest = HttpRequest.newBuilder(uri)
                .header("accept", "application/json")
                .build();

        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        Book book = new Book(response.body());
        return book;
    }

    String extraHeaders = "";
    String host = "https://openlibrary.org/";
    String booksPrefix = "books/";
    String jsonSuffix = ".json";
}