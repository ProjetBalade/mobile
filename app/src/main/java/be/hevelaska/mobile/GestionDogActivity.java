package be.hevelaska.mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import be.hevelaska.mobile.databinding.ActivityGestionDogBinding;
import be.hevelaska.mobile.databinding.ActivityMessageBinding;

public class GestionDogActivity extends AppCompatActivity {

    private ActivityGestionDogBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGestionDogBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

    }
}