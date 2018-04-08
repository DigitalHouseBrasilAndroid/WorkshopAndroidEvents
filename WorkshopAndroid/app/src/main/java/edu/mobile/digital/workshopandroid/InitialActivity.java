package edu.mobile.digital.workshopandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InitialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initial_activity);
    }

    public void goToEvent(View v) {
        Intent i=new Intent(this,MainActivity.class);
        if(v instanceof Button){
            i.putExtra("event", ((Button) v).getText().toString());
        }
        startActivity(i);
    }
}
