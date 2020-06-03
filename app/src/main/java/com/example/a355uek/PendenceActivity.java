package com.example.a355uek;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Date;

public class PendenceActivity extends AppCompatActivity {
    DatePickerDialog picker;
    EditText eText;
    private TextView textView;

    private View.OnClickListener mSaveOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View sendButton) {
            //Aktion, welche beim Button-Klick ausgeführt werden soll.
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_pendence);

        EditText editTitle = findViewById(R.id.createTitle);
        EditText editDesc = findViewById(R.id.createDescription);
        TextView date = findViewById(R.id.createDate);
        Spinner spinner = findViewById(R.id.spinnerForImportance);
        Button button = findViewById(R.id.saveButton);
        button.setOnClickListener(mSaveOnClickListener);

        eText=(EditText) findViewById(R.id.createDate);
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