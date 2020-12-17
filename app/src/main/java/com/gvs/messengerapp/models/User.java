package com.gvs.messengerapp.models;

public class User {
    private final String id;
    private String username;
    private String email;
    private String fullname;
    private String photoUrl;

    public User(String id) {
        this.id = id;
    }

    public User(String id, String username, String email, String fullname, String photoUrl) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.fullname = fullname;
        this.photoUrl = photoUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
