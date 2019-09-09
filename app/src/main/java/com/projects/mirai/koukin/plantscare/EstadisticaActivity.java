package com.projects.mirai.koukin.plantscare;

import android.graphics.Color;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.Calendar;
import java.util.Date;

public class EstadisticaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadistica);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        Log.e("Width", "" + width);
        Log.e("height", "" + height);


        GraphView graph = (GraphView) findViewById(R.id.graph);
        graph.setTitle("Resumen del día de hoy 13/02/2019");
        graph.setTitleColor(Color.parseColor("#ff669900"));
        graph.setTitleTextSize(60);


        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMinY(0);
        graph.getViewport().setMaxY(100);

        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(1);
        graph.getViewport().setMaxX(16);

        // enable scaling and scrolling
        graph.getViewport().setScalable(true);
        graph.getViewport().setScalableY(true);

        graph.getLegendRenderer().setVisible(true);
        //graph.getLegendRenderer().setFixedPosition(0,size.x/2);
        graph.getLegendRenderer().setBackgroundColor(Color.TRANSPARENT);
        graph.getLegendRenderer().setTextSize(60);

        graph.getGridLabelRenderer().setNumHorizontalLabels(16);
        graph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);



        graph.getGridLabelRenderer().setHumanRounding(false);




        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(1, 90),
                new DataPoint(2, 40),
                new DataPoint(3, 30),
                new DataPoint(4, 30),
                new DataPoint(5, 35),
                new DataPoint(6, 40),
                new DataPoint(7, 80),
                new DataPoint(8, 85),
                new DataPoint(9, 70),
                new DataPoint(10, 60),
                new DataPoint(11, 50),
                new DataPoint(12, 95)
        });
        series.setTitle("Humedad %");
        series.setColor(Color.BLUE);
        series.setDrawDataPoints(true);
        series.setDataPointsRadius(10);
        series.setThickness(8);



        LineGraphSeries<DataPoint> series2 = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(1, 25),
                new DataPoint(2, 23),
                new DataPoint(3, 23),
                new DataPoint(4, 23),
                new DataPoint(5, 23),
                new DataPoint(6, 23),
                new DataPoint(7, 21),
                new DataPoint(8, 25),
                new DataPoint(9, 23),
                new DataPoint(10, 23),
                new DataPoint(12, 40)
        });

        series2.setTitle("Temperatura °C");
        series2.setColor(Color.RED);
        series2.setDrawDataPoints(true);
        series2.setDataPointsRadius(10);
        series2.setThickness(8);





        graph.addSeries(series);
        graph.addSeries(series2);
        //graph.getSecondScale().addSeries(series2);
        //graph.getSecondScale().setMinY(-10);
        //graph.getSecondScale().setMaxY(40);
    }
}
