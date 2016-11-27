package com.example.adorableaayan.mvparchitecture.presenter;

import com.example.adorableaayan.mvparchitecture.interfaces.MainActivityView;
import com.example.adorableaayan.mvparchitecture.interfaces.OnRequestComplete;
import com.example.adorableaayan.mvparchitecture.model.InvokeApi;
import com.example.adorableaayan.mvparchitecture.model.Person;

import java.util.ArrayList;

/**
 * Created by AdorableAayan on 26-Nov-16.
 */

public class MainActivityPresenter {

    MainActivityView view;

    public MainActivityPresenter(MainActivityView view) {
        this.view = view;
    }

    public void getPersonInfo() {
        view.startLoading();
        new InvokeApi(new OnRequestComplete() {
            @Override
            public void onRequestComplete(ArrayList<Person> personArrayList) {
                view.stopLoading();
                view.showPersonInfo((ArrayList<Person>) personArrayList);
            }
        });

    }

}
