package com.pack.mvvmdroid.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.pack.mvvmdroid.models.NicePlace;

import java.util.ArrayList;
import java.util.List;

public class NicePlaceRepository {

    private static NicePlaceRepository nicePlaceInstance;
    private ArrayList<NicePlace> nicePlaceArrayList = new ArrayList<>();


    public static  NicePlaceRepository getInstance(){

        if(nicePlaceInstance==null){
            nicePlaceInstance = new NicePlaceRepository();
        }
        return nicePlaceInstance;
    }


    public MutableLiveData<List<NicePlace>> getNicePlaces(){
        initDataSource();
        MutableLiveData<List<NicePlace>> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(nicePlaceArrayList);
        return mutableLiveData;
    }


    private void initDataSource() {
        NicePlace nicePlaceObject;
        nicePlaceObject = new NicePlace("Sands", "https://www.fujifilm.com/products/digital_cameras/x/fujifilm_x_t3/sample_images/img/index/pic_01.jpg");
        nicePlaceArrayList.add(nicePlaceObject);
        nicePlaceObject = new NicePlace("Cycling track", "https://www.fujifilm.com/products/digital_cameras/x/fujifilm_x_t3/sample_images/img/index/pic_02.jpg");
        nicePlaceArrayList.add(nicePlaceObject);
        nicePlaceObject = new NicePlace("Surfing seas", "https://www.fujifilm.com/products/digital_cameras/x/fujifilm_x_t3/sample_images/img/index/pic_03.jpg");
        nicePlaceArrayList.add(nicePlaceObject);
        nicePlaceObject = new NicePlace("London Market", "https://www.fujifilm.com/products/digital_cameras/x/fujifilm_x_t3/sample_images/img/index/pic_04.jpg");
        nicePlaceArrayList.add(nicePlaceObject);
        nicePlaceObject = new NicePlace("Race Track", "https://www.fujifilm.com/products/digital_cameras/x/fujifilm_x_t3/sample_images/img/index/pic_06.jpg");
        nicePlaceArrayList.add(nicePlaceObject);
    }
}
