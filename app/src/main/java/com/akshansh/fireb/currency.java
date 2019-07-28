package com.akshansh.fireb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class currency extends AppCompatActivity {

    public void butn(View view)
    {
        EditText num=findViewById(R.id.editText);
        Double num1 =Double.parseDouble(num.getText().toString());
        Double result=num1*66;
        Toast.makeText(currency.this, "₹" +result.toString(), Toast.LENGTH_SHORT).show();    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);
    }
}
