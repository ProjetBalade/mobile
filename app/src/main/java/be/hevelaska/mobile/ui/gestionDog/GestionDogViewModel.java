package be.hevelaska.mobile.ui.gestionDog;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import be.hevelaska.mobile.data.LoginDataSource;
import be.hevelaska.mobile.data.LoginRepository;
import be.hevelaska.mobile.data.model.dog.DogRepository;
import be.hevelaska.mobile.data.model.dog.DtoCreateDog;
import be.hevelaska.mobile.data.model.dog.DtoDog;
import be.hevelaska.mobile.data.model.ride.RideRepository;
import be.hevelaska.mobile.infrastructure.IDogsService;
import be.hevelaska.mobile.infrastructure.IRidesService;
import be.hevelaska.mobile.infrastructure.RetrofitWrapper;

public class GestionDogViewModel extends ViewModel {
    private int id;
    private String nameDog;
    private String raceDog;
    private String dateOfBirth;
    private int idUser;

    private final DogRepository repository;
    private final LoginRepository loginRepository;

    public GestionDogViewModel() {
        this.loginRepository = LoginRepository.getInstance(new LoginDataSource());
        this.repository = DogRepository.getInstance(RetrofitWrapper.getInstance().create(IDogsService.class));

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNameDog(String nameDog) {
        this.nameDog = nameDog;
    }

    public void setRaceDog(String raceDog) {
        this.raceDog = raceDog;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public LiveData<List<DtoDog>> getDogs(){
        return  repository.getDogsList();
    }

    public void load(){
        repository.loadDogs();
    }

    public void addDog(Runnable success, Runnable error) {
        DtoCreateDog dtoCreateDog = new DtoCreateDog(nameDog, raceDog, dateOfBirth);
        this.repository.createDog(dtoCreateDog, success, error);
    }

    public void deleteDog(int id,Runnable success, Runnable error){
        repository.deleteDog(id,success,error);
    }

    public void updateDog(Runnable success, Runnable error){
        repository.updateDog(new DtoDog(id, nameDog, raceDog, dateOfBirth, idUser),success,error);
    }
}
