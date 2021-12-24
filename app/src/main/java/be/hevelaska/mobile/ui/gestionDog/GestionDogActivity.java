package be.hevelaska.mobile.ui.gestionDog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import java.util.List;

import be.hevelaska.mobile.R;
import be.hevelaska.mobile.data.model.dog.DtoDog;
import be.hevelaska.mobile.databinding.ActivityGestionDogBinding;

public class GestionDogActivity extends AppCompatActivity {

    private static final int REQ_CODE_ADD_DOG = 1;
    public static final String KEY_DOG = "KEY_DOG";
    private ActivityGestionDogBinding binding;
    private DogsAdapter dogsAdapter;
    private GestionDogViewModel gestionDogViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_dog);

        binding = ActivityGestionDogBinding.inflate(getLayoutInflater());
        gestionDogViewModel = new GestionDogViewModel();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        gestionDogViewModel.load();
        setContentView(binding.getRoot());

        binding.buttonAddDog.setOnClickListener(this::openAddDog);

        dogsAdapter = new DogsAdapter(new ArrayList<>(), this::clickOnDog, this::deleteDog,this::updateDog);

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

    private void openAddDog(View view) {
       Intent intent = new Intent(GestionDogActivity.this, AddDogActivity.class);
        startActivityForResult(intent, REQ_CODE_ADD_DOG);
    }



    private void clickOnDog(DtoDog dog){

    }

    private void deleteDog(DtoDog dog){
        gestionDogViewModel.deleteDog(dog.getId(),null,null);
    }

    private void updateDog(DtoDog dog){
        Intent intent = new Intent(GestionDogActivity.this, UpdateDogActivity.class);
        intent.putExtra("dog",dog);
        startActivityForResult(intent, REQ_CODE_ADD_DOG);
    }

}