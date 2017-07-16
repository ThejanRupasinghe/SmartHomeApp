package com.thejan.smarthome;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class ACControlActivity extends AppCompatActivity {

    private static ToggleButton toggleButtonAC;
    private static Button buttonACTempUp;
    private static Button buttonACTempDown;
    private static TextView textViewACStatus;

    RequestQueue queue;
    MyRequest myRequest;

    private static String url_base;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accontrol);

        queue= Volley.newRequestQueue(this);
        myRequest=new MyRequest();

        buttonListeners();
    }

    public void buttonListeners(){

        toggleButtonAC = (ToggleButton) findViewById(R.id.toggleButton_ac);
        buttonACTempUp = (Button) findViewById(R.id.button_ac_temp_up);
        buttonACTempDown = (Button) findViewById(R.id.button_ac_temp_down);
        textViewACStatus = (TextView) findViewById(R.id.textView_acStatus);

        url_base = "http://" + getString(R.string.acIP);

        buttonACTempUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = url_base + "/DO_TEMPUP";

                if(myRequest.HttpRequest(queue, url) != null){
                    Toast.makeText(ACControlActivity.this, "A/C TEMP UP", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ACControlActivity.this, "error", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonACTempDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = url_base + "/DO_TEMPDOWN";

                if(myRequest.HttpRequest(queue, url) != null){
                    Toast.makeText(ACControlActivity.this, "A/C TEMP UP", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ACControlActivity.this, "error", Toast.LENGTH_SHORT).show();
                }
            }
        });

        toggleButtonAC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){

                    String url = url_base + "/DO_ONOFF";

                    if(myRequest.HttpRequest(queue, url) != null){
                        Toast.makeText(ACControlActivity.this, "A/C On", Toast.LENGTH_SHORT).show();
                        textViewACStatus.setTextColor(Color.parseColor("#ff99cc00"));
                        textViewACStatus.setText("A/C ON");
                    } else {
                        Toast.makeText(ACControlActivity.this, "error", Toast.LENGTH_SHORT).show();
                    }

                } else {

                    String url = url_base + "/DO_ONOFF";

                    if(myRequest.HttpRequest(queue, url) != null){
                        Toast.makeText(ACControlActivity.this, "A/C Off", Toast.LENGTH_SHORT).show();
                        textViewACStatus.setTextColor(Color.parseColor("#ffff4444"));
                        textViewACStatus.setText("A/C OFF");
                    } else {
                        Toast.makeText(ACControlActivity.this, "error", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
    }
}
