package com.ptrkcsak;

import java.sql.*;
import java.util.ArrayList;

public class Konyv {
    private int id;
    private String title;
    private String author;
    private int publish_year;
    private int page_count;

    public Konyv(int id, String title, String author, int publish_year, int page_count){
        this.id = id;
        this.title = title;
        this.author = author;
        this.publish_year = publish_year;
        this.page_count = page_count;
    }

    @Override
    public String toString() {
        return  "Id: " + id + "\n" +
                "Cím: " + title + "\n" +
                "Szerző : " + author + "\n" +
                "Kiadás éve: " + publish_year + "\n" +
                "Oldalszám: " + page_count + "\n";
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublish_year() {
        return publish_year;
    }

    public int getPage_count() {
        return page_count;
    }


}
