package be.hevelaska.mobile.ui.addride;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import be.hevelaska.mobile.databinding.ActivityAddRideBinding;

public class AddRideActivity extends AppCompatActivity {
    private ActivityAddRideBinding binding;

    private AddRideViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddRideBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new AddRideViewModel();

        bindViewModelEvents();

        binding.addRideBtn.setOnClickListener(v -> {
            viewModel.createRide(() -> {
                Toast.makeText(AddRideActivity.this, "Merci pour votre collaboration un administrateur va valider votre balade :)", Toast.LENGTH_SHORT).show();
                finish();
            }, () -> {
                Toast.makeText(AddRideActivity.this, "Une erreur est survenue :(", Toast.LENGTH_SHORT).show();
            });
        });

    }

    private void bindViewModelEvents() {
        binding.nameRide.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                viewModel.setNameRide(editable.toString());
            }
        });

        binding.descriptionRide.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                viewModel.setDescription(editable.toString());
            }
        });

        binding.placeRide.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                viewModel.setPlace(editable.toString());
            }
        });

        binding.websiteRide.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                viewModel.setWebsite(editable.toString());
            }
        });

        binding.difficultyRide.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                viewModel.setDifficulty(Integer.parseInt(editable.toString()));
            }
        });

        binding.scheduleRide.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                viewModel.setSchedule(editable.toString());
            }
        });




        binding.scheduleRide.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                viewModel.setSchedule(editable.toString());
            }
        });

        binding.scoreRide.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                viewModel.setScore(Integer.parseInt(editable.toString()));
            }
        });





    }
}