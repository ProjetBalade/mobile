package be.hevelaska.mobile.ui.addride;

import androidx.lifecycle.ViewModel;

import be.hevelaska.mobile.data.LoginDataSource;
import be.hevelaska.mobile.data.LoginRepository;
import be.hevelaska.mobile.data.model.ride.DtoCreateRide;
import be.hevelaska.mobile.data.model.ride.RideRepository;
import be.hevelaska.mobile.infrastructure.IRidesService;
import be.hevelaska.mobile.infrastructure.RetrofitWrapper;

public class AddRideViewModel extends ViewModel {

    private String nameRide;
    private String place;
    private String description;
    private String website;
    private int difficulty;
    private String schedule;
    private String photo;
    private int score;
    private double longitude;
    private double latitude;

    private final LoginRepository loginRepository;
    private final RideRepository repository;

    public AddRideViewModel() {
        this.loginRepository = LoginRepository.getInstance(new LoginDataSource());
        this.repository = RideRepository.getInstance(RetrofitWrapper.getInstance().create(IRidesService.class));
    }

    public void setNameRide(String nameRide) {
        this.nameRide = nameRide;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setLongitude(double longitude) { this.longitude = longitude; }

    public void setLatitude(double latitude) { this.latitude = latitude; }

    public void createRide(Runnable success, Runnable error) {
        DtoCreateRide dto = new DtoCreateRide(nameRide, place, description, website, difficulty, schedule,score);
        this.repository.createRides(dto, success, error);
    }
}
