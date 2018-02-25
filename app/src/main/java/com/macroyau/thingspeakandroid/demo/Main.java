package com.macroyau.thingspeakandroid.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import static com.macroyau.thingspeakandroid.demo.login.log_in;

//import com.macroyau.thingspeakandroid.ThingSpeakChannel;
//import com.macroyau.thingspeakandroid.model.ChannelFeed;

/**
 * Created by pch on 2018-02-20.
 */

public class Main extends AppCompatActivity {
    Button sector_1;
    Button sector_2;

//    private ThingSpeakChannel tsChannel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sector_1 = (Button) findViewById(R.id.sector_1);
        sector_2 = (Button) findViewById(R.id.sector_2);

        sector_1.setOnClickListener(onClick(1));
        sector_2.setOnClickListener(onClick(2));

        log_in.finish();
//        tsChannel = new ThingSpeakChannel(427009);
//        // Set listener for Channel feed update events
//        tsChannel.setChannelFeedUpdateListener(new ThingSpeakChannel.ChannelFeedUpdateListener() {
//            @Override
//            public void onChannelFeedUpdated(long channelId, String channelName, ChannelFeed channelFeed) {
//                // Show Channel ID and name on the Action Bar
//                sector_1.setText(channelName);
//                // Notify last update time of the Channel feed through a Toast message
//            }
//        });
//        tsChannel.loadChannelFeed();
    }

    public View.OnClickListener onClick(int num){
        final int sector_num = num;
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(getApplicationContext(), sector_information.class);
                intent.putExtra("sector", sector_num + "");
                startActivity(intent);
            }
        };
    }
}
