package com.epicodus.checkup.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.epicodus.checkup.R;
import com.epicodus.checkup.database.BrowseDiseaseCategoryActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class  AppointmentsActivity extends BaseActivity implements View.OnClickListener {
    private Button checkup;
    private Button diseaseList;
    private Button prescription;

    @Bind(R.id.findDoctorButton) Button mFindDoctorButton;
    @Bind(R.id.savedDoctorsButton) Button mSavedDoctorsButton;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointments);
        super.onCreateDrawer();

        ButterKnife.bind(this);
        mFindDoctorButton.setOnClickListener(this);
        mSavedDoctorsButton.setOnClickListener(this);


        checkup = (Button) findViewById(R.id.checkup);
        diseaseList =(Button) findViewById(R.id.diseaselist);
        prescription =(Button) findViewById(R.id.prescription);


        checkup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AppointmentsActivity.this, CheckupActivity.class);
                startActivity(i);

            }
        });
        diseaseList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AppointmentsActivity.this, BrowseDiseaseCategoryActivity.class);
                startActivity(i);

            }
        });
        prescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AppointmentsActivity.this,HomeActivity.class);
                startActivity(i);

            }
        });

    }

    @Override
    public void onClick(View v) {

        if (v == mFindDoctorButton) {
            Intent intent = new Intent(AppointmentsActivity.this, FindDoctorActivity.class);
            startActivity(intent);
        }
        if (v == mSavedDoctorsButton) {
            Intent intent = new Intent(AppointmentsActivity.this, SavedDoctorListActivity.class);
            startActivity(intent);
        }

    }
}
