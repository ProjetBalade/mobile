package be.hevelaska.mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import be.hevelaska.mobile.databinding.ActivityMessageBinding;
import be.hevelaska.mobile.dto.DtoUser;
import be.hevelaska.mobile.infrastructure.IUsersService;
import be.hevelaska.mobile.infrastructure.RetrofitWrapper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MessageActivity extends AppCompatActivity {

    private ActivityMessageBinding binding;

    private IUsersService usersService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMessageBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        usersService = RetrofitWrapper.getInstance().create(IUsersService.class);

        binding.getAllUsersButton.setOnClickListener(view -> getUsersAndLog());
        binding.getUserByIdButton.setOnClickListener(view -> getUserByIdLog());
        binding.deleteUserButton.setOnClickListener(view -> deleteUserAndLog());
        binding.updateUserButton.setOnClickListener(view -> updateUserAndLog());

    }

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


}