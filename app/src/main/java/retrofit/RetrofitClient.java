package retrofit;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String BASE_URL = "https://dog.ceo/";

    private static Retrofit retrofit;

    private RetrofitClient() {
        // класс-утилита, экземпляры не нужны
    }

    public static Retrofit getInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())  // ← добавить
                    .build();
        }
        return retrofit;
    }

    public static DogApi getApi() {
        return getInstance().create(DogApi.class);
    }
}
