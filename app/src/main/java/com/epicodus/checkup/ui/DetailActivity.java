package com.epicodus.checkup.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.epicodus.checkup.R;

import com.epicodus.checkup.fragment.DetailFragment;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        DetailFragment detailFragment = new DetailFragment();
        detailFragment.setArguments(getIntent().getBundleExtra("bundle"));
        getSupportFragmentManager().beginTransaction().add(R.id.container,detailFragment).commit();

    }

}
