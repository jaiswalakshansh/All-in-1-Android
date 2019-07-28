package com.akshansh.fireb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth mauth;
    public void sign(View view){
        Intent intent = new Intent(MainActivity.this, signup.class);
        startActivity(intent);
    }

    public void log(View view){
        EditText inputEmail=findViewById(R.id.logintext);
        EditText inputPaassword=findViewById(R.id.pastxt);

        String email =inputEmail.getText().toString().trim();
        String password =inputPaassword.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(getApplicationContext(), "ENTER EMAIL", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(getApplicationContext(), "ENTER PASSWORD", Toast.LENGTH_SHORT).show();
            return;
        }

        if(password.length()<6){
            Toast.makeText(getApplicationContext(), "Enter valid length", Toast.LENGTH_SHORT).show();
            return;
        }

        mauth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Intent intent=new Intent(MainActivity.this,dashboard.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this, "INVALID CREDENTIALS", Toast.LENGTH_SHORT).show();
                }
                }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mauth=FirebaseAuth.getInstance();
    }
}
