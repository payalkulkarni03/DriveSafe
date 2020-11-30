package com.example.drivesafe1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class EditPassword extends AppCompatActivity {

    public TextInputLayout til_oldpassword,til_newpassword,til_confirmpassword,til_email;
    public EditText til_oldpassword1,til_newpassword1,til_confirmpassword1,til_email1;
    public Button chngpwdsub;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_password);



        til_oldpassword = findViewById(R.id.til_oldpassword);
        til_oldpassword1 = findViewById(R.id.til_oldpassword1);
        til_newpassword = findViewById(R.id.til_newpassword);
        til_newpassword1 = findViewById(R.id.til_newpassword1);
        til_confirmpassword = findViewById(R.id.til_confirmpassword);
        til_confirmpassword1 = findViewById(R.id.til_confirmpassword1);
        til_email = findViewById(R.id.til_pwdemail);
        til_email1 = findViewById(R.id.til_pwdemail1);
        chngpwdsub = findViewById(R.id.b_changePassword);





    }
}
