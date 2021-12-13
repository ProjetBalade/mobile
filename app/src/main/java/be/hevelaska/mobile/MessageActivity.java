package be.hevelaska.mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import be.hevelaska.mobile.databinding.ActivityMessageBinding;
import be.hevelaska.mobile.dto.dog.DtoCreateDog;
import be.hevelaska.mobile.dto.dog.DtoDogs;
import be.hevelaska.mobile.dto.message.DtoMessages;
import be.hevelaska.mobile.dto.ride.DtoCreateRide;
import be.hevelaska.mobile.dto.ride.DtoRides;
import be.hevelaska.mobile.dto.user.DtoCreateUser;
import be.hevelaska.mobile.dto.user.DtoUser;
import be.hevelaska.mobile.infrastructure.IDogsService;
import be.hevelaska.mobile.infrastructure.IMessagesService;
import be.hevelaska.mobile.infrastructure.IRidesService;
import be.hevelaska.mobile.infrastructure.IUsersService;
import be.hevelaska.mobile.infrastructure.RetrofitWrapper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MessageActivity extends AppCompatActivity {

    private ActivityMessageBinding binding;

    private IUsersService usersService;
    private IRidesService ridesService;
    private IDogsService dogsService;
    private IMessagesService messagesService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMessageBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        usersService = RetrofitWrapper.getInstance().create(IUsersService.class);
        ridesService = RetrofitWrapper.getInstance().create(IRidesService.class);
        dogsService = RetrofitWrapper.getInstance().create(IDogsService.class);
        messagesService = RetrofitWrapper.getInstance().create(IMessagesService.class);

        binding.getAllUsersButton.setOnClickListener(view -> getMessagesAndLog());
        binding.getUserByIdButton.setOnClickListener(view -> getDogByIdLog());
        binding.deleteUserButton.setOnClickListener(view -> deleteDogAndLog());
        binding.updateUserButton.setOnClickListener(view -> updateDogAndLog());
        binding.createUserButton.setOnClickListener(view -> createDogAndLog());

    }
    // test message
    private void getMessagesAndLog() {
        messagesService.getAll()
                .enqueue(new Callback<List<DtoMessages>>() {
                    @Override
                    public void onResponse(Call<List<DtoMessages>> call, Response<List<DtoMessages>> response) {
                        for (int i = 0; i < response.body().size(); i++) {
                            Log.i("MESSAGES", response.body().get(i).toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<DtoMessages>> call, Throwable t) {
                        Log.e("MESSAGES", "Error getting all dogs");
                        Log.e("MESSAGES", t.getMessage());
                    }
                });
    }

    // test dog
    private void getDogsAndLog() {
        dogsService.getAll()
                .enqueue(new Callback<List<DtoDogs>>() {
                    @Override
                    public void onResponse(Call<List<DtoDogs>> call, Response<List<DtoDogs>> response) {
                        for (int i = 0; i < response.body().size(); i++) {
                            Log.i("DOGS", response.body().get(i).toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<DtoDogs>> call, Throwable t) {
                        Log.e("DOGS", "Error getting all dogs");
                        Log.e("DOGS", t.getMessage());
                    }
                });
    }

    private void getDogByIdLog(){
        dogsService.getById(5)
                .enqueue(new Callback<DtoDogs>() {
                    @Override
                    public void onResponse(Call<DtoDogs> call, Response<DtoDogs> response) {
                        Log.i("DOGS", response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<DtoDogs> call, Throwable t) {
                        Log.e("DOGS", "Error get dog");

                    }
                });
    }

    private void deleteDogAndLog(){
        dogsService.delete(8)
                .enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Log.i("DOGS","dog supprimer");
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Log.e("DOGS", "Error delete dog");
                    }
                });
    }

    private void updateDogAndLog(){
        dogsService.update(2,new DtoDogs(2,"testUpdate","labrador","2021-11-21",1))
                .enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Log.i("DOGS","Todo updated");
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Log.e("DOGS", "Error update dog");
                    }
                });
    }

    private void createDogAndLog(){
        dogsService.create(new DtoCreateDog("maska","berger de laponie","2021-11-25",2))
                .enqueue(new Callback<DtoDogs>() {
                    @Override
                    public void onResponse(Call<DtoDogs> call, Response<DtoDogs> response) {
                        Log.i("DOGS", "dog created");
                    }

                    @Override
                    public void onFailure(Call<DtoDogs> call, Throwable t) {
                        Log.e("DOGS", "Error create dog");
                    }
                });
    }
    // test ride

    private void getRidesAndLog() {
        ridesService.getAll()
                .enqueue(new Callback<List<DtoRides>>() {
                    @Override
                    public void onResponse(Call<List<DtoRides>> call, Response<List<DtoRides>> response) {
                        for (int i = 0; i < response.body().size(); i++) {
                            Log.i("RIDES", response.body().get(i).toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<DtoRides>> call, Throwable t) {
                        Log.e("RIDES", "Error getting all rides");
                        Log.e("RIDES", t.getMessage());
                    }
                });
    }

    private void getRideByIdLog(){
        ridesService.getById(2)
                .enqueue(new Callback<DtoRides>() {
                    @Override
                    public void onResponse(Call<DtoRides> call, Response<DtoRides> response) {
                        Log.i("RIDES", response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<DtoRides> call, Throwable t) {
                        Log.e("RIDES", "Error get ride");

                    }
                });
    }

    private void deleteRideAndLog(){
        ridesService.delete(5)
                .enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Log.i("RIDES","ride supprimer");
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Log.e("RIDES", "Error delete ride");
                    }
                });
    }

    private void updateRideAndLog(){
        ridesService.update(2,new DtoRides(2,"mont a gourmet","place du village","restaurant pour smourbiff","http:montagourmet",4,"heures","photo ici",3,1))
                .enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Log.i("RIDES","Todo updated");
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Log.e("RIDES", "Error get user");
                    }
                });
    }

    private void createRideAndLog(){
        ridesService.create(new DtoCreateRide("new ride","new place","new desc","siteweb",5,"heure d'ouverture","image",1,2))
                .enqueue(new Callback<DtoRides>() {
                    @Override
                    public void onResponse(Call<DtoRides> call, Response<DtoRides> response) {
                        Log.i("RIDES", "ride created");
                    }

                    @Override
                    public void onFailure(Call<DtoRides> call, Throwable t) {
                        Log.e("RIDES", "Error create ride");
                    }
                });
    }

    // test user
    private void getUsersAndLog() {
        usersService.getAll()
                .enqueue(new Callback<List<DtoUser>>() {
                    @Override
                    public void onResponse(Call<List<DtoUser>> call, Response<List<DtoUser>> response) {
                        for (int i = 0; i < response.body().size(); i++) {
                            Log.i("USERS", response.body().get(i).toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<DtoUser>> call, Throwable t) {
                        Log.e("USERS", "Error getting all users");
                        Log.e("USERS", t.getMessage());
                    }
                });
    }

    private void getUserByIdLog(){
        usersService.getById(2)
                .enqueue(new Callback<DtoUser>() {
                    @Override
                    public void onResponse(Call<DtoUser> call, Response<DtoUser> response) {
                        Log.i("USERS", response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<DtoUser> call, Throwable t) {
                        Log.e("USERS", "Error get user");

                    }
                });
    }

    private void deleteUserAndLog(){
        usersService.delete(7)
                .enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Log.i("USERS","user supprimer");
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Log.e("USERS", "Error get user");
                    }
                });
    }



    private void updateUserAndLog(){
        usersService.update(2,new DtoUser(2,"rabhaTestPutMobile","emailtest","mdps"))
                .enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Log.i("USERS","Todo updated");
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Log.e("USERS", "Error get user");
                    }
                });
    }

    private void createUserAndLog(){
        usersService.create(new DtoCreateUser("dylan","dylan@mail","1234"))
                .enqueue(new Callback<DtoUser>() {
                    @Override
                    public void onResponse(Call<DtoUser> call, Response<DtoUser> response) {
                        Log.i("USERS", "user created");
                    }

                    @Override
                    public void onFailure(Call<DtoUser> call, Throwable t) {
                        Log.e("USERS", "Error create user");
                    }
                });
    }


}