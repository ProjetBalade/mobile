package be.hevelaska.mobile.ui.gestionDog;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import be.hevelaska.mobile.R;
import be.hevelaska.mobile.databinding.ActivityAddDogBinding;


public class AddDogActivity extends AppCompatActivity {

    private ActivityAddDogBinding binding;

    private GestionDogViewModel viewModelDog;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_add_dog);
        binding = ActivityAddDogBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModelDog = new GestionDogViewModel();

        bindViewModelEvents();

        binding.btnAdd.setOnClickListener(v -> {
            viewModelDog.addDog(() -> {
                Toast.makeText(AddDogActivity.this, "Ajout avec succès :)", Toast.LENGTH_SHORT).show();
                finish();
            }, () -> {
                Toast.makeText(AddDogActivity.this, "Une erreur est survenue :(", Toast.LENGTH_SHORT).show();
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
