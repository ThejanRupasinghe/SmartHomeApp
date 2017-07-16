package com.thejan.smarthome;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class BulbControlActivity extends AppCompatActivity {

    private static ToggleButton toggleButtonBulb;
    private static TextView textViewStatus;

    RequestQueue queue;
    MyRequest myRequest;

    private static String url_base;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bulb_control);

        toggleButtonListener();

        queue= Volley.newRequestQueue(this);
        myRequest=new MyRequest();
    }

    public void toggleButtonListener(){

        toggleButtonBulb = (ToggleButton) findViewById(R.id.toggleButton_bulb);
        textViewStatus = (TextView) findViewById(R.id.textView_bulbStatus);

        url_base = "http://" + getString(R.string.bulbIP);

        toggleButtonBulb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){

                    String url = url_base + "/BULB=ON";

                    if(myRequest.HttpRequest(queue, url) != null){
                        Toast.makeText(BulbControlActivity.this, "Bulb On", Toast.LENGTH_SHORT).show();
                        textViewStatus.setTextColor(Color.parseColor("#ff99cc00"));
                        textViewStatus.setText("Bulb ON");
                    } else {
                        Toast.makeText(BulbControlActivity.this, "error", Toast.LENGTH_SHORT).show();
                    }

                } else {

                    String url = url_base + "/BULB=OFF";

                    if(myRequest.HttpRequest(queue, url) != null){
                        Toast.makeText(BulbControlActivity.this, "Bulb Off", Toast.LENGTH_SHORT).show();
                        textViewStatus.setTextColor(Color.parseColor("#ffff4444"));
                        textViewStatus.setText("Bulb OFF");
                    } else {
                        Toast.makeText(BulbControlActivity.this, "error", Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });
    }
}
