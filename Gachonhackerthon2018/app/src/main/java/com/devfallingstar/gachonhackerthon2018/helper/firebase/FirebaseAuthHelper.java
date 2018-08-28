package com.devfallingstar.gachonhackerthon2018.helper.firebase;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.devfallingstar.gachonhackerthon2018.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

@SuppressLint("Registered")
public class FirebaseAuthHelper extends Activity {
    private static final String TAG = "FirebaseAuthHelper";
    private Context parentContext;

    /* Variables for E-mail login */
    private FirebaseAuth mAuth;
    FirebaseUser currentUser;

    /* variables for Gmail login */
    GoogleSignInOptions gso;
    GoogleSignInClient mGoogleSignInClient;

    public FirebaseAuthHelper(Context _context) {
//        parentContext = _context;
//
//        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestIdToken(parentContext.getResources().getString(R.string.default_web_client_id))
//                .requestEmail()
//                .build();
//        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
//
        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("ASDFASDF", "QQWEEER");
    }

    public boolean createUserWithEmailAndPassword(String email, String password) {
        final boolean[] isCreated = {false};
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(parentContext, "Created account with Email and Password", Toast.LENGTH_SHORT).show();
                            currentUser = mAuth.getCurrentUser();
                            isCreated[0] = true;
                        }else {
                            Toast.makeText(parentContext, "Failed to create account with Email and Password", Toast.LENGTH_SHORT).show();
                            currentUser = null;
                            isCreated[0] = false;
                        }
                    }
                });

        return isCreated[0];
    }

    public void loginWithGoogle(GoogleSignInAccount acct) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(parentContext, "Authentication success.",
                                    Toast.LENGTH_SHORT).show();
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
//                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            Toast.makeText(parentContext, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
//                            updateUI(null);
                        }

                        // ...
                    }
                });
    }


    public boolean loginWithEmailAndPassword(String email, String password) {
        final boolean[] isLogin = {false};
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(parentContext, "Login with Email and Password", Toast.LENGTH_SHORT).show();
                            currentUser = mAuth.getCurrentUser();
                            isLogin[0] = true;
                        }else {
                            Toast.makeText(parentContext, "Fail to login with Email and Password", Toast.LENGTH_SHORT).show();
                            currentUser = null;
                            isLogin[0] = true;
                        }
                    }
                });
        return isLogin[0];
    }

    public GoogleSignInClient getmGoogleSignInClient() {
        return mGoogleSignInClient;
    }
}
