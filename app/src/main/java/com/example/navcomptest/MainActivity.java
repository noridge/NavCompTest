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

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private NavController navController;
    private ActivityMainBinding activityMainBinding;
    private Toolbar toolbar;
    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(LOG_TAG, "onCreate");
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        DrawerLayout drawerLayout = activityMainBinding.drawerLayout;
        Set<Integer> topLevelDestinations = new HashSet<>();
        topLevelDestinations.add(R.id.fragmentHome);
        topLevelDestinations.add(R.id.fragmentOne);
        topLevelDestinations.add(R.id.fragmentAbout);
        appBarConfiguration = new AppBarConfiguration
                .Builder(topLevelDestinations)
                .setOpenableLayout(drawerLayout)
                .build();
        /*
        Use toolbar as the action bar.
        Use a textview as a replacement for the toolbar's title.
         */
        toolbar = activityMainBinding.toolbar;
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
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
                    NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration);
                    break;
                case R.id.fragmentTwo:
                    activityMainBinding.toolbarTitle.setText("Fragment Two");
                    NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration);
                    break;
                case R.id.fragmentThree:
                    activityMainBinding.toolbarTitle.setText("Fragment Three");
                    break;
                case R.id.fragmentFour:
                    activityMainBinding.toolbarTitle.setText("Fragment Four");
                    NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration);
                    break;
                case R.id.fragmentAbout:
                    activityMainBinding.toolbarTitle.setText("About");
                    NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration);
                    break;
                case R.id.fragmentHome:
                    activityMainBinding.toolbarTitle.setText("Home");
                    NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration);
                    break;
                default:
                    Log.w(LOG_TAG, "Unknown destination fragment");
                    break;
            }
        }
    };
}