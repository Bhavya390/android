package com.example.suchi.findandreplace;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Suchi on 2/23/2016.
 */

public class displayclass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.displaymessage);
        TextView t= (TextView) findViewById(R.id.textView);
        t.setText(getIntent().getExtras().getString("newsting"));
    }

};