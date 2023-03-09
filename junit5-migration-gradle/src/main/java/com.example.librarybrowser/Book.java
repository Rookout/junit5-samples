package com.example.librarybrowser;

import org.json.*;

import java.util.Calendar;
import java.util.Date;

public class Book {

    public Book (String rawJson) {
        try {
            // Parse JSON
            this.rawJson = rawJson;
            this.json = new JSONObject(rawJson);

            // Parse title
            this.title = json.get("title").toString();

            // Prase date
            this.createdString = json.get("created").toString();
            this.created = new Date(createdString);
            this.yearCreated = created.getYear();

        } catch (Throwable t) {
            // Some items in the library our corrupted, keep what we have
        }
    }

    public String getTitle() {
        return this.title;
    }

    public int getYearCreated() {
        return this.yearCreated;
    }

    String rawJson = "";
    JSONObject json = null;
    String title = "no title";
    String createdString = "no created string";
    Date created = new Date();
    int yearCreated = created.getYear();
}