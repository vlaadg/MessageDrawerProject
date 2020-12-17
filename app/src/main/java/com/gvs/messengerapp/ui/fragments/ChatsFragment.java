package com.gvs.messengerapp.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gvs.messengerapp.R;
import com.gvs.messengerapp.databinding.FragmentChatsBinding;
import com.gvs.messengerapp.databinding.FragmentSettingsBinding;


public class ChatsFragment extends Fragment {

    private FragmentChatsBinding mBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentChatsBinding.inflate(getLayoutInflater());
        return mBinding.getRoot();

    }
    @Override
    public void onResume() {
        super.onResume();
    }
}