package com.syfblp.sas.blpappv2.directory;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.syfblp.sas.blpappv2.R;

import java.util.ArrayList;


public class Profile extends AppCompatActivity {
    ArrayList<Person> tobedispayedList= new ArrayList<>();
    ArrayList<Person> input= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_profile);
        Intent incomingIntent = this.getIntent();
        input=(ArrayList<Person>)incomingIntent.getSerializableExtra("json");
        String nameToDisplay = (String)incomingIntent.getStringExtra("lookingfor");

        String firstName = "";
        String lastName = "";
        String location = "";
        String function = "";
        String role = "";
        String al = "";
        String phone = "";
        String email = "";
        String university="";

        Person person= findPerson(nameToDisplay,input);

            firstName = person.getFirstName();
            lastName = person.getLastName();
            location = person.getLocation();
            function = person.getFunction();
            role = person.getRole();
            al = person.getAl();
            phone = person.getPhone();
            email = person.getEmail();
            university=person.getUniversity();

        TextView firstLastNameTxt = (TextView) findViewById(R.id.txtFirstLastName);
        firstLastNameTxt.setText(firstName + " " + lastName);

        TextView FunctionLocationTxt = (TextView) findViewById(R.id.txtFunctionLocation);
        FunctionLocationTxt.setText(function + "  |  " + location);

        TextView roleTxt = (TextView) findViewById(R.id.txtRole);
        roleTxt.setText(role);

        TextView alTxt = (TextView) findViewById(R.id.txtAL);
        alTxt.setText(al);

        TextView uniTxt= (TextView) findViewById(R.id.txtuniversity);
        uniTxt.setText(university);

        TextView phoneTxt = (TextView) findViewById(R.id.txtPhone);
        phoneTxt.setText(phone);

        TextView emailTxt = (TextView) findViewById(R.id.txtEmail);
        emailTxt.setText(email);

    }

    private Person findPerson(String nameToDisplay, ArrayList<Person> input) {
        Person tobeDisplayed = null;
        for (int i= 0; i<input.size();i++){
            Person person=input.get(i);
            String test= person.getFirstName()+" "+person.getLastName()+" "+person.getLocation();
            if (test.equals(nameToDisplay)){
                tobeDisplayed=person;
            }

        }
        return tobeDisplayed;

    }


}
