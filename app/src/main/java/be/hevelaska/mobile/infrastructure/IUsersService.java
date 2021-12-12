package be.hevelaska.mobile.infrastructure;

import java.util.List;

import be.hevelaska.mobile.dto.DtoUser;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface IUsersService {
    @GET("users")
    Call<List<DtoUser>> getAll();

    @GET("users/{id}")
    Call<DtoUser> getById(@Path("id") int id);

    //@POST("user")
    //Call<DtoUser> create(@Body DtoCreateTodo todo);

    @DELETE("users/{id}")
    Call<Void> delete(@Path("id") int id);

    @PUT("users/{id}")
    Call<Void> update(@Path("id") int id,@Body DtoUser dtoUser);
}
