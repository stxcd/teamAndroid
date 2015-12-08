package com.syfblp.sas.blpappv2.directory;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.syfblp.sas.blpappv2.R;

import java.util.ArrayList;


public class Profile extends AppCompatActivity {
    ArrayList<Person> tobedispayedList = new ArrayList<>();
    ArrayList<Person> input = new ArrayList<>();
    String nameToDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        Intent incomingIntent = this.getIntent();
        nameToDisplay = (String) incomingIntent.getStringExtra("snails");
        input = (ArrayList<Person>) incomingIntent.getSerializableExtra("json");

        Person person = getPeople(input);
        TextView firstLastNameTxt = (TextView) findViewById(R.id.txtFirstLastName);
        firstLastNameTxt.setText(person.getFirstName() + " " + person.getLastName());

        TextView FunctionLocationTxt = (TextView) findViewById(R.id.txtFunctionLocation);
        FunctionLocationTxt.setText(person.getFunction() + "  |  " + person.getLocation());

        TextView roleTxt = (TextView) findViewById(R.id.txtRole);
        roleTxt.setText(person.getRole());

        TextView alTxt = (TextView) findViewById(R.id.txtAL);
        alTxt.setText(person.getAl());

        TextView phoneTxt = (TextView) findViewById(R.id.txtPhone);
        phoneTxt.setText(person.getPhone());

        TextView emailTxt = (TextView) findViewById(R.id.txtEmail);
        emailTxt.setText(person.getEmail());

        TextView uniTxt= (TextView) findViewById(R.id.unitxt);
        uniTxt.setText(person.getUniversity());

    }

    private Person getPeople(ArrayList<Person> input) {
        Person toBeReturned= null;
        for (int i = 0; i < input.size(); i++) {
            Person check = (Person) input.get(i);
            String check1 = check.getFirstName() + " " + check.getLastName() + " " + check.getLocation();
            if (check1.equals(nameToDisplay)) {
                toBeReturned=check;
            }
        }
        return toBeReturned;
    }
}



