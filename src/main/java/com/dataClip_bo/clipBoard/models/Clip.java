package com.dataClip_bo.clipBoard.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "clips")
public class Clip {

    @Id
    private String id;
    private String content;
    private List<String> tags;
    private String date;

    // Constructors, getters and setters
    public Clip(String content, List<String> tags, String date) {
        this.content = content;
        this.tags = tags;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
