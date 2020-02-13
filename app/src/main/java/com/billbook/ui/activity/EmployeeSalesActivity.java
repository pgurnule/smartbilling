package com.billbook.ui.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.TextView;

import com.billbook.R;

import java.util.ArrayList;
import java.util.List;

public class EmployeeSalesActivity extends AppCompatActivity {

    private BarChart chart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_sales);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Employee's Sales");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        chart = findViewById(R.id.chart1);

        chart.getDescription().setEnabled(false);

        // if more than 60 entries are displayed in the chart, no values will be
        // drawn
        chart.setMaxVisibleValueCount(60);

        // scaling can now only be done on x- and y-axis separately
        chart.setPinchZoom(false);

        chart.setDrawBarShadow(false);
        chart.setDrawGridBackground(false);

        XAxis xAxis = chart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);

        chart.getAxisLeft().setDrawGridLines(false);


        // add a nice and smooth animation
        chart.animateY(1500);

        chart.getLegend().setEnabled(false);
        setChartData();
    }



    public void setChartData() {
        ArrayList<BarEntry> values = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            float multi = (1000 + 1);
            float val = (float) (Math.random() * multi) + multi / 3;
            values.add(new BarEntry(i, val));
        }

        BarDataSet set1;
        BarDataSet set2;
        BarDataSet set3;
        BarDataSet set4;
        BarDataSet set5;

        if (chart.getData() != null && chart.getData().getDataSetCount() > 0) {
            set1 = (BarDataSet) chart.getData().getDataSetByIndex(0);
            set1.setValues(values.subList(0,1));
            chart.getData().notifyDataChanged();
            chart.notifyDataSetChanged();
        } else {

            set1 = new BarDataSet(values.subList(0,1), "Anil");
            set1.setColors(Color.parseColor("#69F0AE"));
            set1.setHighLightColor(Color.parseColor("#69F0AE"));
            set1.setDrawValues(false);

            set2 = new BarDataSet(values.subList(1,2), "Amit");
            set2.setColors(Color.parseColor("#EF5350"));
            set2.setHighLightColor(Color.parseColor("#EF5350"));
            set2.setDrawValues(false);

            set3 = new BarDataSet(values.subList(2,3), "Sumit");
            set3.setColors(Color.parseColor("#F9A825"));
            set3.setHighLightColor(Color.parseColor("#F9A825"));
            set3.setDrawValues(false);

            set4 = new BarDataSet(values.subList(3,4), "Sunil");
            set4.setColors(Color.parseColor("#40C4FF"));
            set4.setHighLightColor(Color.parseColor("#40C4FF"));
            set4.setDrawValues(false);

            set5 = new BarDataSet(values.subList(4,5), "Sagar");
            set5.setColors(Color.parseColor("#AB47BC"));
            set5.setHighLightColor(Color.parseColor("#AB47BC"));
            set5.setDrawValues(false);


            ArrayList<IBarDataSet> dataSet = new ArrayList<>();
            dataSet.add(set1);
            dataSet.add(set2);
            dataSet.add(set3);
            dataSet.add(set4);
            dataSet.add(set5);

            BarData data = new BarData(dataSet);
            chart.setData(data);
            chart.setFitBars(true);

            Legend legend = chart.getLegend();
            legend.setEnabled(true);
        }

        chart.invalidate();
    }

}
