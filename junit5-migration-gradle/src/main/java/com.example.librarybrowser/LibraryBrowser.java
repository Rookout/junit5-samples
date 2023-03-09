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
        var request = HttpRequest.newBuilder(URI.create(url))
                .header("accept", "application/json")
                .build();
        System.out.println("Request: " + request);
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Response: " + response);
        Book book = new Book(response.body());
        System.out.println("Book: " + book);
        return book;
    }

    String extraHeaders = "";
    String host = "https://openlibrary.org/";
    String booksPrefix = "works/";
    String jsonSuffix = ".json";
}