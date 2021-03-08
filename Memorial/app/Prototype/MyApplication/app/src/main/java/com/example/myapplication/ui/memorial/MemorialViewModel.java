package com.example.myapplication.ui.memorial;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MemorialViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MemorialViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is memorial fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}