package com.example.a127107.class_journal_p03_ps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayAdapter aa;
    ArrayList <Module> module;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) this.findViewById(R.id.lvModule);

        module = new ArrayList<Module>();
        module.add(new Module("C302","Web Services"));

        aa = new ModuleAdapter(this, R.layout.modulerow, module);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String moduleCode = module.get(position).getModuleCode();
                String moduleName = module.get(position).getModuleName();
                String[] info = {moduleCode,moduleName};

                Intent i = new Intent(MainActivity.this,InfoActivity.class);
                i.putExtra("info",info);
                startActivity(i);

            }
        });
    }
    }
