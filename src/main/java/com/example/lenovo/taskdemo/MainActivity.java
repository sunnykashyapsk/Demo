package com.example.lenovo.taskdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button login;
    private EditText editText1,editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // getSupportActionBar().hide();

        login=findViewById(R.id.button);
        editText1=findViewById(R.id.user);
        editText2=findViewById(R.id.pass);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uemail= editText1.getText().toString();
                String upass=editText2.getText().toString();

                if((uemail.equals("Sunny")) && (upass.equals("pass"))) {
                    startActivity(new Intent(MainActivity.this, navigation.class));
                    overridePendingTransition(R.anim.animactivitity1,R.anim.animactivity2);
                }
                else {
                    Toast.makeText(MainActivity.this,"Login Failed",Toast.LENGTH_SHORT).show();
                }
                }

        });
    }
}
