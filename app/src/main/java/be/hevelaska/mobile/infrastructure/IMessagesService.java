package be.hevelaska.mobile.infrastructure;

import java.util.List;

import be.hevelaska.mobile.dto.dog.DtoCreateDog;
import be.hevelaska.mobile.dto.dog.DtoDogs;
import be.hevelaska.mobile.dto.message.DtoCreateMessage;
import be.hevelaska.mobile.dto.message.DtoMessages;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface IMessagesService {
    @GET("message/getall")
    Call<List<DtoMessages>> getAll();

    @GET("message/{id}")
    Call<DtoMessages> getById(@Path("id") int id);

    @POST("message/create")
    Call<DtoMessages> create(@Body DtoCreateMessage message);

    @DELETE("message/{id}")
    Call<Void> delete(@Path("id") int id);

    @PUT("message/{id}")
    Call<Void> update(@Path("id") int id,@Body DtoMessages dtoMessages);
}