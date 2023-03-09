package com.example.librarybrowser;

import org.json.*;

import java.util.Calendar;
import java.util.Date;

public class Book {

    public Book (String rawJson) {
        try {
            this.rawJson = rawJson;
            System.out.println("Raw JSON from openLib: " + rawJson);
            this.json = new JSONObject(rawJson);
            this.title = json.getString("title");
            this.createdString = json.getString("created");
            this.created = new Date(createdString);
            this.calendar = Calendar.getInstance();
            calendar.setTime(created);
            this.yearCreated = calendar.get(Calendar.YEAR);

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
    Calendar calendar = Calendar.getInstance();
    int yearCreated = calendar.get(Calendar.YEAR);
}