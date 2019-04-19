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
import com.example.india.quizpost.Api_Response.GroupDInterview;
import com.example.india.quizpost.Api_Response.InterviewQuestionResponse;
import com.example.india.quizpost.R;
import com.example.india.quizpost.utilities.SessionManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GroupGd extends AppCompatActivity {
    RecyclerView recycleview;
    ApiInterface apiInterface;
    GdAdapter GdAdapter;
    List<GroupDInterview.User> responses;
    SessionManager sessionManager;
    SwipeRefreshLayout Swipe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_gd);
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
        Call<GroupDInterview> responseCall=apiInterface.gd("discuss");
        responseCall.enqueue(new Callback<GroupDInterview>() {
            @Override
            public void onResponse(Call<GroupDInterview> call, Response<GroupDInterview> response) {

                responses =response.body().getUsers();
                recycleview.setHasFixedSize(true);
                recycleview.setLayoutManager(new LinearLayoutManager(GroupGd.this));
                GdAdapter =new GdAdapter(GroupGd.this,(ArrayList<GroupDInterview.User>)responses);
                recycleview.setAdapter(GdAdapter);
            }

            @Override
            public void onFailure(Call<GroupDInterview> call, Throwable t) {
                Toast.makeText(GroupGd.this,t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
}}

