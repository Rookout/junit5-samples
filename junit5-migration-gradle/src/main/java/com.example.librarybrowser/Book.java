package com.example.librarybrowser;

import org.json.*;

import java.util.Calendar;
import java.util.Date;


public class Book {

    public Book (String rawJson) {
        this.rawJson = rawJson;
        this.json = new JSONObject(rawJson);

        try {
            this.title = json.getString("title");
            this.createdString = json.getString("created");
            this.created = new Date(createdString);
            this.calendar = Calendar.getInstance();
            calendar.setTime(created);
            this.yearCreated = calendar.get(Calendar.YEAR);

        } catch (Throwable t) {
            // we're keeping the data we have and skipping the rest
        }
    }

    String rawJson = "";
    JSONObject json = null;
    String title = "no title";
    String createdString = "no created string";
    Date created = new Date();
    Calendar calendar = Calendar.getInstance();
    int yearCreated = calendar.get(Calendar.YEAR);
}