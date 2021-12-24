package be.hevelaska.mobile.ui.gestionDog;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import be.hevelaska.mobile.data.LoginDataSource;
import be.hevelaska.mobile.data.LoginRepository;
import be.hevelaska.mobile.data.model.dog.DogRepository;
import be.hevelaska.mobile.data.model.dog.DtoDog;
import be.hevelaska.mobile.infrastructure.IDogsService;
import be.hevelaska.mobile.infrastructure.RetrofitWrapper;

public class UpdateDogViewModel {
    private int id;
    private MutableLiveData<String> nameDog;
    private MutableLiveData<String> raceDog;
    private MutableLiveData<String> dateOfBirth;
    private int idUser;

    private final DogRepository repository;
    private final LoginRepository loginRepository;

    public UpdateDogViewModel() {
        this.loginRepository = LoginRepository.getInstance(new LoginDataSource());
        this.repository = DogRepository.getInstance(RetrofitWrapper.getInstance().create(IDogsService.class));

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNameDog(String nameDog) {
        if(this.nameDog == null) this.nameDog = new MutableLiveData<>(nameDog);
        this.nameDog.setValue(nameDog);
    }

    public void setRaceDog(String raceDog) {
        if(this.raceDog == null) this.raceDog = new MutableLiveData<>(raceDog);

        this.raceDog.setValue(raceDog);
    }

    public void setDateOfBirth(String dateOfBirth) {
        if(this.dateOfBirth == null) this.dateOfBirth = new MutableLiveData<>(dateOfBirth);

        this.dateOfBirth.setValue(dateOfBirth);
    }

    public void setIdUser(int idUser) {

        this.idUser = idUser;
    }

    public void updateDog(Runnable success, Runnable error){
        repository.updateDog(new DtoDog(id, nameDog.getValue(), raceDog.getValue(), dateOfBirth.getValue(), idUser),success,error);
    }



    public MutableLiveData<String> getNameDog() {
        return nameDog;
    }

    public MutableLiveData<String> getRaceDog() {
        return raceDog;
    }

    public MutableLiveData<String> getDateOfBirth() {
        return dateOfBirth;
    }


}
