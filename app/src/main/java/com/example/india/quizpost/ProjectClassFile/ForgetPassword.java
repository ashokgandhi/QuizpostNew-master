package com.example.india.quizpost.ProjectClassFile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.india.quizpost.Api_Interface.ApiInterface;
import com.example.india.quizpost.Api_Manager.ApiClient;
import com.example.india.quizpost.Api_Response.ForgetPasswordReset;
import com.example.india.quizpost.R;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForgetPassword extends AppCompatActivity implements Validator.ValidationListener {

    /** ButterKnife Code **/
    @BindView(R.id.card_view)
    android.support.v7.widget.CardView cardView;

    @BindView(R.id.text)
    TextView text;

    @BindView(R.id.input_layout_email)
    android.support.design.widget.TextInputLayout inputLayoutEmail;

    @Email(message = "Email Format Error")
    @BindView(R.id.user_email)
    EditText userEmail;

    @BindView(R.id.input_layout_chpass)
    android.support.design.widget.TextInputLayout inputLayoutChpass;

    @NotEmpty(message = "Enter Password")
    @BindView(R.id.change_password)
    EditText changePassword;

    @BindView(R.id.input_layout_copass)
    android.support.design.widget.TextInputLayout inputLayoutCopass;

    @NotEmpty(message = "Enter Password")
    @BindView(R.id.confirm_password)
    EditText confirmPassword;

    @BindView(R.id.forgetPassword_submit)
    Button forgetPassword_Submit;
    /** ButterKnife Code **/
Validator validator;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgetpassword);
        ButterKnife.bind(this);

            validator=new Validator(this);
            validator.setValidationListener(this);

    }

    @OnClick(R.id.forgetPassword_submit)
    void forgetPassword_submit(){
//        forgetPassword_Submit.setBackgroundColor(Color.RED);
        validator.validate();
    }


    @Override
    public void onValidationSucceeded() {

        passwordreset();

    }

    private void passwordreset(){
        apiInterface = ApiClient.createService(ApiInterface.class,"");
        Call<ForgetPasswordReset>forgetPasswordResetCall=apiInterface.ForgetPasswordReset("update",
                userEmail.getText().toString(),
                confirmPassword.getText().toString());
        forgetPasswordResetCall.enqueue(new Callback<ForgetPasswordReset>() {
            @Override
            public void onResponse(Call<ForgetPasswordReset> call, Response<ForgetPasswordReset> response) {
                if (response.body().getStatus()==1){

                    Toast.makeText(ForgetPassword.this, "Password Change", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(ForgetPassword.this,Login.class);
                    startActivity(i);

                    finish();

                }else {
                    Toast.makeText(ForgetPassword.this,response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ForgetPasswordReset> call, Throwable t) {
                Toast.makeText(ForgetPassword.this, "Password Reset Failed", Toast.LENGTH_SHORT).show();
                Log.e("throwable message",t.getMessage());

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
                Toast.makeText(this, "Password Reset Failed", Toast.LENGTH_SHORT).show();;

            }
        }
    }
}
