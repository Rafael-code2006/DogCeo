package mainViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import enums.endpoints;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import retrofit.RetrofitClient;

public class MainViewModel extends ViewModel {

    private final CompositeDisposable disposables = new CompositeDisposable();

    // сюда кладём результат, активити это слушает
    private final MutableLiveData<String> imageUrl = new MutableLiveData<>();
    private final MutableLiveData<String> error = new MutableLiveData<>();

    public LiveData<String> getImageUrl() { return imageUrl; }
    public LiveData<String> getError() { return error; }

    public void getImage() {
        disposables.add(
                RetrofitClient.getApi()
                        .getRandomDog(endpoints.DOG_IMAGE.getBaseUrl())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                dog -> imageUrl.setValue(dog.getMessage()),   // onSuccess
                                throwable -> error.setValue(throwable.getMessage()) // onError
                        )
        );
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposables.clear();   // отменяем запросы при уничтожении ViewModel
    }
}