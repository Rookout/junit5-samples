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
        System.out.println("Uri: " + uri);
        var differentUri = new URI(url);
        System.out.println("Different uri " + differentUri);
        var request = HttpRequest.newBuilder(uri)
                .header("accept", "application/json")
                .build();
        System.out.println("req: " + request);
        var differentRequest = HttpRequest.newBuilder(uri)
                .header("accept", "application/json")
                .build();
        System.out.println("different req: " + differentRequest);

        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("response: " + response);

        var diffresponse = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("diffresponse: " + diffresponse);
        Book book = new Book(response.body());
        return book;
    }

    String extraHeaders = "";
    String host = "https://openlibrary.org/";
    String booksPrefix = "books/";
    String jsonSuffix = ".json";
}