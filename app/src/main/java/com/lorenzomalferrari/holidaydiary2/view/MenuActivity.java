package com.lorenzomalferrari.holidaydiary2.view;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.lorenzomalferrari.holidaydiary2.R;
import com.lorenzomalferrari.holidaydiary2.control.Controller;
import com.lorenzomalferrari.holidaydiary2.control.DatabaseHelper;
import com.lorenzomalferrari.holidaydiary2.control.UserSessionManager;

public class MenuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //
    Controller controller;
    //
    Dialog myDialog;
    UserSessionManager userSessionManager;
    DatabaseHelper databaseHelper;

    //
    //FloatingActionMenu floatingActionMenu;
    FloatingActionButton travel,note,picture,place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        controller = new Controller();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Check UserSessionManager
        checkUserSession();
        // Inizializzazione dei componenti
        init();
    }

    /**
     * Inizializzazione degli attributi dei componenti
     */
    private void init() {
        //floatingActionMenu = findViewById(R.id.floatingActionMenu);
        //travel = findViewById(R.id.floatingActionButtonTravel);
        //note = findViewById(R.id.floatingActionButtonNote);
        //picture = findViewById(R.id.floatingActionButtonPicture);
        //place = findViewById(R.id.floatingActionButtonPlace);
    }


    /**
     * Controllo i dati della sessione utente
     */
    private void checkUserSession(){
        // Session class instance
        userSessionManager = new UserSessionManager(getApplicationContext());

        /*
        Toast.makeText(
                        getApplicationContext(),
                        "User Login Status: " + userSessionManager.isUserLoggedIn(),
                        Toast.LENGTH_LONG)
                    .show();
        */
        // Check user login
        // If User is not logged in , This will redirect user to LoginActivity.
        if(userSessionManager.checkLogin()) finish();
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
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            //Eseguo il logout
            userSessionManager.logoutUser();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
