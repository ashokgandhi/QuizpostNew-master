package com.example.india.quizpost.Interview;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.india.quizpost.R;

import java.util.ArrayList;

public class InterviewAdapter extends RecyclerView.Adapter<InterviewAdapter.ItemViewHolder> {
Context context;
ArrayList<InterviewModel> interviewModels;

public InterviewAdapter(Context context,ArrayList<InterviewModel>interviewModels){


    this.context=context;
    this.interviewModels=interviewModels;
}

    @NonNull
    @Override
    public InterviewAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.interviewrecycleview,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InterviewAdapter.ItemViewHolder itemViewHolder, final int position) {
    final InterviewModel interviewModel=interviewModels.get(position);
    itemViewHolder.imageView.setImageResource(interviewModel.img);
    itemViewHolder.textView.setText(interviewModel.name);


    itemViewHolder.button1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final Intent intent;
            switch (position){
                case 0:
                    intent=new Intent(context, InterViewTips.class);
                    break;

                case 1:
                    intent=new Intent(context, GroupGd.class);
                    break;

                    default:
                        intent=new Intent(context, ResumeTips.class);
                        break;
            }
            context.startActivity(intent);

        }
    });




    }

    @Override
    public int getItemCount() {
      return  interviewModels.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView textView;
    Button button1;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.image);
            textView=itemView.findViewById(R.id.title);
            button1=itemView.findViewById(R.id.button1);
        }
    }
}
