package be.hevelaska.mobile.infrastructure;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitWrapper {
    //private static final String BASE_URL = "http://10.0.2.2:8080/api/";
    // pour l'app sur mon telephone
    private static final String BASE_URL = "http://192.168.0.11:8080/api/";
    private static String token;

    private static retrofit2.Retrofit instance;

    public static retrofit2.Retrofit getInstance() {
        if(instance==null){
            OkHttpClient client = new OkHttpClient().newBuilder()
            .addInterceptor(chain -> {
                Request request = chain.request()
                        .newBuilder()
                        .addHeader("deviceplatform", "android")
                        .removeHeader("User-Agent")
                        .addHeader("Authorization", "Bearer " + RetrofitWrapper.token)
                        .build();
                return chain.proceed(request);
            })
            .addInterceptor((chain -> {
                boolean isAuthenticateRequest = chain.request().url().uri().getPath().endsWith("Authenticate");
                Response response = chain.proceed(chain.request());

                if(isAuthenticateRequest && response.code() == 200) {
                    final JsonElement element = new JsonParser().parse(response.body().string());
                    final JsonObject object = element.getAsJsonObject();
                    RetrofitWrapper.token = object.get("token").getAsString();

                    MediaType mediaType = response.body().contentType();
                    ResponseBody body = ResponseBody.create(mediaType, object.toString());
                    response = response.newBuilder().body(body).build();
                }
                return response;
            })).build();

            instance = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return instance;
    }

    public static void setToken(String newToken) {
        token = newToken;
    }

}
