package be.hevelaska.mobile.ui.login;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.annotation.NonNull;

import be.hevelaska.mobile.data.LoginDataSource;
import be.hevelaska.mobile.data.LoginRepository;
import be.hevelaska.mobile.data.model.user.UserRepository;
import be.hevelaska.mobile.infrastructure.IRidesService;
import be.hevelaska.mobile.infrastructure.IUsersService;
import be.hevelaska.mobile.infrastructure.RetrofitWrapper;
import retrofit2.Retrofit;

/**
 * ViewModel provider factory to instantiate LoginViewModel.
 * Required given LoginViewModel has a non-empty constructor
 */
public class LoginViewModelFactory implements ViewModelProvider.Factory {

    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(LoginViewModel.class)) {
            return (T) new LoginViewModel(UserRepository.getInstance(RetrofitWrapper.getInstance().create(IUsersService.class)));
        } else {
            throw new IllegalArgumentException("Unknown ViewModel class");
        }
    }
}