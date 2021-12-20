package be.hevelaska.mobile.data.model.user;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import be.hevelaska.mobile.data.model.LoggedInUser;
import be.hevelaska.mobile.data.model.dog.DtoDog;
import be.hevelaska.mobile.dto.ApiAuthRequest;
import be.hevelaska.mobile.dto.ApiAuthResult;
import be.hevelaska.mobile.infrastructure.IDogsService;
import be.hevelaska.mobile.infrastructure.IUsersService;
import be.hevelaska.mobile.infrastructure.RetrofitWrapper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {

    private static volatile UserRepository instance;

    private final IUsersService dataSource;

    private LoggedInUser user;

    private UserRepository(IUsersService dataSource) {
        this.dataSource = dataSource;
    }

    public static UserRepository getInstance(IUsersService dataSource) {
        if (instance == null) {
            instance = new UserRepository(dataSource);
        }
        return instance;
    }

    public boolean isLoggedIn() {
        return user != null;
    }

    public int getUserId() {
        return user.getUserId();
    }

    public LoggedInUser getLoggedUser(){
        return  user;
    }

    public void logout() {
        user = null;
        RetrofitWrapper.setToken(null);
    }

    public void authenticate(String username, String password, Runnable success , Runnable error) {
        this.dataSource.authenticate(new ApiAuthRequest(username, password))
                .enqueue(new Callback<ApiAuthResult>() {
                    @Override
                    public void onResponse(Call<ApiAuthResult> call, Response<ApiAuthResult> response) {
                        if(response.code() == 200) {
                            UserRepository.this.user = new LoggedInUser(response.body().getId(), response.body().getName());
                            if(success != null) success.run();
                        }
                        else {
                            if(error != null) error.run();
                        }
                    }

                    @Override
                    public void onFailure(Call<ApiAuthResult> call, Throwable t) {
                        if(error != null) error.run();
                    }
                });
    }

}
