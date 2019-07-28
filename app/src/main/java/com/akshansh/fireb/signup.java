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

import com.google.firebase.FirebaseApp;

public class signup extends AppCompatActivity {
    FirebaseAuth auth;
public void back(View view)
{

    Intent intent=new Intent(signup.this,MainActivity.class);
    startActivity(intent);
}
public void signed(View view)
{
    EditText inputEmail=findViewById(R.id.emailtxt);
    EditText inputPaassword=findViewById(R.id.passtxt);
    
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
    
    auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
        @Override
        public void onComplete(@NonNull Task<AuthResult> task) {
            Toast.makeText(signup.this, "User Created Successfully:" + task.isSuccessful(), Toast.LENGTH_LONG).show();
            if (!task.isSuccessful()) {
                Toast.makeText(signup.this, "Authentication failed." + task.getException(),
                        Toast.LENGTH_SHORT).show();
            } else {
                startActivity(new Intent(signup.this, MainActivity.class));
                finish();
            }

        }
    });
        }



        

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        auth=FirebaseAuth.getInstance();
    }
}
