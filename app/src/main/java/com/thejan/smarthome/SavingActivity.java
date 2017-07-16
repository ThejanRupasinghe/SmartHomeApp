package com.thejan.smarthome;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.Arrays;

public class SavingActivity extends AppCompatActivity {

    RequestQueue queue;
    MyRequest myRequest;

    private static String url_base;
    private static String URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saving);

        queue= Volley.newRequestQueue(this);
        myRequest=new MyRequest();

        url_base = "http://" + getString(R.string.acIP);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        URL = intent.getStringExtra("URL");
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(name);

        Button saveButton = (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = url_base + URL ;

                if(myRequest.HttpRequest(queue, url) != null){
                    Toast.makeText(SavingActivity.this, "SAVED SUCCESSFULLY", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(SavingActivity.this, "error", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
