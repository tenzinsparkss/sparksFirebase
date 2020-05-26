package com.example.FirebaseApp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private EditText signup_email, signup_pass, signup_confirmPass;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signup_email = findViewById(R.id.signup_email_id);
        signup_pass = findViewById(R.id.signup_pass_id);
        signup_confirmPass = findViewById(R.id.signup_confirmpass_id);

        mAuth = FirebaseAuth.getInstance();

    }

    //signup button click garda yo call huncha
    public void signUp(View view){
        String email = signup_email.getText().toString().trim();
        String password = signup_pass.getText().toString().trim();
        String cPassword = signup_confirmPass.getText().toString().trim();

        if(password.length() < 6) {
            Toast.makeText(this, "Password length is not required meet.", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(password.equals(cPassword)){

            createAccount(email, password);

        }
        else{
            Toast.makeText(this, "Password is not matched.", Toast.LENGTH_SHORT).show();
        }

    }

    private void createAccount(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(MainActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                        } else {
                            // If sign in fails, display a message to the user.

                        }

                        // ...
                    }
                });

    }

//    private void signIn(String email, String password){
//        mAuth.signInWithEmailAndPassword(email, password)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            // Sign in success, update UI with the signed-in user's information
//                            Toast.makeText(MainActivity.this, "Logged in", Toast.LENGTH_SHORT).show();
//                        } else {
//                            // If sign in fails, display a message to the user.
//                            Toast.makeText(MainActivity.this, " Not Logged in", Toast.LENGTH_SHORT).show();
//                        }
//
//                        // ...
//                    }
//                });
//
//    }



}


