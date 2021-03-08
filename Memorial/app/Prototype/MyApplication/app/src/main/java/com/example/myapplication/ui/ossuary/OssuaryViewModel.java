package com.example.myapplication.ui.ossuary;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OssuaryViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public OssuaryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Ossuary fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}