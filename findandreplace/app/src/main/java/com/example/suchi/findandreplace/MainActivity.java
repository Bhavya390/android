package com.example.suchi.findandreplace;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void findreplace(View v){
        String s1, s2,s3,s4;
        EditText e1 = (EditText)findViewById(R.id.string);
        e1.setEnabled(true);
        EditText e2 = (EditText)findViewById(R.id.find);
        e2.setEnabled(true);
        EditText e3 = (EditText)findViewById(R.id.replace);
        e3.setEnabled(true);
        Button b = (Button)findViewById(R.id.button);
        s1=e1.getText().toString();
        s2=e2.getText().toString();
        s3=e3.getText().toString();
        int i= s1.indexOf(s2);
        if(i == -1){
            Toast toast = Toast.makeText(getApplicationContext(),"String is not found",Toast.LENGTH_SHORT);
            toast.show();
        }
        else{
            s4=s1.replaceAll(s2, s3);
            NotificationCompat.Builder mybuilder = new NotificationCompat.Builder(this).setSmallIcon(R.drawable.abc).setContentTitle("About string").setContentText("String is replaced");
            Intent resultIntent = new Intent(this, displayclass.class);
            resultIntent.putExtra("newsting",s4);
// The stack builder object will contain an artificial back stack for the
// started Activity.
// This ensures that navigating backward from the Activity leads out of
// your application to the Home screen.
            TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
// Adds the back stack for the Intent (but not the Intent itself)
            stackBuilder.addParentStack(displayclass.class);
// Adds the Intent that starts the Activity to the top of the stack
            stackBuilder.addNextIntent(resultIntent);
            PendingIntent resultPendingIntent =
                    stackBuilder.getPendingIntent(
                            0,
                            PendingIntent.FLAG_UPDATE_CURRENT
                    );
            NotificationCompat.Builder builder = mybuilder.setContentIntent(resultPendingIntent);
            NotificationManager mNotificationManager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
// mId allows you to update the notification later on.
            int mId = 1;
            mNotificationManager.notify(mId, mybuilder.build());
        }

    }
}
