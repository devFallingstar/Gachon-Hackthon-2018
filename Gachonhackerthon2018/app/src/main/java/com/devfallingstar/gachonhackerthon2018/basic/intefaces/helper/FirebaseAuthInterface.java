package com.devfallingstar.gachonhackerthon2018.basic.intefaces.helper;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

public interface FirebaseAuthInterface {
    boolean createUserWithEmailAndPassword(String email, String password);
    void loginWithGoogle(GoogleSignInAccount acct);
    boolean loginWithEmailAndPassword(String email, String password);
}
