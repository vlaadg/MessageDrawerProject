package com.gvs.messengerapp.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.gvs.messengerapp.databinding.FragmentQuitBinding;

public class QuitFragment extends Fragment {
    private FragmentQuitBinding mBinding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentQuitBinding.inflate(getLayoutInflater());
        return mBinding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}