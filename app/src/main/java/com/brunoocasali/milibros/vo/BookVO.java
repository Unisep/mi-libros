package com.brunoocasali.milibros.vo;

import java.io.Serializable;

/**
 * Created by Bruno Casali on 21/04/2015.
 */
public class BookVO implements Serializable {

    private String title;

    private Float rate;

    private String author;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
