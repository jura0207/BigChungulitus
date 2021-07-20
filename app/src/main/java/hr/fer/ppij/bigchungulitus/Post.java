package hr.fer.ppij.bigchungulitus;

import java.sql.Timestamp;

public class Post {
    private Timestamp timeCreated;
    private String text;
    private String usernameCreated;

    public String getUsernameCreated() {
        return usernameCreated;
    }

    public Timestamp getTimeCreated() {
        return timeCreated;
    }

    public String getText() {
        return text;
    }

    public void setUsernameCreated(String usernameCreated) {
        this.usernameCreated = usernameCreated;
    }

    public void setTimeCreated(Timestamp timeCreated) {
        this.timeCreated = timeCreated;
    }

    public void setText(String text) {
        this.text = text;
    }


}
