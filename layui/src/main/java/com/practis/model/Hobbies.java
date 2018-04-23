package com.practis.model;

public class Hobbies {
    private int id;
    private int uid;
    private String hobby;

    @Override
    public String toString() {
        return "Hobbies{" +
                "id=" + id +
                ", uid=" + uid +
                ", hobby='" + hobby + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
