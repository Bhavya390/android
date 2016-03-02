package com.example.suchi.registration_form;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bhavya on 1/29/2016.
 */
public class MainActivity2 extends Activity implements OnItemSelectedListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        Spinner spinner = (Spinner)findViewById(R.id.dept);
        spinner.setOnItemSelectedListener(this);
        List<String> categories = new ArrayList<String>();
        
        categories.add("CSE");
        categories.add("ECE");
        categories.add("PROD");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    public void send(View v){
        Toast.makeText(MainActivity2.this,"Registred", Toast.LENGTH_SHORT).show();
        String s1, s2, s3, s4, s;
        EditText name= (EditText)findViewById(R.id.name);
       s1=  name.getText().toString();
        EditText rollno= (EditText)findViewById(R.id.rollno);
        s2=  rollno.getText().toString();
        Spinner spinner = (Spinner)findViewById(R.id.dept);
        s3 = spinner.getSelectedItem().toString();
        //EditText dept= (EditText)findViewById(R.id.dept);
       // s3=  dept.getText().toString();
        EditText degree= (EditText)findViewById(R.id.degree);
        s4=  degree.getText().toString();
        s= "Name: "+s1+"\n"+"Rollno: "+s2+"\n"+"Department: "+s3+"\n"+"Degree: "+s4;
        Intent i= new Intent(MainActivity2.this, MainActivity3.class);
        i.putExtra("Content",s);
        startActivity(i);
        //Toast.makeText(MainActivity2.this,s1+"\n"+s2+"\n"+s3+"\n"+s4, Toast.LENGTH_SHORT).show();
    }
};
