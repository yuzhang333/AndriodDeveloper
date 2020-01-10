package com.hzskfzx.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });

        button=findViewById(R.id.start_normal_activity);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,NormalActivity.class);
                startActivity(intent);
            }
        });

        button=findViewById(R.id.start_dialog_activity);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,DialogActivity.class);
                startActivity(intent);
            }
        });
        button=findViewById(R.id.btnPlay);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });
        button=findViewById(R.id.btnFragment);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,FragmentMainActivity.class);
                startActivity(intent);
            }
        });

        button=findViewById(R.id.btnLocalFile);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, LocalStoreActivity.class);
                startActivity(intent);
            }
        });
        button=findViewById(R.id.btnInternet);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,InternetActivity.class);
                startActivity(intent);
            }
        });
        button=findViewById(R.id.btnArrayView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ArrayViewActivity.class);
                startActivity(intent);
            }
        });
        button=findViewById(R.id.btnStore);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,StoreActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TAG","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TAG","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TAG","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TAG","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAG","onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("TAG","onRestart");
    }
}
