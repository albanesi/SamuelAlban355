package com.example.a355uek;
//all imports that we needed in this class
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

//this class connects the data through the adapter view holder with the recyclerview
//we give to adapter a data source in ur case a list full of Pendences
//the adapter takes the data given and passes it to the viewholder
//viewholder then fills the fragments with data
public class PendenceAdapter extends RecyclerView.Adapter<PendenceAdapter.ViewHolder> {

    //fields from class adapter
    private LayoutInflater layoutInflater;

    //is a field, will be initialised in the constructor when Main Activity passes the list
    //of pendences from the db
    private List<Pendence> data;

    //needed for switching the Activities
    private Context context;

    //the adapter constructor, takes an context and a list of pendences as parameter
    //initalized only in the MainActivity
    PendenceAdapter(Context context, List<Pendence> data){
    this.layoutInflater = LayoutInflater.from(context);
    this.data=data;
    this.context=context;
    }

    ///this method says what fragment should be passed to our viewholder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.custom_view,parent,false);
        return new ViewHolder(view);
    }

    //this method gets all the data from the parameter we have passed,
    //then it sets the data in the UI-Components from the fragment
    //the onclick listener gets activated if someone presses a fragment, then the data will be passed in the
    //SecondActivity Class
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
    String title = data.get(position).getTitle();
    String important = data.get(position).getImportance();
    String date = formatTime(data.get(position).getDateToFinish());

    holder.textTitle.setText(title);
    holder.textdate.setText(date);
    holder.textImportance.setText(important);

    holder.itemLayout.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, DetailledActivity.class);
            intent.putExtra("title",data.get(position).getTitle());
            intent.putExtra("date",formatTime(data.get(position).getDateToFinish()));
            intent.putExtra("description",data.get(position).getDescription());
            intent.putExtra("importance",data.get(position).getImportance());
            context.startActivity(intent);
        }
    });

    }
    //here it returns the size of the pendence list we passed in the adapter controller
    @Override
    public int getItemCount() {
        return data.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        //UI Components of the Fragment
        TextView textTitle, textImportance, textdate, textDescription;
        ConstraintLayout itemLayout;

        //ViewHolder Constructor
        //connects and initalizes all the upper UI-components with the
        //UI-Components from the fragment
        //takes the custom_view as parameter
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            textTitle=itemView.findViewById(R.id.titeltext);
            textImportance=itemView.findViewById(R.id.dringlichkeitstext);
            textdate=itemView.findViewById(R.id.zuerledigenbisText);
            itemLayout=itemView.findViewById(R.id.itemView);

        }

    }

    //checks if the date is null or not
    //then it formats the date in dd.MM.yyyy
    //then it returns the formatted string
    private String formatTime(Date date){
        if(date==null){
            return "";
        }
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        String strDate= formatter.format(date);
        return strDate;
    }
}
