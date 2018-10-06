package com.monktree.drozee;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import static android.view.View.SYSTEM_UI_FLAG_FULLSCREEN;
import static android.view.View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
import static android.view.View.SYSTEM_UI_FLAG_IMMERSIVE;
import static android.view.View.SYSTEM_UI_FLAG_LAYOUT_STABLE;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        final View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(SYSTEM_UI_FLAG_FULLSCREEN |SYSTEM_UI_FLAG_LAYOUT_STABLE |SYSTEM_UI_FLAG_IMMERSIVE| SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        setContentView(R.layout.activity_login);
        RelativeLayout relativeLayout = (RelativeLayout)findViewById(R.id.relLayout);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 5s = 5000ms
                        decorView.setSystemUiVisibility(SYSTEM_UI_FLAG_FULLSCREEN |SYSTEM_UI_FLAG_LAYOUT_STABLE |SYSTEM_UI_FLAG_IMMERSIVE | SYSTEM_UI_FLAG_HIDE_NAVIGATION);
                    }
                }, 5000);
            }
        });
        Button loginbtn = (Button)findViewById(R.id.btn_login);
        final EditText usernameET = (EditText)findViewById(R.id.usernameET);
        final EditText passwordET = (EditText)findViewById(R.id.passwordET);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameET.getText().toString();
                String password = passwordET.getText().toString();
                Boolean valid = verifyCred(username,password);
                if(valid)
                {
                    Toast.makeText(getApplicationContext(),"Login Successful for User: " + username + " with Password: " + password,Toast.LENGTH_SHORT).show();
                    //Goto next activity

                }

            }
        });
    }
    private boolean verifyCred(String uname, String pass)
    {
        //Credentials Checking
        return true; //For Now
    }
}
