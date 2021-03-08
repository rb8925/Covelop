package com.example.myapplication.ui.ossuary;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.ui.memorial.MemorialViewModel;

public class OssuaryFragment extends Fragment {

    private OssuaryViewModel ossuaryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ossuaryViewModel =
                new ViewModelProvider(this).get(OssuaryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_ossuary, container, false);
        final TextView textView = root.findViewById(R.id.text_ossuary);
        ossuaryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}