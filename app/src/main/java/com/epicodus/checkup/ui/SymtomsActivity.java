package com.epicodus.checkup.ui;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.epicodus.checkup.R;

public class SymtomsActivity extends Activity {

    private CheckBox symp1, symp2, symp3 ,symp4 , symp5 , symp6 ,symp7, symp8, symp9;
    private Button btnDisplay;
    TextToSpeech textToSpeech;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checksymptoms);

        addListenerOnChkIos();
        addListenerOnButton();
    }



    public void addListenerOnChkIos() {

        symp1 = (CheckBox) findViewById(R.id.symp1);

        symp1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                //is chkIos checked?
                if (((CheckBox) v).isChecked()) {
                   // Toast.makeText(MyAndroidAppActivity.this,
                         //   "Bro, try Android :)", Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    public void addListenerOnButton() {

        symp2 = (CheckBox) findViewById(R.id.symp2);
        symp3 = (CheckBox) findViewById(R.id.symp3);
        symp4 = (CheckBox) findViewById(R.id.symp4);
        symp5 = (CheckBox) findViewById(R.id.symp5);
        symp6 = (CheckBox) findViewById(R.id.symp6);
        symp7 = (CheckBox) findViewById(R.id.symp7);
        symp8 = (CheckBox) findViewById(R.id.symp8);
        symp9 = (CheckBox) findViewById(R.id.symp9);
                btnDisplay = (Button) findViewById(R.id.btnDisplay);

        btnDisplay.setOnClickListener(new OnClickListener() {

            //Run when button is clicked
            @Override
            public void onClick(View v) {

                StringBuffer result = new StringBuffer();
                if((symp1.isChecked() || symp2.isChecked() ) && !symp4.isChecked())
                {
                  result.append("MALARIA"); }
                else if(symp4.isChecked() || symp8.isChecked() || symp7.isChecked() || symp8.isChecked())
                 {
                     symp1.setChecked(false);
                     symp2.setChecked(false);
                     result.append("JAUNDICE"); }
                //  result.append("\nWindows Mobile check :").append(chkWindows.isChecked());

                Toast.makeText(SymtomsActivity.this, result.toString(),
                        Toast.LENGTH_LONG).show();

            }
        });

    }
}