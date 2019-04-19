package com.example.india.quizpost.Interview;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.india.quizpost.Api_Response.GroupDInterview;
import com.example.india.quizpost.Api_Response.InterviewQuestionResponse;
import com.example.india.quizpost.R;
import com.example.india.quizpost.utilities.SessionManager;

import java.util.ArrayList;

public class GdAdapter extends RecyclerView.Adapter<GdAdapter.ItemViewHolder> {
    Context context;
    ArrayList<GroupDInterview.User> responses;


    SessionManager sessionManager;

    public GdAdapter(Context context, ArrayList<GroupDInterview.User>responses){
        this.context=context;
        this.responses=responses;

    }


    @NonNull
    @Override
    public GdAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.raw_questionlist,parent,false);
        return new GdAdapter.ItemViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull GdAdapter.ItemViewHolder itemViewHolder, final  int position) {
        itemViewHolder.question_number.setText(responses.get(position).getQuesno());
        itemViewHolder.question.setText(responses.get(position).getGdquestion());


        itemViewHolder.question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionManager.addString("answer",responses.get(position).getGddescription());
                sessionManager.addString("question",responses.get(position).getGdquestion());
                context.startActivity(new Intent(context,InterviewAnswerPage.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return responses.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView question_number;
        TextView question;
        TextView describe;
        TextView quesview;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            question_number = itemView.findViewById(R.id.question_number);
            question = itemView.findViewById(R.id.question);
            describe=itemView.findViewById(R.id.describe);
            quesview=itemView.findViewById(R.id.quesview);
            sessionManager = new SessionManager(context);
        }
    }

}
