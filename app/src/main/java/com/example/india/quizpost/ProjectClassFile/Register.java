package com.example.india.quizpost.ProjectClassFile;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.india.quizpost.Api_Interface.ApiInterface;
import com.example.india.quizpost.Api_Manager.ApiClient;
import com.example.india.quizpost.Api_Response.RegisterResponse;
import com.example.india.quizpost.R;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.Length;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity implements Validator.ValidationListener {



    Calendar myCalendar = Calendar.getInstance();


    @NotEmpty
    @BindView(R.id.name)
    EditText name;

    @Length(max = 10, min = 10, message = "Message Length is not valid")
    @BindView(R.id.phoneno)
    EditText phoneno;

    @BindView(R.id.layout_rollno)
    android.support.design.widget.TextInputLayout layoutRollno;

    @NotEmpty
    @BindView(R.id.location)
    EditText location;

    @BindView(R.id.layout_DOB)
    android.support.design.widget.TextInputLayout layoutDOB;
    @NotEmpty
    @BindView(R.id.DOB)
    EditText DOB;

    @BindView(R.id.layout_email)
    android.support.design.widget.TextInputLayout layoutEmail;
    @Email
    @BindView(R.id.email)
    EditText email;

    @BindView(R.id.layout_password)
    android.support.design.widget.TextInputLayout layoutPassword;

    @Password
    @BindView(R.id.password)
    EditText password;

    @BindView(R.id.gender)
    TextView gender;

    @BindView(R.id.UserGender)
    RadioGroup UserGender;

    @BindView(R.id.radiobtn_male)
    RadioButton radiobtnMale;

    @BindView(R.id.radiobtn_female)
    RadioButton radiobtnFemale;

    @BindView(R.id.submitbutton)
    Button submitbutton;

    @BindView(R.id.register_clgname)
    android.support.design.widget.TextInputLayout registerClgname;

    @BindView(R.id.CollegeName)
    EditText CollegeName;

    ApiInterface apiInterface;
    Validator validator;

    String Usergender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        validator = new Validator(this);
        validator.setValidationListener(this);


        final DatePickerDialog.OnDateSetListener dob = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                startDateUpdate();
            }

        };



        DOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(Register.this, dob, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });





        UserGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.radiobtn_male:
                        Usergender="Male";
                        break;
                    case R.id.radiobtn_female:
                        Usergender="Female";
                        // do operations specific to this selection
                        break;
                }
            }
        });


    }







    @OnClick(R.id.submitbutton)
    void submitbutton() {
        validator.validate();

    }


    @Override
    public void onValidationSucceeded() {
userregister();
    }

    public void userregister(){
        apiInterface = ApiClient.createService(ApiInterface.class,"");
        Call<RegisterResponse>registerResponseCall=apiInterface.RegisterResponse("register",
                name.getText().toString(),
                password.getText().toString(),
                phoneno.getText().toString(),
                CollegeName.getText().toString(),
                email.getText().toString(),
                DOB.getText().toString(),
                location.getText().toString(),
                Usergender);

        registerResponseCall.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {

                if (response.body().getStatus() == 1){
                    Toast.makeText(Register.this, "Successfully Registered", Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(Register.this,Login.class);
                    startActivity(i);
                    finish();

                }
                else {
                    Toast.makeText(Register.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {


                Toast.makeText(Register.this, "Not registererd", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(this, message, Toast.LENGTH_LONG).show();

            }
        }

    }



    private void startDateUpdate() {

        String myFormat = "yyyy/MM/dd"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        DOB.setText(sdf.format(myCalendar.getTime()));
    }


}
