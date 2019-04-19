package com.example.india.quizpost.ProjectClassFile;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.example.india.quizpost.R;
import com.example.india.quizpost.utilities.SessionManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class DashboardNav extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    /** ButterKnife Code **/
    @BindView(R.id.flipper)
    ViewFlipper flipper;

    @BindView(R.id.card_parent)
    android.support.v7.widget.CardView cardParent;

    @BindView(R.id.TutorialCard)
    android.support.v7.widget.CardView TutorialCard;

    @BindView(R.id.QuizCard)
    android.support.v7.widget.CardView QuizCard;

    @BindView(R.id.RecruitmentCard)
    android.support.v7.widget.CardView RecruitmentCard;

    @BindView(R.id.InterviewCard)
    android.support.v7.widget.CardView InterviewCard;

    @BindView(R.id.ResultCard)
    android.support.v7.widget.CardView ResultCard;

    @BindView(R.id.ProfileCard)
    android.support.v7.widget.CardView ProfileCard;

    @BindView(R.id.SettingCard)
    android.support.v7.widget.CardView SettingCard;

    @BindView(R.id.AboutusCard)
    android.support.v7.widget.CardView AboutusCard;



    TextView userName;
    TextView email;
Toolbar toolbar;
ImageView Drawer_Profileimg;
    SessionManager sessionManager;

    /** ButterKnife Code **/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_nav);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        sessionManager = new SessionManager(getApplicationContext());
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Drawer_Profileimg= navigationView.getHeaderView(0).findViewById(R.id.Drawer_Profileimg);

        userName = navigationView.getHeaderView(0).findViewById(R.id.userName);
        email= navigationView.getHeaderView(0).findViewById(R.id.email);


//        String id =  sessionManager.getString("user_id");
//        String user_email =  sessionManager.getString("user_email");
        userName.setText(sessionManager.getString("user_name"));
            email.setText(sessionManager.getString("user_email"));
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer,toolbar,  R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        int images[] ={R.drawable.quizbanner, R.drawable.interviewslide, R.drawable.mobileslide, R.drawable.elearning};

        flipper=(ViewFlipper)findViewById(R.id.flipper);

        for(int i = 0; i< images.length; i++){
            flipperimages(images[i]);
        }

//image show from database
        Glide.with(Drawer_Profileimg)
                .asBitmap()
                .circleCrop()
                .load(sessionManager.getString("user_image"))
                .into(Drawer_Profileimg);

        Log.e("USER DATA", "__" +sessionManager.getString("user_image"));


    }

    public void flipperimages(int image){
        ImageView imageView =new ImageView(this);
        imageView.setBackgroundResource(image);

        flipper.addView(imageView);
        flipper.setFlipInterval(4000);
        flipper.setAutoStart(true);

        flipper.setInAnimation(this,android.R.anim.slide_in_left);
        flipper.setOutAnimation(this,android.R.anim.slide_out_right);


    }








    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard_nav, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }





    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_Home) {
            Intent home=new Intent(DashboardNav.this,DashboardNav.class);
            startActivity(home);
            Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
            // Handle the camera action
        } else if (id == R.id.nav_profile) {
            Intent home=new Intent(DashboardNav.this,User_Profile.class);
            startActivity(home);
            Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_Result) {
            Intent home=new Intent(DashboardNav.this, Result.class);
            startActivity(home);
            Toast.makeText(this, "Result", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_Rating) {
            Intent home=new Intent(DashboardNav.this, Rating_Feedback.class);
            startActivity(home);
            Toast.makeText(this, "Rating", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_Aboutus) {
            Intent home=new Intent(DashboardNav.this, AboutUs.class);
            startActivity(home);
            Toast.makeText(this, "About us", Toast.LENGTH_SHORT).show();

        }
        else if (id == R.id.nav_ContactUs) {
            Intent home=new Intent(DashboardNav.this, Contactus.class);
            startActivity(home);
            Toast.makeText(this, "Contact Us", Toast.LENGTH_SHORT).show();

        }else if (id == R.id.nav_logout) {
            sessionManager.clear();
            Intent intent=new Intent(DashboardNav.this,Login.class);
            startActivity(intent);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @OnClick(R.id.TutorialCard)
    void tutorial(){
        Intent abc = new Intent(getApplicationContext(),TutorialActivity.class);
        startActivity(abc);
    }
    @OnClick(R.id.QuizCard)
    void quizinterview(){
        Intent abc = new Intent(getApplicationContext(),InterviewExam.class);
        startActivity(abc);
    }

    @OnClick(R.id.RecruitmentCard)
    void companyrecruitment(){
        Intent com = new Intent(getApplicationContext(),CompanyRecruitment.class);
        startActivity(com);




    }
    @OnClick(R.id.ResultCard)
    void Result(){
        Intent abc = new Intent(getApplicationContext(),Result.class);
        startActivity(abc);
    }
    @OnClick(R.id.ProfileCard)
    void onClick()
    {

        Intent abc = new Intent(getApplicationContext(),User_Profile.class);
        startActivity(abc);

    }

    @OnClick(R.id.AboutusCard)
    void Aboutcard(){
        Intent abc = new Intent(getApplicationContext(),AboutUs.class);
        startActivity(abc);
    }

    @OnClick(R.id.SettingCard)
    void Contactcard(){
        Intent abc = new Intent(getApplicationContext(),Contactus.class);
        startActivity(abc);
    }

    @OnClick(R.id.InterviewCard)
    void Interview(){
        Intent abc = new Intent(getApplicationContext(),InterviewPreparation.class);
        startActivity(abc);
    }



}
