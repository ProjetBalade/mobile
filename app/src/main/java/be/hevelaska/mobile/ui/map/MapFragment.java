package be.hevelaska.mobile.ui.map;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import be.hevelaska.mobile.data.model.ride.DtoRides;
import be.hevelaska.mobile.data.model.ride.RideRepository;
import be.hevelaska.mobile.infrastructure.IRidesService;
import be.hevelaska.mobile.infrastructure.RetrofitWrapper;
import be.hevelaska.mobile.ui.DetailRideActivity;
import be.hevelaska.mobile.ui.addride.AddRideActivity;
import be.hevelaska.mobile.databinding.FragmentMapBinding;

public class MapFragment extends Fragment {

    private MapViewModel homeViewModel;
    private FragmentMapBinding binding;
    private FusedLocationProviderClient fusedLocationProviderClient;

    private LiveData<List<DtoRides>> rides;


    boolean locationEnabled;
    GoogleMap map;

    private HashMap<Marker, DtoRides> markers;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(MapViewModel.class);

        binding = FragmentMapBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.mapView.onCreate(savedInstanceState);

        binding.mapView.getMapAsync(this::setupMap);
        binding.textResearchRide.setBackground(null);
        binding.fab.setOnClickListener(this::openAddRide);

        if(locationEnabled) {
            binding.locateBtn.setOnClickListener(view -> zoomOnUser());
            binding.locateBtn.setVisibility(View.VISIBLE);
        }
        else {
            binding.locateBtn.setVisibility(View.GONE);
        }


        return root;
    }

    private void openAddRide(View view) {
        Intent intent = new Intent(getContext(), AddRideActivity.class);
        startActivity(intent);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context);

        if(context instanceof Activity) {
            setupUserLocationPermission(context);
        }

    }

    private void setupUserLocationPermission(@NonNull Context context) {
        registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
            if(isGranted) {
                locationEnabled = true;
                setupUserLocation();
                binding.locateBtn.setVisibility(View.VISIBLE);
            }
        }).launch(Manifest.permission.ACCESS_FINE_LOCATION);

        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            locationEnabled = false;
            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }else{
            locationEnabled = true;
            setupUserLocation();
        }
    }


    private void setupMap(GoogleMap map) {
        this.map = map;
        setupUserLocation();

        map.getUiSettings().setMyLocationButtonEnabled(false);
        map.setOnInfoWindowClickListener(marker -> {
            DtoRides rideClicked = MapFragment.this.markers.get(marker);
            Intent intent = new Intent(getContext(), DetailRideActivity.class);
            intent.putExtra("baladeChoisi",rideClicked);
            startActivity(intent);
        });

        this.homeViewModel.getRideList().observe(this, MapFragment.this::reloadMarkers);

    }

    private void reloadMarkers(List<DtoRides> dtoRides) {
        if(markers == null) markers = new HashMap<>();
        for(Marker m : markers.keySet()) {
            m.remove();
        }
        markers.clear();
        for(DtoRides ride : dtoRides) {
            Marker marker = this.map.addMarker(
                    new MarkerOptions()
                            .position(new LatLng(ride.getLatitude(), ride.getLongitude()))
                            .title(ride.getNameRide())
            );

            markers.put(marker, ride);
        }
    }

    @SuppressLint("MissingPermission")
    private void setupUserLocation() {
        if(locationEnabled && this.map != null) {
            map.setMyLocationEnabled(true);

            fusedLocationProviderClient.getLastLocation().addOnSuccessListener(location -> {
                LatLng userLocation = new LatLng(location.getLatitude(), location.getLongitude());
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(userLocation, 10));
            });
        }
    }

    @SuppressLint("MissingPermission")
    private void zoomOnUser() {
        if(locationEnabled && this.map != null) {
            fusedLocationProviderClient.getLastLocation().addOnSuccessListener(location -> {
                LatLng userLocation = new LatLng(location.getLatitude(), location.getLongitude());
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(userLocation, 12));
            });
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding.mapView.onDestroy();
        binding = null;
    }

    @Override
    public void onResume() {
        super.onResume();
        if(binding != null){
            binding.mapView.onResume();

        }
    }

    @Override
    public void onPause() {
        super.onPause();

        if(binding != null) {
            binding.mapView.onPause();
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if(binding != null){
            binding.mapView.onSaveInstanceState(outState);

        }
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        binding.mapView.onLowMemory();
    }


}