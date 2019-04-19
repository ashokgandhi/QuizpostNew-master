package com.example.india.quizpost.Interview;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.india.quizpost.Api_Response.InterviewResumeResponse;
import com.example.india.quizpost.R;
import com.example.india.quizpost.utilities.SessionManager;

import java.util.ArrayList;

public class ResumeAdapter extends RecyclerView.Adapter<ResumeAdapter.ItemViewHolder> {
    Context context;
        ArrayList<InterviewResumeResponse.User>response;
        SessionManager sessionManager;


        public ResumeAdapter(Context  context,ArrayList<InterviewResumeResponse.User>response){
            this.context=context;
            this.response=response;
        }

    @NonNull
    @Override
    public ResumeAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.raw_questionlist,parent,false);

        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResumeAdapter.ItemViewHolder itemViewHolder, final int position) {
        itemViewHolder.question_number.setText(response.get(position).getResumeQno());
        itemViewHolder.question.setText(response.get(position).getResumeQuestion());

        itemViewHolder.question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionManager.addString("answer",response.get(position).getResumeAnswer());
                sessionManager.addString("question",response.get(position).getResumeQuestion());
                context.startActivity(new Intent(context,InterviewAnswerPage.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return response.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView question_number;
        TextView question;
        TextView describe;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            question_number = itemView.findViewById(R.id.question_number);
            question = itemView.findViewById(R.id.question);
            describe=itemView.findViewById(R.id.describe);
            sessionManager = new SessionManager(context);
        }
    }
}
