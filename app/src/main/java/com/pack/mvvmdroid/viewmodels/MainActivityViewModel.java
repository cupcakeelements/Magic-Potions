package com.pack.mvvmdroid.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.pack.mvvmdroid.models.NicePlace;
import com.pack.mvvmdroid.repositories.NicePlaceRepository;

import java.util.List;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<List<NicePlace>> mNicePlaces;
    private NicePlaceRepository niceRepo;

    public LiveData<List<NicePlace>> getmNicePlaces() {
        return mNicePlaces;
    }

    public void init(){
        if(mNicePlaces != null ){
            return;
        }
        niceRepo = NicePlaceRepository.getInstance();
        mNicePlaces = niceRepo.getNicePlaces();
    }
}
