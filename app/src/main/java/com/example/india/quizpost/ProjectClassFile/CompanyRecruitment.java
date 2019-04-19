package com.example.india.quizpost.ProjectClassFile;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.india.quizpost.Recycle.CyclerAdapter;
import com.example.india.quizpost.Api_Interface.ApiInterface;
import com.example.india.quizpost.Api_Manager.ApiClient;
import com.example.india.quizpost.Api_Response.CompanyResponse;
import com.example.india.quizpost.R;
import com.example.india.quizpost.utilities.SessionManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CompanyRecruitment extends AppCompatActivity {
    RecyclerView recycler;
    ApiInterface apiInterface;
    CyclerAdapter cyclerAdapter;
    List<CompanyResponse.User>responses;

@BindView(R.id.arrowbacked)
    TextView arrowbacked;


@BindView(R.id.Swipe)
    SwipeRefreshLayout Swipe;

    SessionManager sessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_recruitment);
        ButterKnife.bind(this);
        recycler=findViewById(R.id.recycler);
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
             },2500);
         }
     });




    }
    @OnClick(R.id.arrowbacked)
    void arrowbacked(){
        Intent intent=new Intent(CompanyRecruitment.this,DashboardNav.class);
        startActivity(intent);
    }

    private void getView() {
    apiInterface =ApiClient.createService(ApiInterface.class,"");
     final Call<CompanyResponse>companyResponseCall=apiInterface.company("view1");
     companyResponseCall.enqueue(new Callback<CompanyResponse>() {
         @Override
         public void onResponse(Call<CompanyResponse> call, Response<CompanyResponse>response) {
             if (response.body().getStatus()==1){


                 responses=response.body().getUsers();
                 recycler.setHasFixedSize(true);
                 recycler.setLayoutManager(new LinearLayoutManager(CompanyRecruitment.this));
                 cyclerAdapter=new CyclerAdapter(CompanyRecruitment.this,(ArrayList<CompanyResponse.User>)responses);
                 recycler.setAdapter(cyclerAdapter);

             }
         }


         @Override
         public void onFailure(Call<CompanyResponse> call, Throwable t) {
             Toast.makeText(CompanyRecruitment.this, t.getMessage(), Toast.LENGTH_SHORT).show();
         }
     });


    }


}
