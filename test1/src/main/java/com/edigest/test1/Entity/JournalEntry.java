package com.edigest.test1.Entity;


import com.edigest.test1.enums.sentiment;
import com.mongodb.lang.NonNull;
//import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Document(collection ="journal_entries")
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString   //  we can also use data annotation for these
//@Data
//@NoArgsConstructor

public class JournalEntry
{
    @Id
    private ObjectId id;

    public JournalEntry(ObjectId id, @NonNull String title, String content, LocalDateTime date) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
    }
    public JournalEntry(){

    }


    @NonNull
    private String title;
    private String content;
    private LocalDateTime date;

    public sentiment getSentiment() {
        return Sentiment;
    }

    public void setSentiment(sentiment sentiment) {
        Sentiment = sentiment;
    }

    private sentiment Sentiment;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public @NonNull String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "JournalEntry{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", Sentiment=" + Sentiment +
                '}';
    }
}
