package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HttpUtils.with(this).get().params("11","233").request(new HttpCallBack<String>() {
            @Override
            public void onSuccess(String result) {

            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
}