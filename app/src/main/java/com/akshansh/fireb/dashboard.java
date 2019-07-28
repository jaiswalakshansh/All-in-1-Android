package com.akshansh.fireb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class dashboard extends AppCompatActivity {
    public void back(View view){
        Intent intent=new Intent(dashboard.this,MainActivity.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Button btn1=(Button)findViewById(R.id.cbutton);
        Button btn2=(Button)findViewById(R.id.numbutton);
        Button btn3=(Button)findViewById(R.id.gaanabutton);

        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent int1=new Intent(dashboard.this,guess.class);
                startActivity(int1);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent int2=new Intent(dashboard.this,currency.class);
                startActivity(int2);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent int3=new Intent(dashboard.this,gaana.class);
                startActivity(int3);
            }
        });

    }
}
