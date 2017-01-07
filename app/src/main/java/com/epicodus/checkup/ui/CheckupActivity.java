package com.epicodus.checkup.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.epicodus.checkup.R;

/**
 * Created by Minarva on 04-01-17.
 */
public class CheckupActivity extends Activity {

    private Button checksymptoms;
    private Button checkbmi;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkup);

        checksymptoms = (Button) findViewById(R.id.symptomsbutton);
        checkbmi =(Button) findViewById(R.id.bmibutton);

        checkbmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CheckupActivity.this, BMI_calculator.class);
                startActivity(i);

            }
        });
        checksymptoms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CheckupActivity.this, SymtomsActivity.class);
                startActivity(i);

            }
        });


    }

}
