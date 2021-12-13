package be.hevelaska.mobile.infrastructure;

import java.util.List;

import be.hevelaska.mobile.dto.ride.DtoCreateRide;
import be.hevelaska.mobile.dto.ride.DtoRides;
import be.hevelaska.mobile.dto.user.DtoCreateUser;
import be.hevelaska.mobile.dto.user.DtoUser;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface IRidesService {
    @GET("rides")
    Call<List<DtoRides>> getAll();

    @GET("rides/{id}")
    Call<DtoRides> getById(@Path("id") int id);

    @POST("rides")
    Call<DtoRides> create(@Body DtoCreateRide ride);

    @DELETE("rides/{id}")
    Call<Void> delete(@Path("id") int id);

    @PUT("rides/{id}")
    Call<Void> update(@Path("id") int id,@Body DtoRides dtoRides);
}
