package com.example.mykeyboardsamples;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private EditText birthday;
    private  int mYear;
    private int mMonth;
    private int mDay;

    private String mSpinnerLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        birthday= findViewById(R.id.birthday);
        birthday.setOnClickListener(this);
        Spinner phoneSpinner = findViewById(R.id.phone_spinner);

        if (phoneSpinner!=null){
            phoneSpinner.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.spinner_label, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        if (phoneSpinner!=null) {
            phoneSpinner.setAdapter(adapter);
        }
    }

    @Override
    public void onClick(View v) {
     if (v==birthday){
         final Calendar c = Calendar.getInstance();
         mYear = c.get(Calendar.YEAR);
         mMonth= c.get(Calendar.MONTH);
         mDay= c.get(Calendar.DAY_OF_MONTH);

         DatePickerDialog datePickerDialog= new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
             @Override
             public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                 birthday.setText(dayOfMonth+"-"+(month+1+"-"+year));
             }
         },mYear,mMonth,mDay);
         datePickerDialog.show();
     }

    }


    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long id) {
      mSpinnerLabel = adapterView.getItemAtPosition(i).toString();
      Toast myToast =  Toast.makeText(this, "Selected phone as:", Toast.LENGTH_SHORT);
              myToast.show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
     Toast toast =   Toast.makeText(this, "Nothing selected", Toast.LENGTH_SHORT);
             toast.show();
    }

    public void showToast(View view) {
        Toast check = Toast.makeText(this,"please Accept Terms and Conditions", Toast.LENGTH_SHORT);
        check.show();
    }

    public void createAccount(View view) {
        Toast toastSubmit = Toast.makeText(this, "Account Creation is Successful", Toast.LENGTH_SHORT);
        toastSubmit.show();
    }
}