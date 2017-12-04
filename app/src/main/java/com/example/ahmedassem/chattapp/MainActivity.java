package com.example.ahmedassem.chattapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private Button login;
    private EditText username, password;
    private TextView errortext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setid();
        activitySwitcher();
    }

    /* set Id for layouts Componants */
    private void setid() {
        login = findViewById(R.id.login);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        errortext = findViewById(R.id.error);
    }

    /* Move to next activity/fragments */
    private void activitySwitcher() {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //checkemptytexts();
                Intent intent=new Intent(MainActivity.this,Navigation.class);
                startActivity(intent);

            }
        });
    }

    /* Check if username& password edittext is empty */
    /*private void checkemptytexts()
    {
        if(username.getText().toString().trim().isEmpty())
        {
            username.setHint("Enter your Email");
            return;
        }
        else if(password.getText().toString().trim().isEmpty())
        {
            password.setHint("Enter your Password");
            return;
        }
        else
        {
            RequestQueue queue = Volley.newRequestQueue(this);
            String url = "http://system.abdelsadek.me/api/login";
            StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>()
                    {
                        @Override
                        public void onResponse(String response) {
                            // response
                            Log.d("Response", response);
                            if(response.equals("{\"error\":{\"isClean\":false,\"code\":-1,\"description\":\"These credentials do not match our records.\"}}"))
                            {
                                errortext.setText("Invalid username or password");
                                username.setText ("");
                                password.setText("");
                            }
                            else
                            {
                                Intent intent=new Intent(MainActivity.this,chatcontent.class);
                                startActivity(intent);
                            }
                        }
                    },
                    new Response.ErrorListener()
                    {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // error
                        }
                    }
            ) {
                @Override
                protected Map<String, String> getParams()
                {         // Adding parameters
                    Map<String, String>  params = new HashMap<String, String>();
                    params.put("mobile_number",username.getText().toString());
                    params.put("password", password.getText().toString());
                    return params;
                }
            };
            queue.add(postRequest);
        }
    }*/
}
