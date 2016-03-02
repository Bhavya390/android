package com.example.suchi.registration_form;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Suchi on 1/29/2016.
 */
public class MainActivity3  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_message);
        TextView t= (TextView) findViewById(R.id.textView);
        t.setText(getIntent().getExtras().getString("Content"));


    }


};