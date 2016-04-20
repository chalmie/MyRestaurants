package com.chalmie.myrestaurants;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class RestaurantsActivity extends AppCompatActivity {
    private TextView mLocationTextView;
    private ListView mListView;
    private Toast mToastToShow;
    private String[] restaurants = new String[] {"Mi Mero Mole", "Mother's Bistro",
            "Life of Pie", "Screen Door", "Luc Lac", "Sweet Basil",
            "Slappy Cakes", "Equinox", "Miss Delta's", "Andina",
            "Lardo", "Portland City Grill", "Fat Head's Brewery",
            "Chipotle", "Subway"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        mListView = (ListView) findViewById(R.id.listView);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, restaurants);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int toastDurationInMilliSeconds = 1000;
                String restaurant = ((TextView)view).getText().toString();
                mToastToShow = Toast.makeText(RestaurantsActivity.this, restaurant, Toast.LENGTH_LONG);

                CountDownTimer toastCountDown;
                toastCountDown = new CountDownTimer(toastDurationInMilliSeconds, 1000) {
                    @Override
                    public void onTick(long l) {
                        mToastToShow.show();
                    }

                    @Override
                    public void onFinish() {
                        mToastToShow.cancel();
                    }
                };

                mToastToShow.show();
                toastCountDown.start();
            }
        });

        mLocationTextView = (TextView) findViewById(R.id.locationTextView);

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        mLocationTextView.setText("Here are all the restaurants near: " + location);
    }
}
