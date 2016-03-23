package cpre186project.stattracker;

import android.content.Context;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.view.MotionEvent;
import android.widget.Toast;


import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import static android.view.GestureDetector.*;


public class MainActivity extends AppCompatActivity  {
    TextView output;
    MotionEvent point;
    int[] score = new int[21];
    NumberPicker player;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        player = (NumberPicker) findViewById(R.id.playerPicker);
        output = (TextView) findViewById(R.id.output);
        output.setText("");
        player.setMaxValue(20);
        player.setMinValue(0);
        // hey
       //score = null;
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void buttonClickScore(View scoreButton) {
        score[player.getValue()]++;
        output.setText(("  Player " + player.getValue() + " has made " + score[player.getValue()] + " baskets!"));

    }

    public void onViewClick(View viewCurrent) {
        output.setText(("  Player " + player.getValue() + " has made " + score[player.getValue()] + " baskets!"));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // MotionEvent object holds X-Y values
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            output.setText("You click at x = " + event.getX() + " and y = " + event.getY());

        }

        return super.onTouchEvent(event);
    }
}



