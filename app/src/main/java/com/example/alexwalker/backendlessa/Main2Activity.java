package com.example.alexwalker.backendlessa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.async.callback.BackendlessCallback;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final EditText annTextView = (EditText)findViewById(R.id.annTextView);
        final Button sendButton = (Button)findViewById(R.id.sendButton);
        final Button showButton = (Button)findViewById(R.id.showButton);

        Intent intent = getIntent();
        final String userEmail = intent.getStringExtra("userEmail");


        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Backendless.Persistence.save(new Announcement(annTextView.getText().toString(), userEmail), new BackendlessCallback<Announcement>() {
                    @Override
                    public void handleResponse(Announcement announcement) {
                        Toast.makeText(getApplicationContext(), "Announcement declared", Toast.LENGTH_LONG).show();
                    }
                });

            }
        });

        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Main2Activity.this, Main3Activity.class);
                startActivity(intent1);
            }
        });



    }
}
