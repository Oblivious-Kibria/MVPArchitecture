package com.example.adorableaayan.mvparchitecture.model;

import java.io.Serializable;

/**
 * Created by AdorableAayan on 26-Nov-16.
 */

public class Person implements Serializable {

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonEmail() {
        return personEmail;
    }

    public void setPersonEmail(String personEmail) {
        this.personEmail = personEmail;
    }

    public String getPersonPhone_Home() {
        return personPhone_Home;
    }

    public void setPersonPhone_Home(String personPhone_Home) {
        this.personPhone_Home = personPhone_Home;
    }

    public String getPersonPhone_Mobile() {
        return personPhone_Mobile;
    }

    public void setPersonPhone_Mobile(String personPhone_Mobile) {
        this.personPhone_Mobile = personPhone_Mobile;
    }

    private String personName;
    private String personEmail;
    private String personPhone_Home;
    private String personPhone_Mobile;

    Person(String personName, String personEmail, String personPhone_Home, String personPhone_Mobile){
        this.personName = personName;
        this.personEmail = personEmail;
        this.personPhone_Home = personPhone_Home;
        this.personPhone_Mobile = personPhone_Mobile;
    }
}
