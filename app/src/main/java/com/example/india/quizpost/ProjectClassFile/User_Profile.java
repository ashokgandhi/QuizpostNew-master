package com.example.india.quizpost.ProjectClassFile;

import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.india.quizpost.Api_Interface.ApiInterface;
import com.example.india.quizpost.Api_Response.LoginResponse;
import com.example.india.quizpost.R;
import com.example.india.quizpost.utilities.SessionManager;
import com.google.gson.Gson;
import com.mikhaellopez.circularimageview.CircularImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class User_Profile extends AppCompatActivity {
    /** ButterKnife Code **/
    @BindView(R.id.app_bar_layout)
    android.support.design.widget.AppBarLayout appBarLayout;
    @BindView(R.id.collapsing_toolbar)
    android.support.design.widget.CollapsingToolbarLayout collapsingToolbar;
    @BindView(R.id.image_header)
    ImageView imageHeader;
    @BindView(R.id.toolbar)
    android.support.v7.widget.Toolbar toolbar;
    @BindView(R.id.nested_content)
    android.support.v4.widget.NestedScrollView nestedContent;
    @BindView(R.id.UpdateProfile)
    Button UpdateProfile;
    @BindView(R.id.Profile_Name)
    TextView ProfileName;
    @BindView(R.id.Profile_Email)
    TextView ProfileEmail;
    @BindView(R.id.Profile_EmailId)
    TextView ProfileEmailId;


    @BindView(R.id.CollegeName)
    TextView Collegename;

    @BindView(R.id.Profile_DOB)
    TextView ProfileDOB;
    @BindView(R.id.Profile_phno)
    TextView ProfilePhno;
    @BindView(R.id.Profile_UserLocation)
    TextView Profilelocation;
    @BindView(R.id.Profile_UserGender)
    TextView ProfileGender;
    @BindView(R.id.circular_img)
    com.mikhaellopez.circularimageview.CircularImageView circularImg;
    @BindView(R.id.ShowName)
    TextView ShowName;




    @BindView(R.id.arrowback)
    TextView arrowback;



    LoginResponse Profiledata;

//    ApiInterface apiInterface;
    SessionManager sessionManager;

    /** ButterKnife Code **/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__profile);
        ButterKnife.bind(this);
//        setData();
        sessionManager = new SessionManager(getApplicationContext());

//        String id =  sessionManager.getString("user_id");
//        String user_email =  sessionManager.getString("user_email");
//        String user_date=sessionManager.getString("user_dob");
//        String user_phno=sessionManager.getString("user_phoneno");
//        String user_sex=sessionManager.getString("user_gender");
//        String user_loc=sessionManager.getString("user_location");
//        String user_clg=sessionManager.getString("user_college");

        ShowName.setText(sessionManager.getString("user_name"));
        ProfileName.setText(sessionManager.getString("user_name"));
        ProfileEmailId.setText(sessionManager.getString("user_email"));
        ProfileDOB.setText(sessionManager.getString("user_dob"));
        ProfilePhno.setText(sessionManager.getString("user_phoneno"));
        ProfileGender.setText(sessionManager.getString("user_gender"));
        Profilelocation.setText(sessionManager.getString("user_location"));
        Collegename.setText(sessionManager.getString("user_college"));


//image show using database
        Glide.with(circularImg)
                .asBitmap()
                .circleCrop()
                .load(sessionManager.getString("user_image"))
                .into(circularImg);

        Log.e("USER DATA", "__" +sessionManager.getString("user_image"));


//`DATA", sessionManager.getString("user_college"));
//        initToolbar();
        initComponent();
    }
    @OnClick(R.id.UpdateProfile)
    void UpdateProfile(){


    }

    @OnClick(R.id.arrowback)
    void arrow(){
        Intent arr=new Intent(User_Profile.this,DashboardNav.class);
        startActivity(arr);

    }
   /* public void setData(){
        Gson gson=new Gson();
        String registerData=sessionManager.getKeyValueString("userData");


        Profiledata=gson.fromJson(registerData,LoginResponse.class);


        ProfileName.setText(Profiledata.getName());
    }
*/
  /*  private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }*/

    private void initComponent() {

        ((AppBarLayout) findViewById(R.id.app_bar_layout)).addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                int min_height = ViewCompat.getMinimumHeight(collapsingToolbar) * 2;
                float scale = (float) (min_height + verticalOffset) / min_height;
                circularImg.setScaleX(scale >= 0 ? scale : 0);
                circularImg.setScaleY(scale >= 0 ? scale : 0);
            }
        });
    }
}