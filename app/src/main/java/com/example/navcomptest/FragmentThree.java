package com.example.navcomptest;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;


import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.navcomptest.databinding.FragmentThreeBinding;

public class FragmentThree extends Fragment {

    private static final String LOG_TAG = FragmentThree.class.getSimpleName();
    private FragmentThreeBinding fragmentThreeBinding;
    private NavController navController;
    private Toolbar activityToolbar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(LOG_TAG, "onCreate");
        requireActivity().getOnBackPressedDispatcher().addCallback(this, onBackPressedCallback);
        onBackPressedCallback.setEnabled(false);
        activityToolbar = getActivity().findViewById(R.id.toolbar);
        activityToolbar.setNavigationOnClickListener(v -> onNavUpClicked());
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(LOG_TAG, "onCreateView");
        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
        fragmentThreeBinding = FragmentThreeBinding.inflate(inflater, container, false);
        fragmentThreeBinding.buttonNext.setOnClickListener(onClickListener);
        fragmentThreeBinding.buttonGotoFragmentOne.setOnClickListener(onClickListener);
        fragmentThreeBinding.buttonGotoFragmentTwo.setOnClickListener(onClickListener);
        fragmentThreeBinding.buttonGotoFragmentFour.setOnClickListener(onClickListener);
        fragmentThreeBinding.switch1.setOnCheckedChangeListener(onCheckedChangeListener);
        return fragmentThreeBinding.getRoot();
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

    CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                onBackPressedCallback.setEnabled(true);
            } else {
                onBackPressedCallback.setEnabled(false);
            }
        }
    };

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button_gotoFragmentOne:
                    navController.navigate(R.id.action_fragmentThree_to_fragmentOne);
                    break;
                case R.id.button_gotoFragmentTwo:
                    navController.navigate(R.id.action_fragmentThree_to_fragmentTwo);
                    break;
                case R.id.button_next:
                case R.id.button_gotoFragmentFour:
                    navController.navigate(R.id.action_fragmentThree_to_fragmentFour);
                    break;
            }
        }
    };

    OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback(true /* enabled by default */) {
        @Override
        public void handleOnBackPressed() {
            Log.d(LOG_TAG, "handleOnBackPressed");
            fragmentThreeBinding.switch1.setChecked(false);
        }
    };

    public void onNavUpClicked() {
        if (fragmentThreeBinding.switch1.isChecked()) {
            fragmentThreeBinding.switch1.setChecked(false);
        } else {
            navController.popBackStack();
        }
    }
}
