package com.syfblp.sas.testfortab.directory;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.syfblp.sas.testfortab.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


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

        final Person person = getPeople(input);

        CircleImageView profImg = (CircleImageView) findViewById(R.id.profile_image);
        profImg.;
        //profImg.setImageResource(img);
        getProfImg();

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

        TextView uniTxt = (TextView) findViewById(R.id.txtUniv);
        uniTxt.setText(person.getUniversity());

        View buttonView = findViewById(R.id.btnCall);
        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + person.getPhone()));
                startActivity(intent);
            }
        });
    }

    private Person getPeople(ArrayList<Person> input) {
        Person toBeReturned = null;
        for (int i = 0; i < input.size(); i++) {
            Person check = (Person) input.get(i);
            String check1 = check.getFirstName() + " " + check.getLastName() + "- " + check.getLocation();
            if (check1.equals(nameToDisplay)) {
                toBeReturned = check;
            }
        }
        return toBeReturned;
    }

    private void getProfImg() {

        //for (int i = 0; i < input.size(); i++) {
        //Person check = (Person) input.get(i);
            String mDrawableName = person.getLastName().toLowerCase() + ".jpg";
            //int img = this.getResources().getIdentifier(mDrawableName, "drawable", this.getPackageName());
            //return img;

            CircleImageView profImage = (CircleImageView) findViewById(R.id.profile_image);
            Context context = profImage.getContext();
            int id = context.getResources().getIdentifier(mDrawableName, "drawable", context.getPackageName());
            profImage.setImageResource(id);

            /*
            int resID = getResources().getIdentifier(resourceName, "id", getPackageName());

            ImageView im = (ImageView) findViewById(resID);
            Context context = im.getContext();
            int id = context.getResources().getIdentifier(resourceName, "drawable",
                    context.getPackageName());
            im.setImageResource(id); */
        }
    }
}



