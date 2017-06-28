package com.thejan.smarthome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ActionMenuItemView;
import android.view.View;
import android.widget.Button;

public class ACModeSelectionActivity extends AppCompatActivity {
    private Button btnSelectLearningMode;
    private Button btnSelectControllingMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acmode_selection);

        btnSelectLearningMode = (Button) findViewById(R.id.btnSelectLearningMode);
        btnSelectControllingMode = (Button) findViewById(R.id.btnSelectControllingMode);

        btnSelectControllingMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ACModeSelectionActivity.this, ACControlActivity.class);
                startActivity(i);
            }
        });

        btnSelectLearningMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ACModeSelectionActivity.this, ACLearningActivity.class);
                startActivity(i);
            }
        });
    }
}
