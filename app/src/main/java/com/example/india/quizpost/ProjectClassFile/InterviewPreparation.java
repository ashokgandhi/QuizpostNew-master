package com.example.india.quizpost.ProjectClassFile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.TextView;

import com.example.india.quizpost.R;
import com.example.india.quizpost.Interview.InterviewAdapter;
import com.example.india.quizpost.Interview.InterviewModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InterviewPreparation extends AppCompatActivity {
    /** ButterKnife Code **/
    @BindView(R.id.toolbarexam)
    android.support.v7.widget.Toolbar toolbarexam;
    @BindView(R.id.arrowback)
    TextView arrowback;
    @BindView(R.id.interviewrecyclerView)
    android.support.v7.widget.RecyclerView interviewrecyclerView;
    /** ButterKnife Code **/



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interview_preparation);
        ButterKnife.bind(this);

        interviewrecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        ArrayList<InterviewModel>interviewModels=new ArrayList<>();
        {
            interviewModels.add(new InterviewModel(R.drawable.jobinterview,"Interview Question Tips"));
            interviewModels.add(new InterviewModel(R.drawable.groupjjob,"Group Discussion Tips"));
            interviewModels.add(new InterviewModel(R.drawable.resume,"Resume Writing Tips"));
        }

        InterviewAdapter dataAdapter=new InterviewAdapter(this,interviewModels);
        interviewrecyclerView.setAdapter(dataAdapter);
    }


//onlclick using butterfly
    @OnClick(R.id.arrowback)
    void back(){
        Intent abc=new Intent(getApplicationContext(),DashboardNav.class);
        startActivity(abc);
    }
    }

