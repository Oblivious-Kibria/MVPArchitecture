package com.example.adorableaayan.mvparchitecture.interfaces;

import com.example.adorableaayan.mvparchitecture.model.Person;

import java.util.ArrayList;

/**
 * Created by AdorableAayan on 26-Nov-16.
 */

public interface OnRequestComplete {
    void onRequestComplete(ArrayList<Person> object);
}
