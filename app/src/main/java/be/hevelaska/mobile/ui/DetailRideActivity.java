package be.hevelaska.mobile.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import be.hevelaska.mobile.R;
import be.hevelaska.mobile.data.model.ride.DtoRides;
import be.hevelaska.mobile.databinding.ActivityAddRideBinding;
import be.hevelaska.mobile.databinding.ActivityDetailRideBinding;

public class DetailRideActivity extends AppCompatActivity {

    ActivityDetailRideBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailRideBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        DtoRides ride = getIntent().getExtras().getParcelable("baladeChoisi");

        getSupportActionBar().setTitle("Details de la balade");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding.textView.setText(ride.getNameRide());
        binding.placeRide.setText(ride.getPlace());
        binding.websiteRide.setText(ride.getWebsite());
        binding.horaireRide.setText(ride.getSchedule());
        binding.difficulte.setText("+"+ride.getDifficulty());
        binding.scoreRide.setText("+"+ride.getScore());

        binding.intentGoogleMap.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("geo:0,0?q="+ride.getLatitude()+","+ride.getLongitude()));
            startActivity(intent);
        });


    }

}