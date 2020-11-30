package com.example.drivesafe1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class OwnerLogin extends AppCompatActivity {

    public TextInputLayout ownerEmail,ownerPassword;
    public EditText ownerEmail1,ownerPassword1;
    public Button ownerLogin,ownerSignup;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_login);

        firebaseAuth = FirebaseAuth.getInstance();

        ownerEmail = findViewById(R.id.til_ownerEmail);
        ownerEmail1 = findViewById(R.id.til_ownerEmail1);
        ownerPassword = findViewById(R.id.til_ownerPassword);
        ownerPassword1 = findViewById(R.id.til_ownerPassword1);
        ownerLogin = findViewById(R.id.b_ownerlogin);
       ownerSignup = findViewById(R.id.b_ownerSignup);

        ownerSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(OwnerLogin.this,OwnerSignUp.class);
                startActivity(intent);
                finish();

            }
        });

        ownerLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ownerEmail.getEditText().getText().toString().trim().isEmpty())
                {

                    ownerEmail.setErrorEnabled(true);
                    ownerEmail.setError("Invalid Email Address");
                    ownerEmail1.setError("This field should not be empty!");
                    ownerEmail.requestFocus();

                }

                else if(ownerPassword.getEditText().getText().toString().trim().isEmpty())
                {

                    ownerPassword.setErrorEnabled(true);
                    ownerPassword.setError("Invalid Password");
                    ownerPassword1.setError("This field should not be empty!");
                    ownerPassword1.setText(null);
                    ownerEmail.requestFocus();

                }

                else {

                    final ProgressDialog progressDialog = new ProgressDialog(OwnerLogin.this);
                    progressDialog.setTitle("Logging In.");
                    progressDialog.setMessage("Please wait while we verify your credentials.");
                    progressDialog.show();

                    ownerEmail.setErrorEnabled(false);
                    ownerPassword.setErrorEnabled(false);

                    String owneremail = ownerEmail.getEditText().getText().toString();
                    String ownerpwd = ownerPassword.getEditText().getText().toString();

                    firebaseAuth.signInWithEmailAndPassword(owneremail,ownerpwd).addOnCompleteListener(OwnerLogin.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if(task.isSuccessful())
                            {

                                progressDialog.dismiss();
                                Intent intent = new Intent(OwnerLogin.this,OwnerMainActivityMain.class);
                                startActivity(intent);
                                finish();

                            }
                            else
                            {

                                progressDialog.dismiss();
                                Toast.makeText(OwnerLogin.this,"Please check your Credentials or Internet Connection!",Toast.LENGTH_LONG).show();

                            }

                        }
                    });


                }

            }
        });

    }



}
