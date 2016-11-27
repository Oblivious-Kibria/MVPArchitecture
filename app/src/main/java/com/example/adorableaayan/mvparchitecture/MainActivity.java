package com.example.adorableaayan.mvparchitecture;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.adorableaayan.mvparchitecture.interfaces.MainActivityView;
import com.example.adorableaayan.mvparchitecture.model.Person;
import com.example.adorableaayan.mvparchitecture.presenter.MainActivityPresenter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    TextView personInfo_TextView;
    Button loadButton;
    ProgressDialog progressDialog;
    MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);

        presenter = new MainActivityPresenter(this);

        initialization();
    }

    private void initialization(){
        personInfo_TextView = (TextView) findViewById(R.id.personInfo_TextView);
        loadButton = (Button) findViewById(R.id.loadButton);

        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.getPersonInfo();
            }
        });
    }

    @Override
    public void showPersonInfo(ArrayList<Person> personArrayList) {

        Person person = personArrayList.get(0);
        String personName = person.getPersonName();
        String personEmail = person.getPersonEmail();
        String personPhone_Home = person.getPersonPhone_Home();
        String personPhone_Mobile = person.getPersonPhone_Mobile();

        String text = personName+"\n"+personEmail+"\n"+personPhone_Home+"\n"+personPhone_Mobile;
        personInfo_TextView.setText(text);
    }

    @Override
    public void startLoading() {
        showpDialog();
    }

    @Override
    public void stopLoading() {
        hidepDialog();
    }

    @Override
    public Context getAppContext() {
        return null;
    }

    private void showpDialog() {
        if (!progressDialog.isShowing())
            progressDialog.show();
    }

    private void hidepDialog() {
        if (progressDialog.isShowing())
            progressDialog.dismiss();
    }
}
