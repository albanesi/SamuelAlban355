package com.example.a355uek;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private LayoutInflater layoutInflater;
    private List<Pendenz> data;

    Adapter(Context context, List<Pendenz> data){
    this.layoutInflater = LayoutInflater.from(context);
    this.data=data;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.custom_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    String title = data.get(position).getTitel();
    String description = data.get(position).getBeschreibung();
    String important = data.get(position).getDringlichkeit();
    holder.textTitle.setText(title);
    holder.textdate.setText("1");
    holder.textDescription.setText(description);
    holder.textImportance.setText(important);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView textTitle, textDescription, textImportance, textdate;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            textTitle=itemView.findViewById(R.id.titeltext);
            textDescription=itemView.findViewById(R.id.beschreibungstext);
            textImportance=itemView.findViewById(R.id.dringlichkeitstext);
            textdate=itemView.findViewById(R.id.zuerledigenbisText);
        }
    }
}
