package com.example.root.first;

public class Player {

    String position;
    String name;

    public Player() {
    }

    public Player(String position, String name) {
        this.position = position;
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
