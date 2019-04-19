package com.example.india.quizpost.Recycle;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.india.quizpost.Api_Response.CompanyResponse;
import com.example.india.quizpost.ProjectClassFile.CompanyApplied_Form;
import com.example.india.quizpost.R;
import com.example.india.quizpost.utilities.SessionManager;

import java.util.ArrayList;

public class CyclerAdapter extends RecyclerView.Adapter<CyclerAdapter.ItemViewHolder> {

    Context context;
    ArrayList<CompanyResponse.User> response;

        SessionManager sessionManager;

    public CyclerAdapter(Context context, ArrayList<CompanyResponse.User> response) {
        this.context = context;
        this.response = response;
    }


    @NonNull
    @Override
    public CyclerAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.row,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CyclerAdapter.ItemViewHolder itemViewHolder, final int position) {


        itemViewHolder.company1.setText(response.get(position).getCompanyName());
        itemViewHolder.aboutus1.setText(response.get(position).getCompanyDescription());
        itemViewHolder.experience.setText(response.get(position).getSkills());
        itemViewHolder.subject.setText(response.get(position).getJobType());
        itemViewHolder.Currency.setText(response.get(position).getSalary());


        itemViewHolder.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionManager.addString("cmp_name",response.get(position).getCompanyName());
                context.startActivity(new Intent(context , CompanyApplied_Form.class));
            }
        });
//image view from database
        Glide.with(itemViewHolder.profileIv)
                .asBitmap()
                .circleCrop()
                .load(response.get(position).getImage())
                .into(itemViewHolder.profileIv);
        Log.e("DATA",response.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return response.size();
    }


    public class ItemViewHolder extends RecyclerView.ViewHolder {

        ImageView profileIv;
        TextView company1;
        TextView aboutus1;
        TextView Skill;
        TextView experience;
        TextView JobType;
        TextView subject;
        TextView Salary;
        TextView Currency;
        Button button1;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            profileIv=itemView.findViewById(R.id.img);
            company1=itemView.findViewById(R.id.company1);
            aboutus1=itemView.findViewById(R.id.aboutus1);
            Skill=itemView.findViewById(R.id.Skill);
            experience =itemView.findViewById(R.id.experience);
            JobType=itemView.findViewById(R.id.JobType);
            subject=itemView.findViewById(R.id.subject);
            Salary=itemView.findViewById(R.id.Salary);
            Currency=itemView.findViewById(R.id.Currency);
            button1=itemView.findViewById(R.id.button1);
            sessionManager = new SessionManager(context);
        }
    }

}
