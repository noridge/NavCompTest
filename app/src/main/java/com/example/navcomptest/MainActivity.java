package com.example.navcomptest;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.navcomptest.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private NavController navController;
    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(LOG_TAG, "onCreate");
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());/*
        Use toolbar as the action bar.
        Use a textview as a replacement for the toolbar's title.
         */
        Toolbar toolbar = activityMainBinding.toolbar;
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        DrawerLayout drawerLayout = activityMainBinding.drawerLayout;
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration
                .Builder(navController.getGraph())
                .setOpenableLayout(drawerLayout)
                .build();
        NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration);
        NavigationView navigationView = activityMainBinding.navView;
        NavigationUI.setupWithNavController(navigationView, navController);
        navController.addOnDestinationChangedListener(onDestinationChangedListener);
    }

    @Override
    protected void onResume() {
        Log.d(LOG_TAG, "onResume");
        super.onResume();
    }

    @Override
    public void onBackPressed() {
        Log.d(LOG_TAG, "onBackPressed");
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        Log.d(LOG_TAG, "onPause");
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        Log.d(LOG_TAG, "onDestroy");
        super.onDestroy();
    }

    NavController.OnDestinationChangedListener onDestinationChangedListener = new NavController.OnDestinationChangedListener() {
        @Override
        public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
            switch (destination.getId()) {
                case R.id.fragmentOne:
                    activityMainBinding.toolbarTitle.setText("Fragment One");
                    break;
                case R.id.fragmentTwo:
                    activityMainBinding.toolbarTitle.setText("Fragment Two");
                    break;
                case R.id.fragmentThree:
                    activityMainBinding.toolbarTitle.setText("Fragment Three");
                    break;
                case R.id.fragmentFour:
                    activityMainBinding.toolbarTitle.setText("Fragment Four");
                    break;
                default:
                    Log.w(LOG_TAG, "Unknown destination fragment");
                    break;
            }
        }
    };
}