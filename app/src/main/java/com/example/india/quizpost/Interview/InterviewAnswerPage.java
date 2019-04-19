package com.example.india.quizpost.Interview;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.india.quizpost.R;
import com.example.india.quizpost.utilities.SessionManager;

public class InterviewAnswerPage extends AppCompatActivity {
    TextView describe;
    TextView quesview;
    SessionManager sessionManager;
    SwipeRefreshLayout Swipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interview_answer_page);
        describe = findViewById(R.id.describe);
        quesview=findViewById(R.id.quesview);
        Swipe=findViewById(R.id.Swipe);
       /* Swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Swipe.setRefreshing(true);



                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Swipe.setRefreshing(false);
                    }
                },2500);
            }
        });*/
        SessionManager sessionManager=new SessionManager(this) ;

        describe.setText(sessionManager.getString("answer"));
        quesview.setText(sessionManager.getString("question"));


    }
}
