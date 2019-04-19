package com.example.india.quizpost.ProjectClassFile;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.india.quizpost.Api_Interface.ApiInterface;
import com.example.india.quizpost.Api_Manager.ApiClient;
import com.example.india.quizpost.Api_Response.NormalQuizResponse;
import com.example.india.quizpost.R;
import com.example.india.quizpost.Recycle.ItemModel;
import com.example.india.quizpost.Recycle.NormalQuizAdapter;
import com.example.india.quizpost.Recycle.RecycleAdapter;
import com.example.india.quizpost.utilities.SessionManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;

public class InterviewExam extends AppCompatActivity {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.arrowback)
    TextView arrow;
    @BindView(R.id.Swipe)
    SwipeRefreshLayout Swipe;
    SessionManager sessionManager;

    ApiInterface apiInterface;
    NormalQuizAdapter normalQuizAdapter;
    List<NormalQuizResponse.User>responsess;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interview_exam);
        ButterKnife.bind(this);
        sessionManager = new SessionManager(getApplicationContext());
        getView();
        Swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Swipe.setRefreshing(true);
                getView();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Swipe.setRefreshing(false);
                    }
                }, 2500);
            }
        });


    }
    private void getView(){


        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2) );

        ArrayList<ItemModel> itemModels= new ArrayList<>();
        {
            itemModels.add(new ItemModel(R.drawable.interview,"Silverwing Pvt Ltd","5 days,starting 2000$  | Baraket Travel","Package Name"));
            itemModels.add(new ItemModel(R.drawable.holiday,"Technosoft Pvt Ltd","5 days,starting 2000$  | Baraket Travel","Package Name"));
            itemModels.add(new ItemModel(R.drawable.honey,"Honeymoon","5 days,starting 2000$  | Baraket Travel","Package Name"));
            itemModels.add(new ItemModel(R.drawable.honey,"Honeymoon","5 days,starting 2000$  | Baraket Travel","Package Name"));
            itemModels.add(new ItemModel(R.drawable.honey,"Honeymoon","5 days,starting 2000$  | Baraket Travel","Package Name"));
            itemModels.add(new ItemModel(R.drawable.honey,"Honeymoon","5 days,starting 2000$  | Baraket Travel","Package Name"));


        }
        RecycleAdapter dataAdapter=new RecycleAdapter(this,itemModels);
        recyclerView.setAdapter(dataAdapter);
    }

    @OnClick(R.id.arrowback)
    void arrow(){

        Intent back=new Intent(InterviewExam.this,DashboardNav.class);
        startActivity(back);
    }



    }

