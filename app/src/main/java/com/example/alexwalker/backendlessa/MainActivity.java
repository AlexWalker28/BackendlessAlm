package com.example.alexwalker.backendlessa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.async.callback.BackendlessCallback;
import com.backendless.exceptions.BackendlessException;
import com.backendless.exceptions.BackendlessFault;

public class MainActivity extends AppCompatActivity {

    BackendlessUser user = new BackendlessUser();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String appVersion = "v1";
        Backendless.initApp(this, "84699694-079F-E281-FFC6-0A251E47C500", "2E0782F0-954C-C2F3-FF8E-0622827A1700", appVersion);

        final EditText emailForm = (EditText) findViewById(R.id.emailForm);
        final EditText pasForm = (EditText) findViewById(R.id.pasForm);
        final Button regButton = (Button) findViewById(R.id.regButton);
        final Button logInButton = (Button)findViewById(R.id.logInButton);


        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                user.setEmail(emailForm.getText().toString());
                user.setPassword(pasForm.getText().toString());

                Backendless.UserService.register(user, new BackendlessCallback<BackendlessUser>() {
                    @Override
                    public void handleResponse(final BackendlessUser backendlessUser) {

                    }
                });
                Toast.makeText(getApplicationContext(), "Succesfully registered", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("userEmail", user.getEmail());
                startActivity(intent);

            }
        });


               logInButton.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       Backendless.UserService.login(emailForm.getText().toString(), pasForm.getText().toString(), new AsyncCallback<BackendlessUser>() {
                           @Override
                           public void handleResponse(BackendlessUser backendlessUser) {
                               Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                               startActivity(intent);
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
