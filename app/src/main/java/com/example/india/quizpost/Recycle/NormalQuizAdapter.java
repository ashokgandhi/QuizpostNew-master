package com.example.india.quizpost.Recycle;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.india.quizpost.Api_Response.NormalQuizResponse;
import com.example.india.quizpost.R;

import java.util.ArrayList;

public class NormalQuizAdapter extends RecyclerView.Adapter<NormalQuizAdapter.ItemViewHolder> {

    Context context;
    ArrayList<NormalQuizResponse.User>normalquiz;

    public  NormalQuizAdapter(Context context , ArrayList<NormalQuizResponse.User>normalquiz){
        this.context=context;
        this.normalquiz=normalquiz;
    }

    @NonNull
    @Override
    public NormalQuizAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recycle_gridmain,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NormalQuizAdapter.ItemViewHolder itemViewHolder, final int position) {
        itemViewHolder.CompanyName.setText(normalquiz.get(position).getQuizName());


    }

    @Override
    public int getItemCount() {
        return normalquiz.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView CompanyName;
        Button ExamStart;
        ImageView ImgRecycle;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            CompanyName = itemView.findViewById(R.id.CompanyName);
            ExamStart = itemView.findViewById(R.id.ExamStart);
            ImgRecycle=itemView.findViewById(R.id.ImgRecycle);
        }
    }
}
