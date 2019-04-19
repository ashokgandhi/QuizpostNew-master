package com.example.india.quizpost.ProjectClassFile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.india.quizpost.Api_Interface.ApiInterface;
import com.example.india.quizpost.Api_Interface.testInterface;
import com.example.india.quizpost.Api_Manager.ApiClient;
import com.example.india.quizpost.Api_Response.QuizPlayResponse;
import com.example.india.quizpost.R;
import com.example.india.quizpost.utilities.SessionManager;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class QuizPlay extends AppCompatActivity implements testInterface {

    testInterface interfaceObj;
    /** ButterKnife Code **/
    @BindView(R.id.toolbar)
    android.support.v7.widget.Toolbar toolbar;
    @BindView(R.id.Question)
    TextView Question;
    @BindView(R.id.QuizQuestionCount)
    TextView QuizQuestionCount;
    @BindView(R.id.QuizQuesSkip)
    TextView QuizQuesSkip;
    @BindView(R.id.QuizQuesSkipCount)
    TextView QuizQuesSkipCount;
    @BindView(R.id.QuizQuestion)
    TextView QuizQuestion;
    @BindView(R.id.QuizImageShow)
    ImageView QuizImageShow;
    @BindView(R.id.AnswerOptions)
    RadioGroup AnswerOptions;
    @BindView(R.id.OPtionA)
    RadioButton OPtionA;
    @BindView(R.id.OPtionB)
    RadioButton OPtionB;
    @BindView(R.id.OPtionC)
    RadioButton OPtionC;
    @BindView(R.id.OPtionD)
    RadioButton OPtionD;
    @BindView(R.id.ButtonSubmit)
    Button ButtonSubmit;
    @BindView(R.id.ButtonSkip)
    Button ButtonSkip;
    @BindView(R.id.ButtonNext)
    Button ButtonNext;
    /** ButterKnife Code **/

    Response<QuizPlayResponse> Response;
    int score =0;

ApiInterface apiInterface;
    int ans;

    int count = 0;

SessionManager sessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        interfaceObj=this;
        setContentView(R.layout.activity_quiz_play);
        ButterKnife.bind(this);
        sessionManager=new SessionManager(this);
            play();

    }
// call kon krega
    private void play(){

    apiInterface = ApiClient.createService(ApiInterface .class,"");
    Call<QuizPlayResponse> quizPlayResponseCall=apiInterface.onlineresponse(200);

       quizPlayResponseCall .enqueue(new Callback<QuizPlayResponse>() {
           @Override
           public void onResponse(Call<QuizPlayResponse> call, Response<QuizPlayResponse> response) {
             Response=response;
               Log.e("Responce---",response.body().toString());
               ArrayList<QuizPlayResponse.User> QuestionsList=response.body().getUsers();
               Log.e("QuestionsList>>Size---",""+QuestionsList.size());
               Log.e("QuestionsList>>---",""+
                       new Gson().toJson(QuestionsList));
//                        new Gson().fromJson( new Gson().toJson(QuestionsList.get(0)), QuizPlayResponse.User.class)
              /* if (response.body().getStatus()==200){

                   QuizPlay.this.response = response;

                   QuizQuestion.setText(  response.body().getUsers().get(0).getQuestion());



                   Toast.makeText(QuizPlay.this, "mitti", Toast.LENGTH_SHORT).show();

                   OPtionA.setText(  response.body().getUsers().get(0).getOptionA());
                   OPtionB.setText(  response.body().getUsers().get(0).getOptionB());
                   OPtionC.setText(  response.body().getUsers().get(0).getOptionC());
                   OPtionD.setText(  response.body().getUsers().get(0).getOptionD());

                   try {
                       response.body().getUsers().get(0).getQuestion();



                       response.body().getUsers().get(0).getCorrectans();

                       Log.e("dataview",response.raw().body().string()); // parse this and use inside for loop
                   } catch (IOException e) {
                       e.printStackTrace();
                   }
               }else {
                   Toast.makeText(QuizPlay.this,response.body().getMessage(), Toast.LENGTH_SHORT).show();

             }*/

           }


           @Override
           public void onFailure(Call<QuizPlayResponse> call, Throwable t) {
               Log.e("throwable message",t.getMessage());
           }
       });

       AnswerOptions.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(RadioGroup group, int checkedId) {
             if(( (RadioButton)findViewById(checkedId)).getText().equals(Response.body().getUsers().get(0).getCorrectans())){
                 score+=1;
             }
             
           }
       });
        }

    @Override
    public void addCount() {

    }
}
