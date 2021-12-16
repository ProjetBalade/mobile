package be.hevelaska.mobile.infrastructure;

import java.util.List;

import be.hevelaska.mobile.data.model.dog.DtoCreateDog;
import be.hevelaska.mobile.data.model.dog.DtoDogs;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface IDogsService {

    @GET("dog/getall")
    Call<List<DtoDogs>> getAll();

    @GET("dog/{id}")
    Call<DtoDogs> getById(@Path("id") int id);

    @POST("dog/create")
    Call<DtoDogs> create(@Body DtoCreateDog dog);

    @DELETE("dog/{id}")
    Call<Void> delete(@Path("id") int id);

    @PUT("dog/{id}")
    Call<Void> update(@Path("id") int id,@Body DtoDogs dtoDogs);
}
