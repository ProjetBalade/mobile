package be.hevelaska.mobile.ui.gestionDog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.app.ActionBar;
import android.os.Bundle;

import java.util.ArrayList;

import java.util.List;

import be.hevelaska.mobile.data.model.dog.DtoDog;
import be.hevelaska.mobile.databinding.ActivityGestionDogBinding;

public class GestionDogActivity extends AppCompatActivity {

    private ActivityGestionDogBinding binding;
    private DogsAdapter dogsAdapter;
    private GestionDogViewModel gestionDogViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGestionDogBinding.inflate(getLayoutInflater());
        gestionDogViewModel = new GestionDogViewModel();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        gestionDogViewModel.load();
        setContentView(binding.getRoot());
        dogsAdapter = new DogsAdapter(new ArrayList<>(), dog -> {

        });

        binding.listDog.setAdapter(dogsAdapter);

        bindModelEvents();

    }

    private void bindModelEvents() {
        gestionDogViewModel.getDogs().observe(this, new Observer<List<DtoDog>>() {
            @Override
            public void onChanged(List<DtoDog> dtoDogs) {
                dogsAdapter.setDogsList(dtoDogs);
            }
        });
    }


}