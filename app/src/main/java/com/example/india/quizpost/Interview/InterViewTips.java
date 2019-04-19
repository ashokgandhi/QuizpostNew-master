package com.example.india.quizpost.Interview;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.india.quizpost.Api_Interface.ApiInterface;
import com.example.india.quizpost.Api_Manager.ApiClient;
import com.example.india.quizpost.Api_Response.InterviewQuestionResponse;
import com.example.india.quizpost.R;
import com.example.india.quizpost.utilities.SessionManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InterViewTips extends AppCompatActivity {
    RecyclerView recycleview;
    ApiInterface apiInterface;
    QuestionAdapter questionAdapter;
    List<InterviewQuestionResponse.User> responses;
    SessionManager sessionManager;
    SwipeRefreshLayout Swipe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inter_view_tips);
        sessionManager= new SessionManager(getApplicationContext());
        Swipe=findViewById(R.id.Swipe);
        recycleview=findViewById(R.id.recycleview);
        getview();

        Swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Swipe.setRefreshing(true);
                    getview();


                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Swipe.setRefreshing(false);
                    }
                },2500);
            }
        });

    }
    private void getview() {
        apiInterface = ApiClient.createService(ApiInterface.class,"");
        Call<InterviewQuestionResponse> responseCall=apiInterface.ques("view1");
            responseCall.enqueue(new Callback<InterviewQuestionResponse>() {
                @Override
                public void onResponse(Call<InterviewQuestionResponse> call, Response<InterviewQuestionResponse> response) {
                    if (response.body().getStatus()==1);


                    responses =response.body().getUsers();
                    recycleview.setHasFixedSize(true);
                    recycleview.setLayoutManager(new LinearLayoutManager(InterViewTips.this));
                    questionAdapter =new QuestionAdapter(InterViewTips.this,(ArrayList<InterviewQuestionResponse.User>)responses);
                    recycleview.setAdapter(questionAdapter);
                }


                @Override
                public void onFailure(Call<InterviewQuestionResponse> call, Throwable t) {

            Toast.makeText(InterViewTips.this,t.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
}
}
