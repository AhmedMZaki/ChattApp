package com.example.ahmedassem.chattapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button login;
    private EditText username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setid();
        activitySwitcher();
    }

    /* set Id for layouts Componants */
    private void setid()
    {
        login = findViewById(R.id.login);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
    }

    /* Move to next activity/fragments */
    private void activitySwitcher()
    {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, chatcontent.class);
                startActivity(intent);
            }
        });
    }

    /* Check if username& password edittext is empty */
    private void checkemptytexts()
    {
        if(username.getText().toString().trim().isEmpty())
        {
            username.setText("Enter your Email");
        }
        else if(password.getText().toString().trim().isEmpty())
        {
            password.setText("Enter your Password");
        }
    }
}
