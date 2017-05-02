package com.example.a127107.class_journal_p03_ps;

import android.content.Intent;
import android.icu.text.IDNA;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class InfoActivity extends AppCompatActivity {
    Button btnEmail, btnAdd, btnInfo;
    ListView lv;
    ArrayAdapter aa;
    ArrayList<DailyCa> dailyca;
    String moduleCode;
    String moduleName;
    int requestCode = 1;
    int size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        btnEmail = (Button) findViewById(R.id.buttonEmail);
        btnAdd = (Button) findViewById(R.id.buttonAdd);
        btnInfo = (Button) findViewById(R.id.buttonInfo);

        lv = (ListView) this.findViewById(R.id.lvGrades);
        Intent i = getIntent();
        // Get the String array named "info" we passed in
        String[] info = i.getStringArrayExtra("info");
        // Get the TextView object
        dailyca = new ArrayList<DailyCa>();
        for (int a = 0; a < dailyca.size(); a++) {
            moduleCode = info[0].toString();
            moduleName = info[1].toString();
            String DailyGrade = dailyca.get(a).getDgGrade();
            Integer Week = dailyca.get(a).getWeek();


            dailyca.add(new DailyCa(DailyGrade, moduleCode, Week));


            aa = new InfoAdapter(this, R.layout.dailyrow, dailyca);
            lv.setAdapter(aa);

            Intent addIntent = new Intent(InfoActivity.this, addDailyGrade.class);
            i.putExtra("info", info);
            startActivity(addIntent);

            btnEmail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View arg0) {
                    // The action you want this intent to do;
                    // ACTION_SEND is used to indicate sending text
                    Intent email = new Intent(Intent.ACTION_SEND);
                    // Put essentials like email address, subject & body text
                    email.putExtra(Intent.EXTRA_EMAIL,
                            new String[]{"jason_lim@rp.edu.sg"});
                    email.putExtra(Intent.EXTRA_SUBJECT,
                            "-");
                    email.putExtra(Intent.EXTRA_TEXT,
                            "");
                    // This MIME type indicates email
                    email.setType("message/rfc822");
                    // createChooser shows user a list of app that can handle
                    // this MIME type, which is, email
                    startActivity(Intent.createChooser(email,
                            "Choose an Email client :"));

                }
            });

            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    size = dailyca.size() + 1;
                    Intent weeks = new Intent(InfoActivity.this, addDailyGrade.class);
                    weeks.putExtra("week", dailyca.size() + 1 + "");
                    startActivityForResult(weeks, requestCode);


                }
            });


            btnInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                    // Set the URL to be used.
                    rpIntent.setData(Uri.parse("http://www.rp.edu.sg/Module_Synopses/" + moduleCode + "_" + "moduleName" + ".aspx"));
                    startActivity(rpIntent);

                }
            });
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (data != null) {
                String like = data.getStringExtra("grade");

                if (requestCode == requestCode) {
                    dailyca.add(new DailyCa(like,"C349" ,size));
                    aa.notifyDataSetChanged();
                }

            }
        }
    }

}