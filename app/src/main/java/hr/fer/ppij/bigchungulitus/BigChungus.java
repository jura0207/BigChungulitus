package hr.fer.ppij.bigchungulitus;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BigChungus {
    private CharSequence username;
    private CharSequence password;
    private CharSequence email;
    private CharSequence name;
    private CharSequence lastName;
    private Date date;

    public BigChungus(){
        this.username = "admin";
        this.password = "admin";
        this.email = "admin@admin.com";
        this.name = "Admin";
        this.lastName = "Admin";
        //this.date = date;
    }

    public BigChungus(CharSequence username, CharSequence password, CharSequence email, CharSequence name, CharSequence lastName) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.date = date;
    }

    public void setUsername(CharSequence username) {
        this.username = username;
    }

    public void setPassword(CharSequence password) {
        this.password = password;
    }

    public void setEmail(CharSequence email) {
        this.email = email;
    }

    public void setName(CharSequence name) {
        this.name = name;
    }

    public void setLastName(CharSequence lastName) {
        this.lastName = lastName;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public CharSequence getUsername() {
        return username;
    }

    public CharSequence getPassword() {
        return password;
    }

    public CharSequence getEmail(){
        return email;
    }

    public CharSequence getName(){
        return name;
    }

    public CharSequence getLastName(){
        return lastName;
    }

    public Date date(){
        return date;
    }
}
