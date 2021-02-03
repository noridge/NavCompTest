package com.example.navcomptest;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.navcomptest.databinding.FragmentFourBinding;

public class FragmentFour extends Fragment {

    private static final String LOG_TAG = FragmentFour.class.getSimpleName();
    private FragmentFourBinding fragmentFourBinding;
    private NavController navController;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(LOG_TAG, "onCreate");
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(LOG_TAG, "onCreateView");
        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
        fragmentFourBinding = FragmentFourBinding.inflate(inflater, container, false);
        fragmentFourBinding.buttonGotoFragmentOne.setOnClickListener(onClickListener);
        fragmentFourBinding.buttonGotoFragmentTwo.setOnClickListener(onClickListener);
        fragmentFourBinding.buttonGotoFragmentThree.setOnClickListener(onClickListener);
        return fragmentFourBinding.getRoot();
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
                case R.id.button_gotoFragmentOne:
                    navController.navigate(R.id.action_fragmentFour_to_fragmentOne);
                    break;
                case R.id.button_gotoFragmentTwo:
                    navController.navigate(R.id.action_fragmentFour_to_fragmentTwo);
                    break;
                case R.id.button_gotoFragmentThree:
                    navController.navigate(R.id.action_fragmentFour_to_fragmentThree);
                    break;
            }
        }
    };
}
