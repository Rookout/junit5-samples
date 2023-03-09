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
        // Build book URL
        String url = host + booksPrefix + isbn + jsonSuffix;

        // Make an HTTP request
        var request = HttpRequest.newBuilder(URI.create(url))
                .header("accept", "application/json")
                .build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Return Book from response body
        return new Book(response.body());
    }

    HttpClient client = HttpClient.newHttpClient();

    final String extraHeaders = "";
    final String host = "https://openlibrary.org/";
    final String booksPrefix = "works/";
    final String jsonSuffix = ".json";
}