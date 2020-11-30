package com.example.drivesafe1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class OwnerSignUp extends AppCompatActivity {

    public TextInputLayout ownerName,vehicleRegNo,vehicleChassiNo,emailAdd,phoneNo,password,conPassword;
    public EditText ownerName1,vehicleRegNo1,vehicleChassiNo1,emailAdd1,phoneNo1,password1,conPassword1;
    public Button submit,login;
    public String TAG;

    private FirebaseAuth mAuth;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_sign_up);



        mAuth = FirebaseAuth.getInstance();


        // Read from the database

        ownerName = findViewById(R.id.til_OwnerName);
        vehicleRegNo = findViewById(R.id.til_numPlate);
        vehicleChassiNo = findViewById(R.id.til_ChassiNum);
        emailAdd = findViewById(R.id.til_Email);
        phoneNo = findViewById(R.id.til_phoneNum);
        password = findViewById(R.id.til_password);
        conPassword = findViewById(R.id.til_conPassword);
        submit = findViewById(R.id.b_Submit);
        ownerName1 = findViewById(R.id.til_ownerName1);
        vehicleRegNo1 = findViewById(R.id.til_numPlate1);
        vehicleChassiNo1 = findViewById(R.id.til_ChassiNum1);
        emailAdd1 = findViewById(R.id.til_Email1);
        phoneNo1 = findViewById(R.id.til_phoneNum1);
        password1 = findViewById(R.id.til_password1);
        conPassword1 = findViewById(R.id.til_conPassword1);
        login = findViewById(R.id.b_login);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                final ProgressDialog progressDialog = new ProgressDialog(OwnerSignUp.this);
//                progressDialog.setTitle("Scan your Fingerprint on the Device...");
//                progressDialog.setMessage("Please wait while we verify your Bio-metrics with our Database...");
//                progressDialog.show();

                if (ownerName.getEditText().getText().toString().trim().isEmpty() || ownerName.getEditText().getText().toString().trim().length() > 30) {

                    ownerName.setErrorEnabled(true);
                    ownerName.setError("Invalid Name");
                    ownerName1.setError("Please Enter a Valid Name.");
                    ownerName.requestFocus();

                } else if (vehicleRegNo.getEditText().getText().toString().trim().isEmpty() || vehicleRegNo.getEditText().getText().toString().trim().length() > 10) {

                    vehicleRegNo.setErrorEnabled(true);
                    vehicleRegNo.setError("Invalid Registration No.");
                    vehicleRegNo1.setError("Please Enter a Valid Registration Number.");
                    vehicleRegNo.requestFocus();

                } else if (vehicleChassiNo.getEditText().getText().toString().trim().isEmpty() || vehicleChassiNo.getEditText().getText().toString().trim().length() > 17) {

                    vehicleChassiNo.setErrorEnabled(true);
                    vehicleChassiNo.setError("Invalid Chassi No.");
                    vehicleChassiNo1.setError("Please Enter a Valid chassi Number.");
                    ownerName.requestFocus();

                } else if (emailAdd.getEditText().getText().toString().trim().isEmpty()) {

                    emailAdd.setErrorEnabled(true);
                    emailAdd.setError("Invalid Email");
                    emailAdd1.setError("Please Enter a Valid Email Address.");
                    emailAdd.requestFocus();

                }

                if(phoneNo.getEditText().getText().toString().trim().isEmpty()||phoneNo.getEditText().getText().toString().trim().length()!=10)
                {

                    phoneNo.setErrorEnabled(true);
                    phoneNo.setError("Invalid Name");
                    phoneNo1.setError("Please Enter a Valid Name...");
                    ownerName.requestFocus();

                }

                else if (password.getEditText().getText().toString().trim().isEmpty() || password.getEditText().getText().toString().trim().length() < 6) {

                    password.setErrorEnabled(true);
                    password.setError("Invalid Password");
                    password1.setError("Please Enter a Stronger Password.");
                    password1.setText(null);
                    password.requestFocus();

                } else if (conPassword.getEditText().getText().toString().trim().isEmpty() || !conPassword.getEditText().getText().toString().trim().equals(password.getEditText().getText().toString().trim())) {

                    conPassword.setErrorEnabled(true);
                    conPassword.setError("Incorrect Password");
                    conPassword1.setError("Passwords do not Match!");
                    conPassword1.setText(null);
                    conPassword.requestFocus();

                } else {

                    ownerName.setErrorEnabled(false);
                    vehicleRegNo.setErrorEnabled(false);
                    vehicleChassiNo.setErrorEnabled(false);
                    emailAdd.setErrorEnabled(false);
                    phoneNo.setErrorEnabled(false);
                    password.setErrorEnabled(false);
                    conPassword.setErrorEnabled(false);

                    String email = emailAdd.getEditText().getText().toString().trim();
                    String pass = password.getEditText().getText().toString().trim();

                    mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(OwnerSignUp.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {

                                //progressDialog.dismiss();
                                Intent intent = new Intent(OwnerSignUp.this, OwnerMainActivityMain.class);
                                startActivity(intent);
                                finish();

                            } else {

                                //progressDialog.dismiss();
                                Toast.makeText(OwnerSignUp.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();

                            }


                        }
                    });
                }
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(OwnerSignUp.this,OwnerLogin.class);
                startActivity(intent);
                finish();

            }
        });

    }



}
