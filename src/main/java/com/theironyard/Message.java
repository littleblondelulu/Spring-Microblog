package com.theironyard;

/**
 * Created by lindseyringwald on 9/20/16.
 */
public class Message {
    String text;

    public Message(String text) {
        this.text = text;
    }

    int id;

    public Message(String text, int id) {
        this.text = text;
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
