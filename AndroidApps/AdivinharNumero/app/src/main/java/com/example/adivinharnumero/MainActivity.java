package com.example.adivinharnumero;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button btnGer;
    TextView txtNum;
    Random rand;
    int numero = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btnGer = (Button) findViewById(R.id.btnGerar);
        txtNum = (TextView) findViewById(R.id.txtNum);
        rand = new Random();

        btnGer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numero = rand.nextInt(100);
                txtNum.setText(String.valueOf(numero));
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}