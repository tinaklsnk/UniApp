package com.example.uniapp;

public class PDFmodel {
    String title;
    String url;

    public PDFmodel(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public PDFmodel() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
