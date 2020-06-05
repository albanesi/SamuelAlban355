package com.example.a355uek;
//the imports that we used
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a355uek.model.Pendence;
import com.example.a355uek.persistence.AppDatabase;
import com.example.a355uek.persistence.PendenceDao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

public class PendenceActivity extends AppCompatActivity {
    //The UI Components of the Activity
    DatePickerDialog picker;
    EditText eText, titleField, eText2;
    TextView textView;
    Spinner spinner;
    Button button;
    Date date;
    Toast stringToast;
    Toast dateToast;
    boolean areStringsRight;
    boolean isDateRight;
    // each time the SaveButton is clicked this Method gets activated
    private View.OnClickListener mSaveOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View sendButton) {

            //first it gets the data from the XML View (activity_pendence)
            //and saves them on Strings
            String title = titleField.getText().toString();
            String description = eText2.getText().toString();
            String dateInString = eText.getText().toString();
            String importance = spinner.getSelectedItem().toString();



            //checks if the title and description fit the validation
            areStringsRight = isTheStringValidationRight(title,description);



            //parses the dateInString in a dd.MM.yyyy Format
            date = parseTheDate(dateInString);
            //checks if the date fits the format
            isDateRight=isTheDateRight(date);


            if(areStringsRight==true&&isDateRight==true){
                //here it creates a new pendence from the data that we get from the XML View
                Pendence pendence = new Pendence(title,description,date,importance);
                //here it saves the pendence
                savePendece(pendence);
                //it shows a toast that the entry was right
                Toast toast = Toast.makeText(getApplicationContext(),getString(R.string.saveForm), Toast.LENGTH_LONG);
                toast.show();
                //then he goes back to the MainActivity
                openTheMainActivity();
            }else{
                try {
                    showTheToasts();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    private void showTheToasts() throws InterruptedException {
        if(areStringsRight==false){
            stringToast = Toast.makeText(getApplicationContext(), getString(R.string.textfieldsMistake), Toast.LENGTH_SHORT);
            stringToast.show();

        }
        if(isDateRight==false){
            dateToast=Toast.makeText(getApplicationContext(), getString(R.string.dateMistake), Toast.LENGTH_SHORT);
            dateToast.show();
        }



    }

    //parses the dateInString in a dd.MM.yyyy Format
    private Date parseTheDate(String dateInString) {
        try {
            date=new SimpleDateFormat("dd.MM.yyyy").parse(dateInString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    //this method checks if the length of the title is over 50 and checks if
    //the length of the description is over 500
    //if they arent it returns true else false
    private boolean isTheStringValidationRight(String title, String description){
        if(title==null ||title.length()>50||description.length()>500||description==null){

            return false;
        }else{
            return true;
        }
    }
    //this method watches if the date is not null and it checks if
    //if the date is written in dd.mm.yyyy format
    private boolean isTheDateRight(Date date){
        if(date != null){
            if (date instanceof Date){
                return true;
            }
            return false;
        }else{
            return false;
        }
    }

    // it gets called each time we create this activity
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //the view of this activity is activity_pendence
        setContentView(R.layout.activity_pendence);

        //connects and initalises the UI Components from the Activity
        //with them from the view
        initialiseTheViews();

        //here he defines what method should be called, when the button gets clicekd
        button.setOnClickListener(mSaveOnClickListener);

        //takes the value of the UI Component from the UI
        //creates a new DatePicker Dialog
        //and then it shows it in dd.MM.yyyy format
        eText = findViewById(R.id.createDate);
        eText.setInputType(InputType.TYPE_NULL);
        eText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(PendenceActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                eText.setText(dayOfMonth + "." + (monthOfYear + 1) + "." + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });
    }

    //connects and initalises the UI Components from the Activity
    //with them from the view
    private void initialiseTheViews() {

        titleField = findViewById(R.id.createTitle);
        if( titleField.getText().toString().length() == 0 ) {
            titleField.setError(getString(R.string.required));
        }
        eText2 = findViewById(R.id.createDescription);
        textView = findViewById(R.id.createDate);
        spinner = findViewById(R.id.spinnerForImportance);
        button = findViewById(R.id.saveButton);
    }

    //First it creates a new PendeceDao
    //then it inserts the pendence that is given as a parameter
    private void savePendece(Pendence pendence){
    PendenceDao pendenceDao = AppDatabase.getAppDb(this).getPendenceDao();
    pendenceDao.insertAll(pendence);
    }

    //here it creates a new Intent and starts then the activity with that intent
    //it goes to MainActivity and it finishes the state
    private void openTheMainActivity() {
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}