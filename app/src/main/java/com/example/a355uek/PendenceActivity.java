package com.example.a355uek;

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

import java.util.Calendar;
import java.util.Date;

public class PendenceActivity extends AppCompatActivity {
    DatePickerDialog picker;
    EditText eText, eText1, eText2;
    TextView textView;
    Spinner spinner;
    Button button;
    //PendenceDao pendenceDao = AppDatabase.getAppDb(getApplicationContext()).getPendenceDao();
    Pendence pendence;

    private View.OnClickListener mSaveOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View sendButton) {
            //Eingegebener Text in einem Toast, welches 3.5 Sekunden (Toast.LENGTH_LONG) angezeigt
            // wird, ausgeben
            String title = eText1.getText().toString();
            String description = eText2.getText().toString();
            //pendence.setTitle(title);
            //pendence.setDescription(description);

            /*Intent showNameActivityIntent = new Intent(getActivity(), Pendence.class);
            showNameActivityIntent.putExtra(„key_person_name“, name);
            startActivity(showNameActivityIntent);*/
            
            Toast toast = Toast.makeText(getApplicationContext(), title, Toast.LENGTH_LONG);
            toast.show();
            //User in DB speichern
            //pendenceDao.insertAll(pendence);
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_pendence);

        eText1 = findViewById(R.id.createTitle);
        eText2 = findViewById(R.id.createDescription);
        textView = findViewById(R.id.createDate);
        spinner = findViewById(R.id.spinnerForImportance);
        button = findViewById(R.id.saveButton);
        button.setOnClickListener(mSaveOnClickListener);

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
}