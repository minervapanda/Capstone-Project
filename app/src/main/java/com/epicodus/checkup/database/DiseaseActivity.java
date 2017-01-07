package com.epicodus.checkup.database;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.epicodus.checkup.R;

public class DiseaseActivity extends Activity {

    public static final String EXTRA_DISEASENO = "diseaseNo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diseases);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:9236547852"));
                startActivity(intent);
            }
        });

        //Get the disease from the intent
        int diseaseNo = (Integer)getIntent().getExtras().get(EXTRA_DISEASENO);

        //Create a cursor
        try{
            SQLiteOpenHelper smarthealthDatabaseHelper = new SmartHealthDatabaseHelper(this);
            SQLiteDatabase db = smarthealthDatabaseHelper.getReadableDatabase();
            Cursor cursor = db.query("DISEASE",
                                    new String[] {"NAME", "SYMPTOMS", "OVERVIEW", "EXPECTATIONS", "RISKFACTORS", "TREATMENT", "SELFCARE", "MADEWORSEBY"},
                                    "_id = ?",
                                    new String[] { Integer.toString(diseaseNo)},
                                    null, null, null);

            //Move to the first record in the Cursor
            if(cursor.moveToFirst()){

                //Get the disease details from the cursor
                String diseaseNameText = cursor.getString(0);
                String diseaseSymptomsText = cursor.getString(1);
                String diseaseOverviewText = cursor.getString(2);
                String diseaseExpectationsText = cursor.getString(3);
                String diseaseRiskFactorsText = cursor.getString(4);
                String diseaseTreatmentText = cursor.getString(5);
                String diseaseSelfCareText = cursor.getString(6);
                String diseaseMadeWorseByText = cursor.getString(7);

                //Populate the disease information
                TextView diseaseName = (TextView) findViewById(R.id.diseaseName);
                diseaseName.setText(diseaseNameText);

                TextView diseaseSymptoms = (TextView) findViewById(R.id.diseaseSymptoms);
                diseaseSymptoms.setText(diseaseSymptomsText);

                TextView diseaseOverview = (TextView) findViewById(R.id.diseaseOverview);
                diseaseOverview.setText(diseaseOverviewText);

                TextView diseaseExpectations = (TextView) findViewById(R.id.diseaseExpectations);
                diseaseExpectations.setText(diseaseExpectationsText);

                TextView diseaseRiskFactors = (TextView) findViewById(R.id.diseaseRiskFactors);
                diseaseRiskFactors.setText(diseaseRiskFactorsText);

                TextView diseaseTreatment = (TextView) findViewById(R.id.diseaseTreatment);
                diseaseTreatment.setText(diseaseTreatmentText);

                TextView diseaseSelfCare = (TextView) findViewById(R.id.diseaseSelfCare);
                diseaseSelfCare.setText(diseaseSelfCareText);

                TextView diseaseMadeWorseBy = (TextView) findViewById(R.id.diseaseMadeWorseBy);
                diseaseMadeWorseBy.setText(diseaseMadeWorseByText);
            }
            cursor.close();
            db.close();

        }catch (SQLiteException e){
            Toast toast = Toast.makeText(this, "Database Unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
