package com.lorenzomalferrari.holidaydiary2.view;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.github.clans.fab.FloatingActionMenu;
import com.github.clans.fab.FloatingActionButton;
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
    FloatingActionMenu floatingActionMenu;
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
        //Esecuzione dei bottoni
        actionTravel();
        actionNote();
        actionPicture();
        actionPlace();
    }

    /**
     * Inizializzazione degli attributi dei componenti
     */
    private void init() {
        floatingActionMenu = findViewById(R.id.floatingActionMenu);
        travel = findViewById(R.id.floatingActionButtonTravel);
        note = findViewById(R.id.floatingActionButtonNote);
        picture = findViewById(R.id.floatingActionButtonPicture);
        place = findViewById(R.id.floatingActionButtonPlace);
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
        //calling the method displayselectedscreen and passing the id of selected menu
        displaySelectedScreen(item.getItemId());
        //make this method blank
        return true;
    }

    /**
     * Compilo le chiamate delle voci presenti nel menù
     * @param itemId
     */
    private void displaySelectedScreen(int itemId) {
        //creating fragment object
        Fragment fragment = null;
        //creating intent object
        Intent intent;
        //initializing the fragment object which is selected
        switch (itemId) {
            case R.id.nav_homepage:
                break;
            case R.id.nav_travels:
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.content_frame,new TravelsFragment()).commit();
                break;
            case R.id.nav_notes:
                break;
            case R.id.nav_pictures:
                break;
            case R.id.nav_places:
                break;
            case R.id.nav_account:
                break;
            case R.id.nav_settings:
                break;
            case R.id.nav_privacytermsofuse:
                break;
            case R.id.nav_infoApp:
                break;
        }

        //replacing the fragment
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    /**
     * Chiamo l'attività per visualizzare la lista dei viaggi
     */
    private void actionTravel(){
        travel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                //ft.replace(R.id.content_frame, new AddTravelFragment()).commit();
                // Pulisco la visualizzazione dei bottoni
                closeFloatingActionMenu();
            }
        });
    }

    /**
     * Chiamo l'attività per visualizzare la lista delle note
     */
    private void actionNote(){
        note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Pulisco la visualizzazione dei bottoni
                closeFloatingActionMenu();
            }
        });
    }

    /**
     * Chiamo l'attività per visualizzare la lista delle immagini
     */
    private void actionPicture(){
        picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Pulisco la visualizzazione dei bottoni
                closeFloatingActionMenu();
            }
        });
    }

    /**
     * Chiamo l'attività per visualizzare la lista dei luoghi
     */
    private void actionPlace(){
        place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Pulisco la visualizzazione dei bottoni
                closeFloatingActionMenu();
            }
        });
    }

    /**
     * Chiudo il menu
     */
    private void closeFloatingActionMenu(){
        floatingActionMenu.setAnimated(false);
        floatingActionMenu.close(false);
    }

}
