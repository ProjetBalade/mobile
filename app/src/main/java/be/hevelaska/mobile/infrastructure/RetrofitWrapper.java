package be.hevelaska.mobile.infrastructure;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitWrapper {
    //private static final String BASE_URL = "http://10.0.2.2:5000/api/";
    // pour l'app sur mon telephone
    private static final String BASE_URL = "http://10.0.2.2:5000/api/";

    private static retrofit2.Retrofit instance;

    public static retrofit2.Retrofit getInstance() {
        if(instance==null){
            instance = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return instance;
    }
}
