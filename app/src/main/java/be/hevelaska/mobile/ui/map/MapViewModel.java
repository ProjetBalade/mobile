package be.hevelaska.mobile.ui.map;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import be.hevelaska.mobile.data.model.ride.DtoRides;
import be.hevelaska.mobile.data.model.ride.RideRepository;
import be.hevelaska.mobile.infrastructure.IRidesService;
import be.hevelaska.mobile.infrastructure.RetrofitWrapper;

public class MapViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private RideRepository repository;


    public MapViewModel() {
        mText = new MutableLiveData<>();
        this.repository = RideRepository.getInstance(RetrofitWrapper.getInstance().create(IRidesService.class));
    }

    public LiveData<List<DtoRides>> getRideList() {
        return repository.getRidesList();
    }

    public LiveData<String> getText() {
        return mText;
    }
}