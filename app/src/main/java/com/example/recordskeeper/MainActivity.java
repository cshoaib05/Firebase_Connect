package com.example.recordskeeper;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import  android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity
{
    EditText name;
    EditText phone;
    EditText age;
    Button submit;

    DatabaseReference database;
    ItemsData itemdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        itemdata  = new ItemsData();
        database = FirebaseDatabase.getInstance().getReference("ARInter");

        name = (EditText)findViewById(R.id.name);
        phone = (EditText)findViewById(R.id.phone);
        age = (EditText)findViewById(R.id.age);
    }

    public void SubmitCLick(View view)
    {
        String nme = name.getText().toString().trim();
        long number = Integer.parseInt(phone.getText().toString().trim());
        int ag= Integer.parseInt(age.getText().toString().trim());
        itemdata.setAge(ag);
        itemdata.setName(nme);
        itemdata.setPhoneNumber(number);
        database.push().setValue(itemdata);
        Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_SHORT).show();

    }




}
