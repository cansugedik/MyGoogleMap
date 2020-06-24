package com.example.testgooglemap;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class LocationActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getMyLocation();
            }
        });
    }

    private void getMyLocation() {
        MyLocation myLocation1 = new MyLocation();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction = fragmentTransaction.replace(R.id.content_location, myLocation1, "myLocation");
        fragmentTransaction.addToBackStack("myLocation");

        if (myLocation1 != null) {
            fragmentTransaction.commit();
        }
    }

}





