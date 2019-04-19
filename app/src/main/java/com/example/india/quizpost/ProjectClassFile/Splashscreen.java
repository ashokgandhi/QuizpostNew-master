package com.example.india.quizpost.ProjectClassFile;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.india.quizpost.R;
import com.example.india.quizpost.utilities.SessionManager;


public class Splashscreen extends AppCompatActivity {
    ImageView welcomeScreenLogo;
    TextView splashtxt;

    SessionManager sessionManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);
        splashtxt = findViewById(R.id.splashtxt);
        welcomeScreenLogo = findViewById(R.id.welcomeScreenLogo);


        sessionManager = new SessionManager(getApplicationContext());


        welcomeScreenLogo = findViewById(R.id.welcomeScreenLogo);

        Animation splash = AnimationUtils.loadAnimation(this, R.anim.splash);
        welcomeScreenLogo.setAnimation(splash);

        Animation newanim = AnimationUtils.loadAnimation(this, R.anim.newanim);
        splashtxt.setAnimation(newanim);

        Thread Timer = new Thread() {
            public void run() {
                try {
                    sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {

                    if (!sessionManager.getString("user_id").isEmpty()) {
                        Intent intent = new Intent(Splashscreen.this, DashboardNav.class);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(Splashscreen.this, Login.class);
                        startActivity(intent);
                    }

                    finish();

                }
            }
        };

        Timer.start();

    }
}

       /* if (sessionManager.getString("user_id")==null) {

            Intent intent=new Intent(Splashscreen.this,Login.class);
            startActivity(intent);
            finish();
        }
        else {
            startActivity(new Intent(Splashscreen.this, DashboardNav.class));
            finish();
        }
    }*/





