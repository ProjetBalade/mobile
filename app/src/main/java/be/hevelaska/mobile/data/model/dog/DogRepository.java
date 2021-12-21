package be.hevelaska.mobile.data.model.dog;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;
import java.util.Objects;

import be.hevelaska.mobile.data.model.ride.DtoCreateRide;
import be.hevelaska.mobile.data.model.ride.DtoRides;
import be.hevelaska.mobile.infrastructure.IDogsService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DogRepository {

    private static volatile DogRepository instance;

    private final IDogsService dataSource;

    private final MutableLiveData<List<DtoDog>> dogsList;

    private DogRepository(IDogsService dataSource) {
        this.dataSource = dataSource;
        this.dogsList = new MutableLiveData<>();
    }

    public static DogRepository getInstance(IDogsService dataSource) {
        if (instance == null) {
            instance = new DogRepository(dataSource);
        }
        return instance;
    }

    public LiveData<List<DtoDog>> getDogsList() {
        return dogsList;
    }

    public void loadDogs() {
        this.loadDogs(null, null);
    }

    public void loadDogs(Runnable success , Runnable error) {
        this.dataSource.getAll()
                .enqueue(new Callback<List<DtoDog>>() {
                    @Override
                    public void onResponse(Call<List<DtoDog>> call, Response<List<DtoDog>> response) {
                        dogsList.setValue(response.body());
                        if(success != null) success.run();
                    }

                    @Override
                    public void onFailure(Call<List<DtoDog>> call, Throwable t) {
                        if(error != null) error.run();
                    }
                });
    }

    public void createDog(DtoCreateDog dtoCreateDog, Runnable success , Runnable error){
        this.dataSource.create(dtoCreateDog)
                .enqueue(new Callback<DtoDog>() {
                    @Override
                    public void onResponse(Call<DtoDog> call, Response<DtoDog> response) {
                        if(response.code() == 201) {
                            Objects.requireNonNull(dogsList.getValue()).add(response.body());
                            dogsList.setValue(dogsList.getValue());
                            if(success != null) success.run();
                        }
                        else {
                            if(error != null) error.run();
                        }

                    }

                    @Override
                    public void onFailure(Call<DtoDog> call, Throwable t) {
                        if(error != null) error.run();
                    }
                });

    }


}
