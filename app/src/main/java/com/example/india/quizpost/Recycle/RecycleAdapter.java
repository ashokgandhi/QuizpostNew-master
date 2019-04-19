package com.example.india.quizpost.Recycle;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.india.quizpost.ProjectClassFile.Login;
import com.example.india.quizpost.ProjectClassFile.QuizPlay;
import com.example.india.quizpost.ProjectClassFile.Register;
import com.example.india.quizpost.R;

import java.util.ArrayList;

import rx.internal.operators.OperatorOnBackpressureDrop;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ItemViewHolder> {

    Context context;
    ArrayList<ItemModel> itemModels;


    public RecycleAdapter(Context context, ArrayList<ItemModel> itemModels){
        this.context=context;
        this.itemModels=itemModels;
    }


    @Override
    public RecycleAdapter.ItemViewHolder onCreateViewHolder( ViewGroup parent,int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.recycle_gridmain,parent,false);
        return new ItemViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull RecycleAdapter.ItemViewHolder itemViewHolder, final int position) {
            final ItemModel itemModel=itemModels.get(position);
            itemViewHolder.textView1.setText(itemModel.name);
            itemViewHolder.imageView.setImageResource(itemModel.img);
            itemViewHolder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,""+itemModel.getName(), Toast.LENGTH_SHORT).show();
                }
            });
            itemViewHolder.examstart.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    final Dialog dialog = new Dialog(context);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // before
                    dialog.setContentView(R.layout.activity_company_alert_box);
                    dialog.setCancelable(true);

                    WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                    lp.copyFrom(dialog.getWindow().getAttributes());
                    lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
                    lp.height = WindowManager.LayoutParams.WRAP_CONTENT;



                    ((AppCompatButton) dialog.findViewById(R.id.Submit)).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(context, "Accepted", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(context, QuizPlay.class);
                           context.startActivity(i);
                            dialog.dismiss();
                        }


                    });



                    dialog.show();
                    dialog.getWindow().setAttributes(lp);


                }


            });



    }

    @Override
    public int getItemCount() {return itemModels.size();}





    public class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView textView1;
        ImageView imageView;
        Button  examstart;


        public ItemViewHolder(View itemView) {
            super(itemView);
            textView1=itemView.findViewById(R.id.CompanyName);
            imageView=itemView.findViewById(R.id.ImgRecycle);
            examstart=itemView.findViewById(R.id.ExamStart);


        }
    }
}
