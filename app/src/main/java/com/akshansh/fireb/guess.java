package com.akshansh.fireb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class guess extends AppCompatActivity {
    int randomnumber;
    Random r;

    public void numclick(View view) {
        EditText number = findViewById(R.id.numtext);
        int num = Integer.parseInt(number.getText().toString());
        if (num == randomnumber) {
            Toast.makeText(this, "NUMBER IS CORRECT", Toast.LENGTH_SHORT).show();
            r = new Random();
            randomnumber = r.nextInt(3) + 1;
            Toast.makeText(this, "New game started", Toast.LENGTH_SHORT).show();
        } else if (num > randomnumber) {
            Toast.makeText(this, "NUMBER IS GREATER", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "NUMBER IS SMALLER", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess);
    }
}
