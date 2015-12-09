package com.syfblp.sas.blpappv2;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.syfblp.sas.blpappv2.announcements.AnnouncementsFragment;
import com.syfblp.sas.blpappv2.directory.DirectoryFragment;
import com.syfblp.sas.blpappv2.events.EventFragment;
import com.syfblp.sas.blpappv2.housing.HousingFragment;

import static com.syfblp.sas.blpappv2.R.id.nav_home;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FragmentManager fragmentManager=getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame,new AnnouncementsFragment()).commit();
        setTitle("Announcements");




    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fragmentManager=getFragmentManager();


        if (id == nav_home) {
            // makes the home fragment
            AnnouncementsFragment.newInstance();
            fragmentManager.beginTransaction().replace(R.id.content_frame,new AnnouncementsFragment()).commit();
        } else if (id == R.id.nav_directory) {
            DirectoryFragment.newInstance();
            fragmentManager.beginTransaction().replace(R.id.content_frame,new DirectoryFragment()).commit();

        } else if (id == R.id.nav_event) {
            EventFragment.newInstance();
            fragmentManager.beginTransaction().replace(R.id.content_frame,new EventFragment()).commit();

        } else if (id == R.id.nav_housing) {
            HousingFragment.newInstance();
            fragmentManager.beginTransaction().replace(R.id.content_frame,new HousingFragment()).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        setTitle(item.getTitle());
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void Test(View view) {
        Toast.makeText(this, "Test", Toast.LENGTH_LONG).show();
    }


}

