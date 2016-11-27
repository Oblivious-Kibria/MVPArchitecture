package com.example.adorableaayan.mvparchitecture.interfaces;

import android.content.Context;

import com.example.adorableaayan.mvparchitecture.model.Person;

import java.util.ArrayList;

/**
 * Created by AdorableAayan on 26-Nov-16.
 */

public interface MainActivityView {

    void showPersonInfo(ArrayList<Person> personArrayList);

    void startLoading();

    void stopLoading();

    Context getAppContext();
}
