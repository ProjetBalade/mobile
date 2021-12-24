package be.hevelaska.mobile.ui.gestionDog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;

import be.hevelaska.mobile.R;
import be.hevelaska.mobile.data.model.dog.DtoDog;
import be.hevelaska.mobile.databinding.ActivityAddDogBinding;
import be.hevelaska.mobile.databinding.ActivityUpdateDogBinding;

public class UpdateDogActivity extends AppCompatActivity {
    private ActivityUpdateDogBinding binding;
    private UpdateDogViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUpdateDogBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        DtoDog dog = getIntent().getExtras().getParcelable("dog");

        viewModel = new UpdateDogViewModel();
        viewModel.setId(dog.getId());
        viewModel.setNameDog(dog.getNameDog());
        viewModel.setRaceDog(dog.getRaceDog());
        viewModel.setDateOfBirth(dog.getDateOfBirth());
        viewModel.setIdUser(dog.getIdUser());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        bindViewModelEvents();

        binding.btnUpdate.setOnClickListener(view -> {
            viewModel.updateDog(() -> {
                Toast.makeText(UpdateDogActivity.this, "Modifié avec succès :)", Toast.LENGTH_SHORT).show();
                finish();

            }, () -> {
                Toast.makeText(UpdateDogActivity.this, "Désolé, une erreur est survenue :(", Toast.LENGTH_SHORT).show();
            });
        });
    }

    private void bindViewModelEvents() {
        binding.edNameDog.setText(this.viewModel.getNameDog().getValue());

        binding.edNameDog.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                viewModel.setNameDog(editable.toString());
            }
        });

        binding.edRaceDog.setText(this.viewModel.getRaceDog().getValue());

        binding.edRaceDog.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                viewModel.setRaceDog(editable.toString());
            }
        });

        binding.edDateOfBirth.setText(this.viewModel.getDateOfBirth().getValue());

        binding.edDateOfBirth.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                viewModel.setDateOfBirth(editable.toString());
            }
        });

    }
}

