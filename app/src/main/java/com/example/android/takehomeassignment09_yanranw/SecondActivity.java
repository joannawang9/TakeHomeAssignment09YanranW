package com.example.android.takehomeassignment09_yanranw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SecondActivity extends AppCompatActivity {
    EditText keyword;
    EditText title;
    EditText year;
    CheckBox isAvailable;
    TextView date;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference albumRef = database.getReference("Keyword");
    private DatabaseReference albumsRef = database.getReference("Multiple albums");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        keyword = (EditText) findViewById(R.id.keyword);
        title = (EditText) findViewById(R.id.title);
        year = (EditText) findViewById(R.id.year);
        isAvailable = (CheckBox) findViewById(R.id.available);
        date = (TextView)findViewById(R.id.date);

        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = df.format(c);
        date.setText(formattedDate);
    }
    public void set(View view) {
        albumRef.setValue(keyword.getText().toString());
    }

    public void add(View view) {
        albumsRef.push().setValue(new Album(title.getText().toString(), Integer.parseInt(year.getText().toString()), isAvailable.isChecked()));
    }

}

