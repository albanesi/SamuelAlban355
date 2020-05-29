package com.noseryoung.samuelalban335;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.HashMap;

import org.jetbrains.annotations.Nullable;

public final class PendenceActivity extends AppCompatActivity {
    @Nullable
    private DatePickerDialog picker;
    @Nullable
    private EditText eText;
    @Nullable
    private Button btnGet;
    @Nullable
    private TextView tvw;
    private HashMap _$_findViewCache;

    @Nullable
    public final DatePickerDialog getPicker() {
        return this.picker;
    }

    public final void setPicker(@Nullable DatePickerDialog var1) {
        this.picker = var1;
    }

    @Nullable
    public final EditText getEText() {
        return this.eText;
    }

    public final void setEText(@Nullable EditText var1) {
        this.eText = var1;
    }

    @Nullable
    public final Button getBtnGet() {
        return this.btnGet;
    }

    public final void setBtnGet(@Nullable Button var1) {
        this.btnGet = var1;
    }

    @Nullable
    public final TextView getTvw() {
        return this.tvw;
    }

    public final void setTvw(@Nullable TextView var1) {
        this.tvw = var1;
    }

    @SuppressLint("ResourceType")
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(1300010);
        this.setContentView(1300004);
        View var10001 = this.findViewById(1000075);
        if (var10001 == null) {
        } else {
            this.eText = (EditText) var10001;
            EditText var10000 = this.eText;
            if (var10000 == null) {
            }

            var10000.setInputType(0);
            var10000 = this.eText;
            if (var10000 == null) {
            }

            var10000.setOnClickListener((OnClickListener) (new OnClickListener() {
                public final void onClick(View it) {
                    Calendar cldr = Calendar.getInstance();
                    int day = cldr.get(5);
                    int month = cldr.get(2);
                    int year = cldr.get(1);
                    PendenceActivity.this.setPicker(new DatePickerDialog((Context) PendenceActivity.this, (OnDateSetListener) (new OnDateSetListener() {
                        public final void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                            EditText var10000 = PendenceActivity.this.getEText();
                            if (var10000 == null) {
                            }

                            var10000.setText((CharSequence) (dayOfMonth + "/" + (monthOfYear + 1) + "/" + year));
                        }
                    }), year, month, day));
                    DatePickerDialog var10000 = PendenceActivity.this.getPicker();
                    if (var10000 == null) {
                    }

                    var10000.show();
                }
            }));
        }
    }
}