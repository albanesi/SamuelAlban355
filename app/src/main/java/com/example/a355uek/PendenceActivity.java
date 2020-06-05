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

public class PendenceActivity extends AppCompatActivity {
    //The UI Components of the Activity
    DatePickerDialog picker;
    EditText eText, titleField, eText2;
    TextView textView;
    Spinner spinner;
    Button button;
    Date date;

    // each time the SaveButton is clicked this Method gets activated
    private View.OnClickListener mSaveOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View sendButton) {
            //Eingegebener Text in einem Toast, welches 3.5 Sekunden (Toast.LENGTH_LONG) angezeigt
            // wird, ausgeben

            //first it gets the data from the XML View (activity_pendence)
            //and saves them on Strings
            String title = titleField.getText().toString();
            String description = eText2.getText().toString();
            String dateInString = eText.getText().toString();
            String importance = spinner.getSelectedItem().toString();
            String saved = "erfolgreich gespeichert";

            //parses the dateInString in a dd.MM.yyyy Format
            try {
                date=new SimpleDateFormat("dd.MM.yyyy").parse(dateInString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
           //here it creates a new pendence from the data that we get from the XML View
            Pendence pendence = new Pendence(title,description,date,importance);
           //here it saves the pendence
            savePendece(pendence);

            //it shows a toast that the entry was right
            Toast toast = Toast.makeText(getApplicationContext(), saved, Toast.LENGTH_LONG);
            toast.show();

            //then he goes back to the MainActivity
            openTheMainActivity();
        }
    };

    // it gets called each time we create this activity
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //the view of this activity is activity_pendence
        setContentView(R.layout.activity_pendence);

        //connects and initalises the UI Components from the Activity
        //with them from the view

        titleField = (EditText) findViewById(R.id.createTitle);
        if( titleField.getText().toString().length() == 0 ) {
            titleField.setError( "Dieses ist ein Pflichtfeld" );
        }
        eText2 = findViewById(R.id.createDescription);
        textView = findViewById(R.id.createDate);
        spinner = findViewById(R.id.spinnerForImportance);
        button = findViewById(R.id.saveButton);

        //here he defines what method should be called, when the button gets clicekd
        button.setOnClickListener(mSaveOnClickListener);

        //das hani leider nöd so guet verstande samuel, muesch mir helfe
        eText = (EditText) findViewById(R.id.createDate);
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
                                eText.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });
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