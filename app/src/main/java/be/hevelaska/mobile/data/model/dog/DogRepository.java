package be.hevelaska.mobile.data.model.dog;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

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
        this.dogsList = new MutableLiveData<>(new ArrayList<>());
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
                        if(response.code() == 200) {
                            dogsList.setValue(response.body());
                            if(success != null) success.run();
                        }
                        else {
                            if(error != null) error.run();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<DtoDog>> call, Throwable t) {
                        if(error != null) error.run();
                    }
                });
    }

}
