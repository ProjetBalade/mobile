package be.hevelaska.mobile.ui.register;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import be.hevelaska.mobile.databinding.ActivityRegisterBinding;
import be.hevelaska.mobile.data.model.user.DtoCreateUser;
import be.hevelaska.mobile.data.model.user.DtoUser;
import be.hevelaska.mobile.infrastructure.IUsersService;
import be.hevelaska.mobile.infrastructure.RetrofitWrapper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    private RegisterViewModel registerViewModel;
    private ActivityRegisterBinding binding;

    private IUsersService usersService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        usersService = RetrofitWrapper.getInstance().create(IUsersService.class);

        binding.registerBtn.setOnClickListener(view ->createUserAndLog() );

    }

    private void createUserAndLog(){
        usersService.create(new DtoCreateUser(binding.usernameRegister.getText().toString(),binding.email.getText().toString(),binding.passwordRegister.getText().toString()))
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

