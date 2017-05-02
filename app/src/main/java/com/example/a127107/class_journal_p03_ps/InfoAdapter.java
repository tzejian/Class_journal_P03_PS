package com.example.a127107.class_journal_p03_ps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class InfoAdapter extends ArrayAdapter{
    private ArrayList<DailyCa> dailyca;
    private Context context;
    private TextView tvWeek;
    private  TextView tvGrade;
    private TextView tvDG;
    private ImageView ivDG;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.dailyrow, parent, false);


        tvWeek = (TextView) rowView.findViewById(R.id.textViewWeek);
        tvDG = (TextView) rowView.findViewById(R.id.textViewDG);
        tvGrade = (TextView) rowView.findViewById(R.id.textViewGrade);
        ivDG = (ImageView) rowView.findViewById(R.id.imageViewdg);

        DailyCa currentCa = dailyca.get(position);

        tvWeek.setText(currentCa.getWeek());
        tvGrade.setText(currentCa.getDgGrade());
        tvDG.setText("DG");
        ivDG.setImageResource(R.drawable.dg);
        return rowView;
    }
    public InfoAdapter(Context context, int resource, ArrayList<DailyCa> objects){
        super(context, resource, objects);

        dailyca = objects;
        this.context = context;
    }
}
