package it.sochat.objects;

import java.awt.*;

public class UserInfo {
    private String username;
    private Color color;

    public UserInfo(String username, Color color) {
        this.username = username;
        this.color = color;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if(!username.matches("^[a-z0-9_-]{3,15}$"))
            return;
        this.username = username;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
