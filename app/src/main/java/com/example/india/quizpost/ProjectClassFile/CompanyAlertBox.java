package com.example.india.quizpost.ProjectClassFile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.india.quizpost.R;

public class CompanyAlertBox extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_alert_box);

        /* final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // before
        dialog.setContentView(R.layout.customdialogbox);
        dialog.setCancelable(true);

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();

        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;

        ((AppCompatButton) dialog.findViewById(R.id.Submit)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),  "Applied Successfully", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        dialog.show();
        dialog.getWindow().setAttributes(lp);*/
    }
}
/*
  AlertDialog.Builder builder = new AlertDialog.Builder(Alert_Dailog_Box.this);
 builder.setPositiveButton("", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Alert_Dailog_Box.this, "Applied Successfully", Toast.LENGTH_SHORT).show();
            }
        });

        builder.show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert__dailog__box);*/