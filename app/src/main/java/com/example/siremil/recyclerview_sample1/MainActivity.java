package com.example.siremil.recyclerview_sample1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvAndroidVersions;
    StaggeredGridLayoutManager layoutManager;
    int[] logo;
    String[] codename, version, api, date;
    ArrayList<AndroidVersion> list;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvAndroidVersions = (RecyclerView) findViewById(R.id.rv_AndroidVersions);
        logo = new int[] {
                R.drawable.androidcupcake,
                R.drawable.androiddonut,
                R.drawable.androideclair,
                R.drawable.androidfroyo,
                R.drawable.androidgingerbread,
                R.drawable.androidhoneycomb,
                R.drawable.androidicecreamsandwich,
                R.drawable.androidjellybean,
                R.drawable.androidkitkat,
                R.drawable.androidlollipop,
                R.drawable.androidmarshmallow,
                R.drawable.androidnougat,
                R.drawable.androidoreo
        };
                codename = getResources().getStringArray(R.array.codename);
                version = getResources().getStringArray(R.array.version);
                api = getResources().getStringArray(R.array.api);
                date = getResources().getStringArray(R.array.date);
                list = new ArrayList<AndroidVersion>();

                //For LinearLayoutManager:
                //layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                layoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
                rvAndroidVersions.setLayoutManager(layoutManager);
                rvAndroidVersions.setHasFixedSize(true);

                for ( int i = 0; i < codename.length  ; i++ ) {
                    list.add( new AndroidVersion( logo[i], codename[i], version[i], api[i], date[i] ) );
                }

                adapter = new CustomAdapter(list);
                rvAndroidVersions.setAdapter(adapter);

    }
}


