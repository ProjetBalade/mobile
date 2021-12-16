package be.hevelaska.mobile.infrastructure;

import java.util.List;

import be.hevelaska.mobile.data.model.comment.DtoComment;
import be.hevelaska.mobile.data.model.comment.DtoCreateComment;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ICommentsService {
    @GET("rides/{idRide}/comments")
    Call<List<DtoComment>> getAll(@Path("idRide") int id);

    @GET("comments/{id}")
    Call<DtoComment> getById(@Path("id") int id);

    @POST("comments")
    Call<DtoComment> create(@Body DtoCreateComment comment);

    @DELETE("comments/{id}")
    Call<Void> delete(@Path("id") int id);

    @PUT("comments/{id}")
    Call<Void> update(@Path("id") int id,@Body DtoComment dtoComment);
}
