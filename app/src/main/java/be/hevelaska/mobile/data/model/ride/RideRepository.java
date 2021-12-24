package be.hevelaska.mobile.data.model.ride;

import androidx.core.util.Consumer;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import be.hevelaska.mobile.infrastructure.IRidesService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RideRepository {
    private static volatile RideRepository instance;

    private final IRidesService dataSource;

    private final MutableLiveData<List<DtoRides>> ridesList;

    private RideRepository(IRidesService dataSource) {
        this.dataSource = dataSource;
        this.ridesList = new MutableLiveData<>(new ArrayList<>());
    }

    public static RideRepository getInstance(IRidesService dataSource) {
        if (instance == null) {
            instance = new RideRepository(dataSource);
        }
        return instance;
    }

    public LiveData<List<DtoRides>> getRidesList() {
        return ridesList;
    }

    public void reloadRides() {
        this.reloadRides(null, null);
    }

    public void reloadRides(Runnable success , Runnable error) {
        this.dataSource.getAll()
                .enqueue(new Callback<List<DtoRides>>() {
                    @Override
                    public void onResponse(Call<List<DtoRides>> call, Response<List<DtoRides>> response) {
                        ridesList.setValue(response.body());
                        if(success != null) success.run();
                    }

                    @Override
                    public void onFailure(Call<List<DtoRides>> call, Throwable t) {
                        if(error != null) error.run();
                    }
                });
    }

    public void createRides(DtoCreateRide dtoCreateRide, Runnable success , Runnable error){
        this.dataSource.create(dtoCreateRide)
                .enqueue(new Callback<DtoRides>() {
                    @Override
                    public void onResponse(Call<DtoRides> call, Response<DtoRides> response) {
                        if(response.code() == 201) {
                            Objects.requireNonNull(ridesList.getValue()).add(response.body());
                            ridesList.setValue(ridesList.getValue());
                            if(success != null) success.run();
                        }
                        else {
                            if(error != null) error.run();
                        }

                    }

                    @Override
                    public void onFailure(Call<DtoRides> call, Throwable t) {
                        if(error != null) error.run();
                    }
                });

    }



}
