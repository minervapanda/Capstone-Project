package com.epicodus.checkup.ui;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.animation.GlideAnimation;


import java.util.ArrayList;
import java.util.List;

import com.epicodus.checkup.R;
import com.epicodus.checkup.adapters.HomeRVAdapter;
import com.epicodus.checkup.database.DataContract;
import com.epicodus.checkup.interfaces.OnItemClickListener;
import com.epicodus.checkup.database.Doctor;
import com.epicodus.checkup.database.Medication;
import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity
        implements LoaderManager.LoaderCallbacks<Cursor>, OnItemClickListener{

    private String name;
    private String url;
    private static final int MEDICATION_LOADER = 1;
    private RecyclerView medicationRV;
    private List<Medication> medicationList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //FloatingActionButton upfab = (FloatingActionButton) findViewById(R.id.upfab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,AddMedicationsActivity.class));
            }
        });
        /*upfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UploadIntentService.startUpload(HomeActivity.this);
            }
        });*/


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();


        medicationRV = (RecyclerView) findViewById(R.id.medicationRV);

        Cursor cursor = getContentResolver().query(DataContract.Users.CONTENT_URI,null,null,null,null);
        if (cursor.moveToFirst()){
            do{
                name = cursor.getString(cursor.getColumnIndex(DataContract.Users.NAME));
                url = cursor.getString(cursor.getColumnIndex(DataContract.Users.PHOTO_URL));
            }while(cursor.moveToNext());
        }
        cursor.close();


    }

    @Override
    protected void onStart() {
        super.onStart();
        getSupportLoaderManager().initLoader(MEDICATION_LOADER, null, this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }




    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        switch (id) {
            case MEDICATION_LOADER:
                // Returns a new CursorLoader
                return new CursorLoader(this,   // Parent activity context
                        DataContract.Medications.CONTENT_URI,        // Table to query
                        null,     // Projection to return
                        null,            // No selection clause
                        null,            // No selection arguments
                        null             // Default sort order
                );
            default:
                // An invalid id was passed in
                return null;
        }
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if(loader.getId()==MEDICATION_LOADER) {
            medicationList = new ArrayList<>();
            if (cursor.moveToFirst()) {
                do {
                    Medication medication = new Medication();
                    medication.setProblem(cursor.getString(cursor.getColumnIndex(DataContract.Medications.PROBLEM)));
                    medication.setId(cursor.getInt(cursor.getColumnIndex(DataContract.Medications.ID)));
                    Uri uri = Uri.withAppendedPath(DataContract.Doctors.CONTENT_URI,"medication/"+medication.getId());
                    Cursor cursorDoctor = getContentResolver().query(uri,null,null,null,null);
                    List<Doctor> doctorList = new ArrayList<>();
                    if (cursorDoctor.moveToFirst()) {
                        do {
                            Doctor doctor = new Doctor();
                            doctor.setName(cursorDoctor.getString(cursorDoctor.getColumnIndex(DataContract.Doctors.NAME)));
                            doctor.setPhoneNumber(cursorDoctor.getString(cursorDoctor.getColumnIndex(DataContract.Doctors.PHONE_NUMBER)));
                            doctor.setEmail(cursorDoctor.getString(cursorDoctor.getColumnIndex(DataContract.Doctors.EMAIL)));
                            doctor.setId(cursorDoctor.getInt(cursorDoctor.getColumnIndex(DataContract.Doctors.ID)));
                            doctorList.add(doctor);
                        } while (cursorDoctor.moveToNext());
                    }
                    cursorDoctor.close();
                    medication.setDoctorList(doctorList);
                    medicationList.add(medication);
                } while (cursor.moveToNext());
            }
            HomeRVAdapter adapter = new HomeRVAdapter(this,medicationList);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            medicationRV.setLayoutManager(linearLayoutManager);
            adapter.setOnItemClickListener(this);
            medicationRV.setAdapter(adapter);
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }


    @Override
    public void onItemClick(Object obj, int position) {
        Intent intent = new Intent(HomeActivity.this,DetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("Medication",medicationList.get(position));
        intent.putExtra("bundle",bundle);
        startActivity(intent);
    }


    public void onSignOut(View view){
        FirebaseAuth.getInstance().signOut();
        this.finish();

    }

}

