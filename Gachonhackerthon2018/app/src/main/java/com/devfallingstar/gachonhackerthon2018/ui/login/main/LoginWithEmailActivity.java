package com.devfallingstar.gachonhackerthon2018.ui.login.main;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.devfallingstar.gachonhackerthon2018.R;
import com.devfallingstar.gachonhackerthon2018.ui.home.main.HomeActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LoginWithEmailActivity extends AppCompatActivity {
    EditText login_id, login_pw;
    Button login_btn, signup_btn;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login_id = findViewById(R.id.edittext_id);
        login_pw = findViewById(R.id.edittext_pw);
        login_btn = findViewById(R.id.btn_logIn);
        signup_btn = findViewById(R.id.btn_emailSignUp);
        firebaseAuth = FirebaseAuth.getInstance();

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserLoginClicked(v);
            }
        });
        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginWithEmailActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });
    }
    public void UserLoginClicked(View v){
        final ProgressDialog progressDialog= ProgressDialog.show(LoginWithEmailActivity.this, "wait", "progressing", true);
        firebaseAuth.signInWithEmailAndPassword(login_id.getText().toString(), login_pw.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                if(task.isSuccessful()){
                    Toast.makeText(LoginWithEmailActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(LoginWithEmailActivity.this, HomeActivity.class);
                    startActivity(i);
                }else{
                    Log.e("Error", task.getException().toString());
                    Toast.makeText(LoginWithEmailActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
