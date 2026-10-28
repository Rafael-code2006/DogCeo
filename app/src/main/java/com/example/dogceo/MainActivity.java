package com.example.dogceo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    private static TextView testTextView;
    private static Button testButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_random_dog);

        initView();

        testButton.setOnClickListener(v -> {
            if(testTextView != null) {
                testTextView.setText("Игорь Салам!");
                Log.d("ClickButton", "Успешно изменил");
            } else {
                Log.e("ClickButton", "Успешно изменил");
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.randomDog), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    private void initView() {
        testTextView = findViewById(R.id.breedText);
        testButton = findViewById(R.id.fetchButton);
    }
}