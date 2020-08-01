package com.example.library.entity;

import javax.persistence.*;
import java.text.SimpleDateFormat;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String firstName;
    String secondName;
    SimpleDateFormat birthDay = new SimpleDateFormat("dd-MM-y");

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public SimpleDateFormat getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(SimpleDateFormat birthDay) {
        this.birthDay = birthDay;
    }
}
