package be.hevelaska.mobile.infrastructure;

import java.util.List;

import be.hevelaska.mobile.data.model.dog.DtoCreateDog;
import be.hevelaska.mobile.data.model.dog.DtoDog;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface IDogsService {

    @GET("dog/getall")
    Call<List<DtoDog>> getAll();

    @GET("dog/{id}")
    Call<DtoDog> getById(@Path("id") int id);

    @POST("dog/create")
    Call<DtoDog> create(@Body DtoCreateDog dog);

    @DELETE("dog/{id}")
    Call<Void> delete(@Path("id") int id);

    @PUT("dog/{id}")
    Call<DtoDog> update(@Path("id") int id,@Body DtoDog dtoDogs);
}
