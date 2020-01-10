package com.hzskfzx.demo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class FragmentMainActivity extends AppCompatActivity implements View.OnClickListener {

    String TAG="Tag";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_main);
//        //载入右侧碎片
//        replaceFragment(new RightFragment());
//
//        Button button=findViewById(R.id.btnLF);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                replaceFragment(new AnotherRightFragment());
//            }
//        });
        Button button=findViewById(R.id.btnLF);
        button.setOnClickListener(this);
        replaceFragment(new RightFragment());
    }

    private void replaceFragment(Fragment fragment) {
        Log.d(TAG, "replaceFragment ");
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.right_fragment, fragment);
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLF:
                Log.d(TAG, "onClickLF");
                replaceFragment(new AnotherRightFragment());
                break;
            default:
                break;
        }
    }
}
