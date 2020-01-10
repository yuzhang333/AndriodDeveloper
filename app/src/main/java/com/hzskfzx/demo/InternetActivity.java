package com.hzskfzx.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class InternetActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "InternetActivity";
    TextView responseText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internet);

        Button btn = findViewById(R.id.btnSendRequest);
        btn.setOnClickListener(this);

        responseText = findViewById(R.id.response_Text);
        responseText.setText("初始化成功");
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnSendRequest) {
            sendRequest();
        }
    }

    private void sendRequest() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                BufferedReader reader = null;
                try {
                    URL url = new URL("https://www.baidu.com");
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    InputStream inputStream = connection.getInputStream();
                    Log.i(TAG, "sendRequest: InputStream");
                    //读取输入流
                    reader = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        Log.i(TAG, "sendRequest: " + line);
                        response.append(line);
                    }
                    showResponse(response.toString());
                    //showResponse(response.toString());
                } catch (Exception e) {
                    //e.printStackTrace();
                    Log.e(TAG, "sendRequest: " + e.toString());
                    e.printStackTrace();
                } finally {
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException e) {
                            //e.printStackTrace();
                            Log.e(TAG, "sendRequest reader: " + e.getMessage());
                        }
                    }
                    if (connection != null) {
                        connection.disconnect();
                    }
                }
            }
        }).start();
    }

    private void showResponse(final String response) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                responseText.setText(response);
            }
        });
    }
}
