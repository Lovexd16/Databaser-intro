package com.javatodo.javatodo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Todo { //Lägg till de kolumner vi vill ha i databasen

    @Id //Talar om att int id ska vara ett id
    @GeneratedValue(strategy = GenerationType.AUTO) //gör så id:t automatiskt räknar uppåt, 1,2,3...
    private int id;
    private String item;
    private int deleted;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getItem() {
        return item;
    }
    public void setItem(String item) {
        this.item = item;
    }
    public int getDeleted() {
        return deleted;
    }
    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

}
