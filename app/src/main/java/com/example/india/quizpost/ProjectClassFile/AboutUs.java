package com.example.india.quizpost.ProjectClassFile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.TextView;

import com.example.india.quizpost.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AboutUs extends AppCompatActivity {
    /** ButterKnife Code **/
    @BindView(R.id.toolbar)
    android.support.v7.widget.Toolbar toolbar;
    @BindView(R.id.arrowback)
    TextView arrowback;
    /** ButterKnife Code **/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        ButterKnife.bind(this);


    }


    @OnClick(R.id.arrowback)
    void arrow(){
        Intent abc=new Intent(AboutUs.this,DashboardNav.class);
        startActivity(abc);
    }

}