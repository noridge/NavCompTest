package com.example.navcomptest;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.navcomptest.databinding.FragmentOneBinding;

public class FragmentOne extends Fragment {

    private static final String LOG_TAG = FragmentOne.class.getSimpleName();
    private FragmentOneBinding fragmentOneBinding;
    private NavController navController;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(LOG_TAG, "onCreate");
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_overflow, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_show_toast:
                Log.d(LOG_TAG, "Show toast");
                Toast.makeText(getContext(), "Hello", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(LOG_TAG, "onCreateView");
        setHasOptionsMenu(true);
        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
        fragmentOneBinding = FragmentOneBinding.inflate(inflater, container, false);
        fragmentOneBinding.buttonNext.setOnClickListener(onClickListener);
        fragmentOneBinding.buttonGotoFragmentTwo.setOnClickListener(onClickListener);
        fragmentOneBinding.buttonGotoFragmentThree.setOnClickListener(onClickListener);
        fragmentOneBinding.buttonGotoFragmentFour.setOnClickListener(onClickListener);
        return fragmentOneBinding.getRoot();
    }

    @Override
    public void onResume() {
        Log.d(LOG_TAG, "onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.d(LOG_TAG, "onPause");
        super.onPause();
    }

    @Override
    public void onDestroyView() {
        Log.d(LOG_TAG, "onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.d(LOG_TAG, "onDestroy");
        super.onDestroy();
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button_next:
                case R.id.button_gotoFragmentTwo:
                    navController.navigate(R.id.action_fragmentOne_to_fragmentTwo);
                    break;
                case R.id.button_gotoFragmentThree:
                    navController.navigate(R.id.action_fragmentOne_to_fragmentThree);
                    break;
                case R.id.button_gotoFragmentFour:
                    navController.navigate(R.id.action_fragmentOne_to_fragmentFour);
                    break;
            }
        }
    };
}
