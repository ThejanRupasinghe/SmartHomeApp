package com.thejan.smarthome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class ACModeSelectionActivity extends AppCompatActivity {
    private Button btnSelectLearningMode;
    private Button btnSelectControllingMode;

    RequestQueue queue;
    MyRequest myRequest;

    // STATIC IP OF THE AC
    private String acIP = "192.168.43.74";

    private static String url_base;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acmode_selection);

        queue= Volley.newRequestQueue(this);
        myRequest=new MyRequest();

        buttonListeners();
    }

    public void buttonListeners(){

        btnSelectLearningMode = (Button) findViewById(R.id.btnSelectLearningMode);
        btnSelectControllingMode = (Button) findViewById(R.id.btnSelectControllingMode);

        url_base = "http://" + acIP;

        btnSelectControllingMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String url = url_base + "/CONTROL=ON";

                if(myRequest.HttpRequest(queue, url) != null){
                    Toast.makeText(ACModeSelectionActivity.this, "Controlling Mode On", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(ACModeSelectionActivity.this, ACControlActivity.class);
                    startActivity(i);

                } else {
                    Toast.makeText(ACModeSelectionActivity.this, "error", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnSelectLearningMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String url = url_base + "/LEARN=ON";

                if(myRequest.HttpRequest(queue, url) != null){
                    Toast.makeText(ACModeSelectionActivity.this, "Learning Mode On", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(ACModeSelectionActivity.this, ACLearningActivity.class);
                    startActivity(i);

                } else {
                    Toast.makeText(ACModeSelectionActivity.this, "error", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


}
