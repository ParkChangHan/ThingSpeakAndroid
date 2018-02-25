package com.macroyau.thingspeakandroid.demo;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.macroyau.thingspeakandroid.ThingSpeakChannel;
import com.macroyau.thingspeakandroid.ThingSpeakLineChart;
import com.macroyau.thingspeakandroid.model.ChannelFeed;

import java.util.Calendar;
import java.util.Date;

import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.LineChartView;

public class sector_information extends AppCompatActivity {

    private ThingSpeakChannel tsChannel;
    private ThingSpeakLineChart[] ts_Chart = new ThingSpeakLineChart[3];
    private LineChartView[] chart_View = new LineChartView[3];
    private int[] chart_id = new int[]{R.id.chart1, R.id.chart2};
    private static Calendar current_date = Calendar.getInstance();
    private static final int[] sector = new int[]{427009,431430};
    private int channelId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sector_graph);
        
        Intent intent = getIntent();
        String sector_num = intent.getExtras().getString("sector");
        
        channelId = sector[Integer.parseInt(sector_num)-1];

        // Connect to ThinkSpeak Channel channelId
        tsChannel = new ThingSpeakChannel(channelId);
        // Set listener for Channel feed update events
        tsChannel.setChannelFeedUpdateListener(new ThingSpeakChannel.ChannelFeedUpdateListener() {
            @Override
            public void onChannelFeedUpdated(long channelId, String channelName, ChannelFeed channelFeed) {
                // Show Channel ID and name on the Action Bar
                getSupportActionBar().setTitle(channelName);
                getSupportActionBar().setSubtitle("Channel " + channelId);
                // Notify last update time of the Channel feed through a Toast message
                Date lastUpdate = channelFeed.getChannel().getUpdatedAt();
                Toast.makeText(sector_information.this, lastUpdate.toString(), Toast.LENGTH_LONG).show();
            }
        });
        // Fetch the specific Channel feed
        tsChannel.loadChannelFeed();

        // Create a Calendar object dated 5 minutes ago
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, -5);


        for(int i = 0; i < 2; i++){
            chartViewSet(i,calendar);
        }

//        // Configure LineChartView
//        chartView = findViewById(R.id.chart1);
//        chartView.setZoomEnabled(true);
//        chartView.setValueSelectionEnabled(true);
//
//        // Create a line chart from Field1 of ThinkSpeak Channel channelId
//        tsChart = new ThingSpeakLineChart(channelId, 1);
//        // Get 200 entries at maximum
//        tsChart.setNumberOfEntries(200);
//        // Set value axis labels on 10-unit interval
//        tsChart.setValueAxisLabelInterval(10);
//        // Set date axis labels on 5-minute interval
//        tsChart.setDateAxisLabelInterval(10);
//        // Show the line as a cubic spline
//        tsChart.useSpline(true);
//        // Set the line color
//        tsChart.setLineColor(Color.parseColor("#D32F2F"));
//        // Set the axis color
//        tsChart.setAxisColor(Color.parseColor("#455a64"));
//        // Set the starting date (5 minutes ago) for the default viewport of the chart
//        tsChart.setChartStartDate(calendar.getTime());
//        // Set listener for chart data update
//        tsChart.setListener(new ThingSpeakLineChart.ChartDataUpdateListener() {
//            @Override
//            public void onChartDataUpdated(long channelId, int fieldId, String title, LineChartData lineChartData, Viewport maxViewport, Viewport initialViewport) {
//                // Set chart data to the LineChartView
//                chartView.setLineChartData(lineChartData);
//                // Set scrolling bounds of the chart
//                chartView.setMaximumViewport(maxViewport);
//                // Set the initial chart bounds
//                chartView.setCurrentViewport(initialViewport);
//            }
//        });
//        // Load chart data asynchronously
//        tsChart.loadChartData();
//
//
//
//
//
//
//
//        chartView1 = findViewById(R.id.chart2);
//        chartView1.setZoomEnabled(true);
//        chartView1.setValueSelectionEnabled(true);
//
//        // Create a line chart from Field1 of ThinkSpeak Channel channelId
//        tsChart1 = new ThingSpeakLineChart(channelId, 2);
//        // Get 200 entries at maximum
//        tsChart1.setNumberOfEntries(200);
//        // Set value axis labels on 10-unit interval
//        tsChart1.setValueAxisLabelInterval(10);
//        // Set date axis labels on 5-minute interval
//        tsChart1.setDateAxisLabelInterval(10);
//        // Show the line as a cubic spline
//        tsChart1.useSpline(true);
//        // Set the line color
//        tsChart1.setLineColor(Color.parseColor("#D32F2F"));
//        // Set the axis color
//        tsChart1.setAxisColor(Color.parseColor("#455a64"));
//        // Set the starting date (5 minutes ago) for the default viewport of the chart
//        tsChart1.setChartStartDate(calendar.getTime());
//        // Set listener for chart data update
//        tsChart1.setListener(new ThingSpeakLineChart.ChartDataUpdateListener() {
//            @Override
//            public void onChartDataUpdated(long channelId, int fieldId, String title, LineChartData lineChartData, Viewport maxViewport, Viewport initialViewport) {
//                // Set chart data to the LineChartView
//                chartView1.setLineChartData(lineChartData);
//                // Set scrolling bounds of the chart
//                chartView1.setMaximumViewport(maxViewport);
//                // Set the initial chart bounds
//                chartView1.setCurrentViewport(initialViewport);
//            }
//        });
//        // Load chart data asynchronously
//        tsChart1.loadChartData();
//
//
//
//
//
//
//
//        chartView2 = findViewById(R.id.chart3);
//        chartView2.setZoomEnabled(true);
//        chartView2.setValueSelectionEnabled(true);
//
//        // Create a line chart from Field1 of ThinkSpeak Channel channelId
//        tsChart2 = new ThingSpeakLineChart(channelId, 3);
//        // Get 200 entries at maximum
//        tsChart2.setNumberOfEntries(200);
//        // Set value axis labels on 10-unit interval
//        tsChart2.setValueAxisLabelInterval(10);
//        // Set date axis labels on 5-minute interval
//        tsChart2.setDateAxisLabelInterval(10);
//        // Show the line as a cubic spline
//        tsChart2.useSpline(true);
//        // Set the line color
//        tsChart2.setLineColor(Color.parseColor("#D32F2F"));
//        // Set the axis color
//        tsChart2.setAxisColor(Color.parseColor("#455a64"));
//        // Set the starting date (5 minutes ago) for the default viewport of the chart
//        tsChart2.setChartStartDate(calendar.getTime());
//        // Set listener for chart data update
//        tsChart2.setListener(new ThingSpeakLineChart.ChartDataUpdateListener() {
//            @Override
//            public void onChartDataUpdated(long channelId, int fieldId, String title, LineChartData lineChartData, Viewport maxViewport, Viewport initialViewport) {
//                // Set chart data to the LineChartView
//                chartView2.setLineChartData(lineChartData);
//                // Set scrolling bounds of the chart
//                chartView2.setMaximumViewport(maxViewport);
//                // Set the initial chart bounds
//                chartView2.setCurrentViewport(initialViewport);
//            }
//        });
//        // Load chart data asynchronously
//        tsChart2.loadChartData();
    }

    private void chartViewSet(int i, Calendar calendar) {
        // Configure LineChartView
        final int index = i;
        chart_View[i] = findViewById(chart_id[i]);
        chart_View[i].setZoomEnabled(true);
        chart_View[i].setValueSelectionEnabled(true);

        // Create a line chart from Field1 of ThinkSpeak Channel channelId
        ts_Chart[i] = new ThingSpeakLineChart(channelId, i+1);
        // Get 200 entries at maximum
        ts_Chart[i].setNumberOfEntries(10);
        // Set value axis labels on 10-unit interval
        ts_Chart[i].setValueAxisLabelInterval(10);
        // Set date axis labels on 10-minute interval
        ts_Chart[i].setDateAxisLabelInterval(5);
        // Show the line as a cubic spline
        ts_Chart[i].useSpline(true);
        // Set the line color
        ts_Chart[i].setLineColor(Color.parseColor("#D32F2F"));
        // Set the axis color
        ts_Chart[i].setAxisColor(Color.parseColor("#455a64"));
        // Set the starting date (5 minutes ago) for the default viewport of the chart
        ts_Chart[i].setChartStartDate(calendar.getTime());
        // Set listener for chart data update
        ts_Chart[i].setListener(new ThingSpeakLineChart.ChartDataUpdateListener() {
            @Override
            public void onChartDataUpdated(long channelId, int fieldId, String title, LineChartData lineChartData, Viewport maxViewport, Viewport initialViewport) {
                // Set chart data to the LineChartView
                chart_View[index].setLineChartData(lineChartData);
                // Set scrolling bounds of the chart
                chart_View[index].setMaximumViewport(maxViewport);
                // Set the initial chart bounds
                chart_View[index].setCurrentViewport(initialViewport);

            }
        });
        ts_Chart[i].loadChartData();
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back button pressed.", Toast.LENGTH_SHORT).show();
        finish();
    }
}
