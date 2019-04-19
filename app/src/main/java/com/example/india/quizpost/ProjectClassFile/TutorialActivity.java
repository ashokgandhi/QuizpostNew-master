package com.example.india.quizpost.ProjectClassFile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.india.quizpost.Tutorial.CTutorial;
import com.example.india.quizpost.Tutorial.CplusTutorial;
import com.example.india.quizpost.Tutorial.IosTutorial;
import com.example.india.quizpost.Tutorial.JavaTutorial;
import com.example.india.quizpost.Tutorial.PythonTutorial;
import com.example.india.quizpost.Tutorial.AndroidTutorial;
import com.example.india.quizpost.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TutorialActivity extends AppCompatActivity {
    /** ButterKnife Code **/
    @BindView(R.id.toolbar)
    android.support.v7.widget.Toolbar toolbar;
    @BindView(R.id.arrowback)
    TextView arrowback;
    @BindView(R.id.CV)
    android.support.v7.widget.CardView CV;
    @BindView(R.id.CV_Android)
    android.support.v7.widget.CardView CVAndroid;
    @BindView(R.id.CV_Python)
    android.support.v7.widget.CardView CVPython;
    @BindView(R.id.CV_Java)
    android.support.v7.widget.CardView CVJava;
    @BindView(R.id.CV_iOS)
    android.support.v7.widget.CardView CVIOS;
    @BindView(R.id.CV_C)
    android.support.v7.widget.CardView CVC;
    @BindView(R.id.CV_Cplus)
    android.support.v7.widget.CardView CVCplus;
    /** ButterKnife Code **/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.CV_Android)
    void cv_android() {
        Intent intent = new Intent(TutorialActivity.this, AndroidTutorial.class);
        startActivity(intent);

    }

    @OnClick(R.id.CV_Python)
    void cv_python() {
        Intent intent = new Intent(TutorialActivity.this, PythonTutorial.class);
        startActivity(intent);

    }

    @OnClick(R.id.CV_Java)
    void cv_java() {
        Intent intent = new Intent(TutorialActivity.this, JavaTutorial.class);
        startActivity(intent);

    }

    @OnClick(R.id.CV_iOS)
    void cv_ios() {
        Intent intent = new Intent(TutorialActivity.this, IosTutorial.class);
        startActivity(intent);

    }
    @OnClick(R.id.CV_C)
    void cv_c() {
        Intent intent = new Intent(TutorialActivity.this, CTutorial.class);
        startActivity(intent);

    }
    @OnClick(R.id.CV_Cplus)
    void cv_cplus() {
        Intent intent = new Intent(TutorialActivity.this, CplusTutorial.class);
        startActivity(intent);

    }
}
