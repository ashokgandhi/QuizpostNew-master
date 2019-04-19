package com.example.india.quizpost.Interview;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.india.quizpost.Api_Interface.ApiInterface;
import com.example.india.quizpost.Api_Manager.ApiClient;
import com.example.india.quizpost.Api_Response.InterviewQuestionResponse;
import com.example.india.quizpost.Api_Response.InterviewResumeResponse;
import com.example.india.quizpost.ProjectClassFile.InterviewPreparation;
import com.example.india.quizpost.R;
import com.example.india.quizpost.utilities.SessionManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResumeTips extends AppCompatActivity {

    RecyclerView resumerecycler;
    ApiInterface apiInterface;
    ResumeAdapter resumeAdapter;
    List<InterviewResumeResponse.User> resumeResponses;
    SessionManager sessionManager;
    TextView arrowback;
    SwipeRefreshLayout Swipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume_tips);
        arrowback = findViewById(R.id.arrowback);
        resumerecycler=findViewById(R.id.resumerecycler);
        sessionManager = new SessionManager(getApplicationContext());
        Swipe = findViewById(R.id.Swipe);

        getview();

        Swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
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
        });

        arrowback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a= new Intent(getApplicationContext(), InterviewPreparation.class);
                startActivity(a);
            }
        });
    }

    private  void getview(){
        apiInterface= ApiClient.createService(ApiInterface.class,"");
        Call<InterviewResumeResponse>responseCall=apiInterface.resume("keyresume1");
        responseCall.enqueue(new Callback<InterviewResumeResponse>() {
            @Override
            public void onResponse(Call<InterviewResumeResponse> call, Response<InterviewResumeResponse> response) {
                if (response.body().getStatus()==1){

                    resumeResponses =response.body().getUsers();
                    resumerecycler.setHasFixedSize(true);
                    resumerecycler.setLayoutManager(new LinearLayoutManager(ResumeTips.this));
                    resumeAdapter =new ResumeAdapter(ResumeTips.this,(ArrayList<InterviewResumeResponse.User>)resumeResponses);
                    resumerecycler.setAdapter(resumeAdapter);
                }
            }

            @Override
            public void onFailure(Call<InterviewResumeResponse> call, Throwable t) {
                Toast.makeText(ResumeTips.this,t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

}
