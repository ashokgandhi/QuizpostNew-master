package com.example.india.quizpost.ProjectClassFile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.india.quizpost.R;
import com.example.india.quizpost.utilities.SessionManager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Rating_Feedback extends AppCompatActivity {

    /** ButterKnife Code **/
    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.ratingBar)
    RatingBar ratingBar;
    @BindView(R.id.tvRatingScale)
    TextView tvRatingScale;
    @BindView(R.id.edit)
    EditText edit;
    @BindView(R.id.btnSubmit)
    Button btnSubmit;
    /** ButterKnife Code **/

    SessionManager sessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating__feedback);
        ButterKnife.bind(this);
        sessionManager = new SessionManager(getApplicationContext());


        String id =  sessionManager.getString("user_id");
        String user_email =  sessionManager.getString("user_email");
        String user_phno=sessionManager.getString("user_phoneno");
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

            }
        });

       ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                tvRatingScale.setText(String.valueOf(v));
                switch ((int) ratingBar.getRating()) {
                    case 1:
                        tvRatingScale.setText("Very bad");
                        break;
                    case 2:
                        tvRatingScale.setText("Need some improvement");
                        break;
                    case 3:
                        tvRatingScale.setText("Good");
                        break;
                    case 4:
                        tvRatingScale.setText("Great");
                        break;
                    case 5:
                        tvRatingScale.setText("Awesome. I love it");
                        break;
                    default:
                        tvRatingScale.setText("");
                }
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edit.getText().toString().isEmpty()) {
                    Toast.makeText(Rating_Feedback.this, "Please fill in feedback text box", Toast.LENGTH_LONG).show();
                } else {
                    edit.setText("");
                    ratingBar.setRating(0);
                    Toast.makeText(Rating_Feedback.this, "Thank you for sharing your feedback", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
