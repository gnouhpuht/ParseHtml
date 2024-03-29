package com.t3h.parsehtml;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.t3h.parsehtml.motherchild.HomeFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.content, new HomeFragment(),
                        HomeFragment.class.getName())
                .commit();
    }
}
