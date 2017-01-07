package com.epicodus.checkup.database;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class BrowseDiseaseCategoryActivity extends ListActivity{
    private SQLiteDatabase db;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        ListView listDiseases = getListView();

        try{
            SQLiteOpenHelper smarthealthDatabaseHelper = new SmartHealthDatabaseHelper(this);
            db = smarthealthDatabaseHelper.getReadableDatabase();

            cursor = db.query("DISEASE",
                    new String[]{"_id", "NAME"},
                    null, null, null, null, null);

            CursorAdapter listAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1,
                                                                cursor,
                                                                new String[]{"NAME"},
                                                                new int[]{android.R.id.text1}, 0);
            listDiseases.setAdapter(listAdapter);
        }catch (SQLiteException e){
            Toast toast = Toast.makeText(this, "Database Unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        cursor.close();
        db.close();
    }

    @Override
    public void onListItemClick(ListView listView,
                                View itemView,
                                int position,
                                long id){
        Intent intent = new Intent(BrowseDiseaseCategoryActivity.this, DiseaseActivity.class);
        intent.putExtra(DiseaseActivity.EXTRA_DISEASENO, (int) id);
        startActivity(intent);
    }
}
