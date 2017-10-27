package com.example.nautatvanavlakha.abcd;


import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class FirstActivity extends AppCompatActivity {

    DrawerLayout mDrawer;
    ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_clicked);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);    //removes the package name from toolbar

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            Window w = getWindow(); // in Activity's onCreate() for instance          //Integration of app into status bar
//            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
//        }

        // These lines are needed to display the top-left hamburger button
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        // Make the hamburger button work
        mDrawer = (DrawerLayout) findViewById(R.id.DL);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawer, R.string.app_name, R.string.app_name) {
            @Override
            public void onDrawerClosed(View drawerView) {
            }

            @Override
            public void onDrawerOpened(View drawerView) {
            }
        };
        mDrawer.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        // toasts the message when ListView item is clicked
        ListView mDrawerListView = (ListView) findViewById(R.id.left_drawer);
        mDrawerListView.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String drawerstring = ("Menu Item at position " + position + " clicked.");
                mDrawer.closeDrawer(GravityCompat.START);
                Toast.makeText(getApplicationContext(), drawerstring, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.DL);
        if (drawer != null && drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle your other action bar items...
        return super.onOptionsItemSelected(item);
    }

    public void MainProcess(View view) {

        final String TAG = "DEBUG";

        EditText owner = (EditText) findViewById(R.id.name);
        String owner_string = owner.getText().toString();

        setContentView(R.layout.activity_main_screen);

        TextView custom = (TextView) findViewById(R.id.welcome);
        custom.setText("Hi " + owner_string + ".");
        Log.d(TAG, "owner name is set");

        Log.d(TAG, "content shown");
    }

    public void toaster() {
        EditText toast = (EditText) findViewById(R.id.toastText);
        String final_toast = toast.getText().toString();
        Toast.makeText(getApplicationContext(), final_toast, Toast.LENGTH_SHORT).show();
    }

    public void open_camera() {
        Intent Intent3=new   Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
        startActivity(Intent3);
    }
}