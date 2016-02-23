package com.example.administrator.choosedate;

import android.service.chooser.ChooserTarget;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatePicker datePicker =(DatePicker)findViewById(R.id.datePicker);
        TimePicker timePicker=(TimePicker)findViewById(R.id.timePicker);
        Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month =  c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
        hour = c.get(Calendar.HOUR);
        minute = c.get(Calendar.MINUTE);
        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                MainActivity.this.year = year;
                MainActivity.this.month=month;
                MainActivity.this.day=day;
                showDate(year,month,day,hour,minute);
            }
        });
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                MainActivity.this.hour = hourOfDay;
                MainActivity.this.minute=minute;
                showDate(year,month,day,hour,minute);
            }
        });
    }
    private void showDate(int year,int month,int day,int hour,int minute)
    {
        EditText show = (EditText)findViewById(R.id.show);
        show.setText("your buying date is: "+year+"year"
                    +(month+1)+"month"+day+"day"+hour+"hour"
                   +minute+"minute");
    }
}
