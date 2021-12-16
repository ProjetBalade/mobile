package be.hevelaska.mobile;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import be.hevelaska.mobile.data.model.ride.RideRepository;
import be.hevelaska.mobile.databinding.ActivityMainBinding;
import be.hevelaska.mobile.infrastructure.IRidesService;
import be.hevelaska.mobile.infrastructure.RetrofitWrapper;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_map,R.id.navigation_message, R.id.navigation_notifications,R.id.navigation_profile)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        loadRides();
    }

    private void loadRides() {
        RideRepository.getInstance(RetrofitWrapper.getInstance().create(IRidesService.class))
                .reloadRides(null, () -> {
                    Toast.makeText(MainActivity.this, "Une erreur est survenue. Vérifiez votre connexion internet", Toast.LENGTH_SHORT).show();
                });
    }

}