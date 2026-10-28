package activity;

import com.bumptech.glide.Glide;
import com.example.dogceo.R;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import mainViewModel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private TextView testTextView;
    private Button nextDogButton;
    private ImageView dogImage;

    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_random_dog);

        initView();
        observeViewModel();
        clickDogButton();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.randomDog), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void initView() {
        testTextView = findViewById(R.id.breedText);
        nextDogButton = findViewById(R.id.fetchButton);
        dogImage = findViewById(R.id.dogImage);
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
    }

    private void observeViewModel() {
        viewModel.getImageUrl().observe(this, url ->
                Glide.with(this).load(url).into(dogImage));

        viewModel.getError().observe(this, msg ->
                testTextView.setText("Ошибка: " + msg));
    }

    private void clickDogButton() {
        nextDogButton.setOnClickListener(v -> viewModel.getImage());
    }
}
