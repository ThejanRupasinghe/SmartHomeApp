package com.thejan.smarthome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectionActivity extends AppCompatActivity {

    private static Button buttonBulb;
    private static Button buttonAC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        onClickButtonListeners();
    }

    public void onClickButtonListeners(){
        buttonBulb = (Button) findViewById(R.id.button_bulb);
        buttonAC = (Button) findViewById(R.id.button_ac);

        buttonBulb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent("com.thejan.smarthome.BulbControlActivity");
                //IP is to be hardcoded. If not more activity to take IP.
                intent.putExtra("Bulb_IP","192.168.8.100");
                startActivity(intent);
            }
        });

        buttonAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent("com.thejan.smarthome.ACControlActivity");
                //IP is to be hardcoded. If not more activity to take IP.
                intent.putExtra("AC_IP","192.168.8.101");
                startActivity(intent);
            }
        });
    }
}
