package com.hzskfzx.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ArrayViewActivity extends AppCompatActivity {

    private static final String TAG = "ArrayViewActivity";
    String[] data=new String[]{"aa","bb","cc","dd","ee","ff","gg","hh","ii","jj","kk","ll","mm","mm"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_view);
        ListView listView=findViewById(R.id.list);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(ArrayViewActivity.this,android.R.layout.simple_list_item_1,data);
        listView.setAdapter(adapter);
    }
}
