package com.example.assignment1;
import java.time.LocalDate;

public class Note {

    String body, author, subject;
    LocalDate dateCreated;

    public Note(String b, String a, String s, LocalDate d) {
        this.setBody(b);
        this.setAuthor(a);
        this.setSubject(s);
        this.setDateCreated(d);
    }

    public Note(String b) {
        this.setBody(b);
        this.setAuthor("Sue Donym");
        this.setSubject("Subject1");
        this.setDateCreated(LocalDate.now());
    }

    public Note() {
        this.setBody("My Note");
        this.setAuthor("Sue Donym");
        this.setSubject("Subject1");
        this.setDateCreated(LocalDate.now());
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }
}