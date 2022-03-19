package com.example.navidrawertest.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("첫 번째 프래그먼트입니다. ");
    }

    public LiveData<String> getText() {
        return mText;
    }
}