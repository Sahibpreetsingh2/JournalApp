package com.edigest.test1.Entity;


import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "config_journal_app")

public class ConfigJournalAppEntity {
    private String key;
    private String value;

    public ConfigJournalAppEntity(){

    }

    public ConfigJournalAppEntity(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
