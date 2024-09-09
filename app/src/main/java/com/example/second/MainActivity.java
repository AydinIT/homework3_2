package com.example.second;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private MaterialButton btn_plus, btn_minus, btn_result;
    private TextView tv_number;
    private Integer result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn_plus = findViewById(R.id.btn_plus);
        btn_minus = findViewById(R.id.btn_minus);
        btn_result = findViewById(R.id.btn_result);
        tv_number = findViewById(R.id.tv_number);


        btn_plus.setOnClickListener(view -> {
            String data = tv_number.getText().toString();
            result = Integer.valueOf(data);
            result++;
            tv_number.setText(String.valueOf(result));
        });
        btn_minus.setOnClickListener(view -> {
            String data = tv_number.getText().toString();
            result = Integer.valueOf(data);
            result--;
            tv_number.setText(String.valueOf(result));
        });
        btn_result.setOnClickListener(view -> {
            String data = tv_number.getText().toString();
            Bundle bundle = new Bundle();
            bundle.putString("key", data);
            FirstFragment fragment = new FirstFragment();
            fragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment, fragment).addToBackStack(null).commit();
            btn_result.setVisibility(View.GONE);
            btn_minus.setVisibility(View.GONE);
            btn_plus.setVisibility(View.GONE);
            tv_number.setVisibility(View.GONE);
        });

    }
}