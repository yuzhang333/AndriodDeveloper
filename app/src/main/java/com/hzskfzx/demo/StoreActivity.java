package com.hzskfzx.demo;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.concurrent.Callable;

public class StoreActivity extends AppCompatActivity {
    private static final String TAG = "StoreActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        Button button=findViewById(R.id.btnSavePreference);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=getSharedPreferences("data",MODE_PRIVATE);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString("name","Roy");
                edit.commit();
            }
        });

        button=findViewById(R.id.btnGetPreference);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=getSharedPreferences("data",MODE_PRIVATE);
                String s = sharedPreferences.getString("name", "defaultString");
                Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
            }
        });
    }
}
