/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.sql.Timestamp;

/**
 *
 * @author Moez
 */
public class forum {
    private int id;
    private int idCategorie;
    private int user;
    private String title;
    private String description;
    private Timestamp date;

    public forum() {
    }

    public forum(int id, int idCategorie, int user, String title, String description, Timestamp date) {
        this.id = id;
        this.idCategorie = idCategorie;
        this.user = user;
        this.title = title;
        this.description = description;
        this.date = date;
    }

    public forum(int idCategorie, int user, String title, String description, Timestamp date) {
        this.idCategorie = idCategorie;
        this.user = user;
        this.title = title;
        this.description = description;
        this.date = date;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }
    
    

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "forum{" + "id=" + id + ", categorie=" + idCategorie + ", user=" + user + ", title=" + title + ", description=" + description + ", date=" + date + '}';
    }

   
    
    

    

    

    

    
    
}
