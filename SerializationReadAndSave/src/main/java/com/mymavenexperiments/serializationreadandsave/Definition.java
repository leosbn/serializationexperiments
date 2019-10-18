package com.mymavenexperiments.serializationreadandsave;

import java.io.Serializable;

public class Definition implements Comparable<Definition>, Serializable {

    private String title;
    private String text;

    public Definition(String title, String text) {
        this.title = title;
        this.text = text;
    }

    @Override
    public int compareTo(Definition o) {
        return this.title.compareTo(o.getTitle());
    }

    public String getTitle() {
        return this.title;
    }

    public String getText() {
        return this.text;
    }

    public String toString() {
        return this.title + "\n" + this.text;
    }
}
