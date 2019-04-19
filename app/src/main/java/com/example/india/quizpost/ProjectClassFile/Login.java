package com.example.india.quizpost.ProjectClassFile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.example.india.quizpost.Api_Interface.ApiInterface;
import com.example.india.quizpost.Api_Manager.ApiClient;
import com.example.india.quizpost.Api_Response.LoginResponse;
import com.example.india.quizpost.R;
import com.example.india.quizpost.utilities.SessionManager;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Length;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity implements Validator.ValidationListener {

    /**
     * ButterKnife Code
     **/
    @Length(max = 10 , min = 10)
    @NotEmpty(message = "please enter your Mobile no!")
    @BindView(R.id.user)
    EditText user;


    @NotEmpty(message = "Enter Password")
    @BindView(R.id.pass)
    EditText pass;

    @BindView(R.id.loginbutton)
    Button loginbutton;

    @BindView(R.id.register)
    TextView register;

    @BindView(R.id.forgetPassword)
    TextView forgetPassword;

   @BindView(R.id.ProgressBarLogin)
    ProgressBar progressBar;
  LottieAnimationView checkview;
    /**
     * ButterKnife Code
     **/

    ApiInterface apiInterface;


    Validator validator;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        validator = new Validator(this);
        validator.setValidationListener(this);
        sessionManager = new SessionManager(getApplicationContext());

    }


    @OnClick(R.id.register)
    void register() {
        Intent intent = new Intent(Login.this, Register.class);
        startActivity(intent);

    }


    @OnClick(R.id.forgetPassword)
    void forgetpassword() {
        Intent intent = new Intent(Login.this, ForgetPassword.class);
        startActivity(intent);
                Toast.makeText(getApplicationContext(), "Successfull", Toast.LENGTH_SHORT).show();

    }

    @OnClick(R.id.loginbutton)
    void loginbutton() {

        validator.validate();

    }

    @Override
    public void onValidationSucceeded() {

   userlogin();


    }

    private void userlogin(){
        sessionManager.clearall();

        final   ProgressBar pg = new ProgressBar(this);
        pg.setTag("loading...");
        pg.setVisibility(View.VISIBLE);

        apiInterface = ApiClient.createService(ApiInterface.class,"");
        Call<LoginResponse> loginResponseCall=apiInterface.LoginResponse("login",user.getText().toString(),
                pass.getText().toString());
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                                 if (response.body().getSuccess()==200){

                                    sessionManager.addString("user_id",response.body().getId());
                                     sessionManager.addString("user_name",response.body().getName());
                                     sessionManager.addString("user_email",response.body().getEmail());
                                     sessionManager.addString("user_dob",response.body().getDob());
                                     sessionManager.addString("user_phoneno",response.body().getPhoneno());
                                     sessionManager.addString("user_gender",response.body().getGender());
                                     sessionManager.addString("user_location",response.body().getLocation());
                                     sessionManager.addString("user_college",response.body().getCollege());
                                     sessionManager.addString("user_image",response.body().getImage());
                                     loginbutton.setVisibility(View.GONE);
                                     progressBar.setVisibility(View.VISIBLE);
                                     pg.setVisibility(View.GONE);


                                     Toast.makeText(Login.this, "Successfully Login", Toast.LENGTH_SHORT).show();
                                     Intent i = new Intent(Login.this,DashboardNav.class);
                        startActivity(i);
                        finish();

                }else {
                    Toast.makeText(Login.this,response.body().getMessage(), Toast.LENGTH_SHORT).show();

                    pg.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(Login.this, "Login Failed", Toast.LENGTH_SHORT).show();
                Log.e("throwable message",t.getMessage());
                pg.setVisibility(View.GONE);

            }
        });



    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(this);


            if (view instanceof EditText) {
                ((EditText) view).setError(message);
            } else {
                Toast.makeText(this, message, Toast.LENGTH_LONG).show();

            }
        }

    }


}
