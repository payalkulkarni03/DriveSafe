package com.example.drivesafe1;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UserLogin extends AppCompatActivity {

    public TextInputLayout userName,userEmail,userPhone;
    public EditText userName1,userEmail1,userPhone1;
    public Button userSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        userName = findViewById(R.id.til_userName);
        userName1 = findViewById(R.id.til_userName1);
        userEmail = findViewById(R.id.til_userEmail);
        userEmail1 = findViewById(R.id.til_userEmail1);
        userPhone = findViewById(R.id.til_userPhone);
        userPhone1 = findViewById(R.id.til_userPhone1);
        userSubmit = findViewById(R.id.b_userSubmit);

        userSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ProgressDialog progressDialog = new ProgressDialog(UserLogin.this);
                progressDialog.setTitle("Scan your Fingerprint on the Device...");
                progressDialog.setMessage("Please wait while we verify your Bio-metrics with our Database...");
                progressDialog.show();

            }
        });

    }
}
