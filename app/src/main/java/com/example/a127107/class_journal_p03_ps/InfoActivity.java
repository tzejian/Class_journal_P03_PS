package com.example.a127107.class_journal_p03_ps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class InfoActivity extends AppCompatActivity {
    ListView lv;
    ArrayAdapter aa;
    ArrayList<DailyCa> dailyca;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
      Intent i = getIntent();
        String[] info = i.getStringArrayExtra("info");
        String moduleCode = info[0];
        String moduleName = info[1];

    }
}
