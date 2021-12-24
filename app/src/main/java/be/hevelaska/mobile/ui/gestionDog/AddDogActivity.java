package be.hevelaska.mobile.ui.gestionDog;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import be.hevelaska.mobile.databinding.ActivityAddDogBinding;


public class AddDogActivity extends AppCompatActivity {

    private ActivityAddDogBinding binding;

    private GestionDogViewModel viewModelDog;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAddDogBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        viewModelDog = new GestionDogViewModel();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        bindViewModelEvents();

        binding.btnAdd.setOnClickListener(v -> {
            viewModelDog.addDog(() -> {
                Toast.makeText(AddDogActivity.this, "Ajouté avec succès :)", Toast.LENGTH_SHORT).show();
                finish();
            }, () -> {
                Toast.makeText(AddDogActivity.this, "Désolé, une erreur est survenue :(", Toast.LENGTH_SHORT).show();
            });

        });


    }

    private void bindViewModelEvents() {
        binding.edNameDog.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                viewModelDog.setNameDog(editable.toString());
            }
        });

        binding.edRaceDog.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                viewModelDog.setRaceDog(editable.toString());
            }
        });

        binding.edDateOfBirth.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                viewModelDog.setDateOfBirth(editable.toString());
            }
        });
    }


}
