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

public class ACLearningActivity extends AppCompatActivity {

    private static Button buttonACOnOff;
    private static Button buttonACTempUp;
    private static Button buttonACTempDown;

    RequestQueue queue;
    MyRequest myRequest;

    private static String url_base;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aclearning);

        queue= Volley.newRequestQueue(this);
        myRequest=new MyRequest();

        buttonListeners();
    }

    public void buttonListeners(){

        buttonACOnOff = (Button) findViewById(R.id.button_ac_on_off);
        buttonACTempUp = (Button) findViewById(R.id.button_ac_temp_up);
        buttonACTempDown = (Button) findViewById(R.id.button_ac_temp_down);

        url_base = "http://" + getString(R.string.acIP);

        buttonACOnOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(ACLearningActivity.this, "ON/OFF Learning ON", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(ACLearningActivity.this, SavingActivity.class);
                intent.putExtra("URL","/SAVE_ONOFF");
                intent.putExtra("name", "On/Off Button");
                startActivity(intent);

            }
        });

        buttonACTempUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(ACLearningActivity.this, "TEMP UP Learning ON", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(ACLearningActivity.this, SavingActivity.class);
                intent.putExtra("URL","/SAVE_TEMPUP");
                intent.putExtra("name", "Temp Up Button");
                startActivity(intent);

            }
        });

        buttonACTempDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(ACLearningActivity.this, "TEMP DOWN Learning ON", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(ACLearningActivity.this, SavingActivity.class);
                intent.putExtra("URL","/SAVE_TEMPDOWN");
                intent.putExtra("name", "Temp Down Button");
                startActivity(intent);

            }
        });
    }
}
