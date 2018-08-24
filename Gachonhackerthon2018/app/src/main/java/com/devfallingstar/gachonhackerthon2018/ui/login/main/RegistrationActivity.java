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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity{
    EditText txtName, txtId, txtPw;
    Button regist_btn;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        txtName = findViewById(R.id.regist_name);
        txtId = findViewById(R.id.regist_id);
        txtPw = findViewById(R.id.regist_pw);
        regist_btn = findViewById(R.id.regist_btn);
        firebaseAuth = FirebaseAuth.getInstance();

        regist_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnRegistration(v);
            }
        });
    }
    public void btnRegistration(View v){
        final ProgressDialog progressDialog = ProgressDialog.show(RegistrationActivity.this, "wait", "Progressing", true);
        firebaseAuth.createUserWithEmailAndPassword(txtId.getText().toString(), txtPw.getText().toString()).
                addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if(task.isSuccessful()){
                            Toast.makeText(RegistrationActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(RegistrationActivity.this, LoginWithEmailActivity.class);
                            startActivity(i);
                        }
                        else{
                            Log.e("Error",task.getException().toString());
                            Toast.makeText(RegistrationActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
