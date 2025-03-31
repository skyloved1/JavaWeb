package main.model;

import java.nio.file.InvalidPathException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
    private int id;
    private String name;
    private String password;
    private String email;
    private java.util.Date birthday;

    public User(int id, String name, String password, String email, Date birthday) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.birthday = birthday;
    }

    public User(String username, String password, String email, String date) throws ParseException {
        this.name = username;
        this.password = password;
        this.email = email;
        this.birthday = new SimpleDateFormat("yyyy-MM-dd").parse(date);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public java.util.Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public User(int id, String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.birthday = new Date(System.currentTimeMillis());
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name='" + name + '\'' + ", password='" + password + '\'' + ", email='" + email + '\'' + ", birthday=" + birthday + '}';
    }
}
