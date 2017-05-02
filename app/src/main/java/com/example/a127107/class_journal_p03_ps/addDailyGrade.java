package com.example.a127107.class_journal_p03_ps;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class addDailyGrade extends AppCompatActivity {
    TextView tvWeek;
    ImageView iv;
    RadioGroup rg;
    RadioButton rb;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_daily_grade);
        Intent i = new Intent();
        DailyCa dailyCa = (DailyCa)i.getSerializableExtra("C302");

        tvWeek = (TextView) findViewById(R.id.tvWeek);
        tvWeek.setText(dailyCa.getWeek());

        iv = (ImageView)findViewById(R.id.imageView);
        iv.setImageResource(R.drawable.dg);


        rg = (RadioGroup) findViewById(R.id.rg);
        int selectedButtonId = rg.getCheckedRadioButtonId();
        // Get the radio button object from the Id we had gotten above
        rb = (RadioButton) findViewById(selectedButtonId);

        btnSubmit = (Button)findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




            }
    });





}
}
