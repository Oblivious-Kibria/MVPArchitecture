package com.example.adorableaayan.mvparchitecture.model;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.adorableaayan.mvparchitecture.ConstantValues;
import com.example.adorableaayan.mvparchitecture.controller.AppController;
import com.example.adorableaayan.mvparchitecture.interfaces.OnRequestComplete;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

/**
 * Created by AdorableAayan on 26-Nov-16.
 */

public class InvokeApi {
    OnRequestComplete requestComplete;

    public InvokeApi( final OnRequestComplete onRequestComplete) {
        this.requestComplete = onRequestComplete;

        JsonObjectRequest jsonObjectRequest= new JsonObjectRequest(Request.Method.GET, ConstantValues.URL, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {

                    String personName = response.getString("name");
                    String personEmail = response.getString("email");
                    JSONObject phone = response.getJSONObject("phone");
                    String personPhone_Home = phone.getString("home");
                    String personPhone_Mobile = phone.getString("mobile");

                    ArrayList<Person> personArrayList = new ArrayList<>();
                    Person person = new Person(personName, personEmail, personPhone_Home, personPhone_Mobile);
                    personArrayList.add(person);

                    requestComplete.onRequestComplete(personArrayList);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        // Add the request to the RequestQueue.
        AppController.getInstance().addToRequestQueue(jsonObjectRequest);
    }
}
