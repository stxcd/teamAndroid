package com.syfblp.sas.blpappv2.directory;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.syfblp.sas.blpappv2.R;

import static com.syfblp.sas.blpappv2.directory.DirectoryFragment.KEY_AL;
import static com.syfblp.sas.blpappv2.directory.DirectoryFragment.KEY_EMAIL;
import static com.syfblp.sas.blpappv2.directory.DirectoryFragment.KEY_FIRSTNAME;
import static com.syfblp.sas.blpappv2.directory.DirectoryFragment.KEY_FUNCTION;
import static com.syfblp.sas.blpappv2.directory.DirectoryFragment.KEY_LASTNAME;
import static com.syfblp.sas.blpappv2.directory.DirectoryFragment.KEY_LOCATION;
import static com.syfblp.sas.blpappv2.directory.DirectoryFragment.KEY_PHONE;
import static com.syfblp.sas.blpappv2.directory.DirectoryFragment.KEY_ROLE;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String firstName = "";
        String lastName = "";
        String location = "";
        String function = "";
        String role = "";
        String al = "";
        String phone = "";
        String email = "";

        Intent intent = getIntent();
        if(null != intent) {
            firstName = intent.getStringExtra(KEY_FIRSTNAME);
            lastName = intent.getStringExtra(KEY_LASTNAME);
            location = intent.getStringExtra(KEY_LOCATION);
            function = intent.getStringExtra(KEY_FUNCTION);
            role = intent.getStringExtra(KEY_ROLE);
            al = intent.getStringExtra(KEY_AL);
            phone = intent.getStringExtra(KEY_PHONE);
            email = intent.getStringExtra(KEY_EMAIL);
        }

        TextView firstLastNameTxt = (TextView) findViewById(R.id.txtFirstLastName);
        firstLastNameTxt.setText(firstName + " " + lastName);

        TextView FunctionLocationTxt = (TextView) findViewById(R.id.txtFunctionLocation);
        FunctionLocationTxt.setText(function + "  |  " + location);

        TextView roleTxt = (TextView) findViewById(R.id.txtRole);
        roleTxt.setText(role);

        TextView alTxt = (TextView) findViewById(R.id.txtAL);
        alTxt.setText(al);

        TextView phoneTxt = (TextView) findViewById(R.id.txtPhone);
        phoneTxt.setText(phone);

        TextView emailTxt = (TextView) findViewById(R.id.txtEmail);
        emailTxt.setText(email);

    }



}
