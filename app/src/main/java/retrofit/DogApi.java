package retrofit;

import model.DogResponse;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface DogApi {

    // Путь задаётся динамически через @Url, чтобы можно было
    // передавать значение из enums.endpoints (аннотации не умеют
    // брать строку из метода enum — там нужна константа времени компиляции).
    // Single — для RxJava: один результат или ошибка.
    @GET
    Single<DogResponse> getRandomDog(@Url String url);
}
