package com.example.a355uek;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a355uek.model.Pendence;

import org.w3c.dom.Text;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private LayoutInflater layoutInflater;
    private List<Pendence> data;
    private Context context;

    Adapter(Context context, List<Pendence> data){
    this.layoutInflater = LayoutInflater.from(context);
    this.data=data;
    this.context=context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.custom_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
    String title = data.get(position).getTitle();
    String description = data.get(position).getDescription();
    String important = data.get(position).getImportance();
    holder.textTitle.setText(title);
    holder.textdate.setText("1");
    holder.textDescription.setText(description);
    holder.textImportance.setText(important);

    holder.itemLayout.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context,SecondActivity.class);
            intent.putExtra("title",data.get(position).getTitle());
            intent.putExtra("description",data.get(position).getDescription());
            intent.putExtra("importance",data.get(position).getImportance());
            context.startActivity(intent);
        }
    });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView textTitle, textDescription, textImportance, textdate;
        ConstraintLayout itemLayout;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            textTitle=itemView.findViewById(R.id.titeltext);
            textDescription=itemView.findViewById(R.id.beschreibungstext);
            textImportance=itemView.findViewById(R.id.dringlichkeitstext);
            textdate=itemView.findViewById(R.id.zuerledigenbisText);
            itemLayout=itemView.findViewById(R.id.itemView);
        }
    }
}
