package com.thejan.smarthome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.volley.RequestQueue;

public class BulbControlActivity extends AppCompatActivity {

    RequestQueue queue;
    MyRequest myRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bulb_control);
    }
}
