package com.thejan.smarthome;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    // STATIC IP OF THE AC
    private String acIP = "192.168.43.74";

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

        url_base = "http://" + acIP;

        toggleButtonAC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){

                    String url = url_base + "/AC=ON";

                    if(myRequest.HttpRequest(queue, url) != null){
                        Toast.makeText(ACControlActivity.this, "A/C On", Toast.LENGTH_SHORT).show();
                        textViewACStatus.setTextColor(Color.parseColor("#ff99cc00"));
                        textViewACStatus.setText("A/C ON");
                    } else {
                        Toast.makeText(ACControlActivity.this, "error", Toast.LENGTH_SHORT).show();
                    }

                } else {

                    String url = url_base + "/AC=OFF";

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
