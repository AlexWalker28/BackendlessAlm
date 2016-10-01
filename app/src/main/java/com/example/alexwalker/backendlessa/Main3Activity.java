package com.example.alexwalker.backendlessa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

public class Main3Activity extends AppCompatActivity {

    Announcement content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        final TextView showAnn = (TextView)findViewById(R.id.showAnn);
        Button showButton = (Button)findViewById(R.id.showAnnButton);

        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*Backendless.Persistence.of(Announcement.class).findLast(new AsyncCallback<Announcement>() {
                    @Override
                    public void handleResponse(Announcement announcement) {
                        showAnn.setText(announcement.getAnnText());
                    }

                    @Override
                    public void handleFault(BackendlessFault backendlessFault) {
                        Toast.makeText(getApplicationContext(), "Didn't work", Toast.LENGTH_LONG).show();
                    }
                });*/

                Backendless.Persistence.of(Announcement.class).find(new AsyncCallback<BackendlessCollection<Announcement>>() {
                    @Override
                    public void handleResponse(BackendlessCollection<Announcement> announcementBackendlessCollection) {
                        int size = announcementBackendlessCollection.getData().size();
                        for(int i = 0; i < size; i++){
                            content = announcementBackendlessCollection.getData().get(i);
                            showAnn.append("\n" + content.getAnnText());

                        }
                    }

                    @Override
                    public void handleFault(BackendlessFault backendlessFault) {
                        Toast.makeText(getApplicationContext(), "Didn't work", Toast.LENGTH_LONG).show();
                    }
                });


            }
        });




    }


}
