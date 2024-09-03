package com.example.calcimc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnCalcular, btnLimpar;
    EditText edPeso, edAltura;
    TextView txtResp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnCalcular = (Button) findViewById(R.id.btnCalc);
        btnLimpar = (Button) findViewById(R.id.btnLimpa);

        edPeso = (EditText) findViewById(R.id.tfPeso);
        edAltura = (EditText) findViewById(R.id.tfAltura);

        txtResp = (TextView) findViewById(R.id.txtResp);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float peso, altura, media;
                String mediaf;
                peso = Float.parseFloat(edPeso.getText().toString());
                altura = Float.parseFloat(edAltura.getText().toString());
                media = peso/(altura*altura);
                mediaf = String.format("Seu IMC é %.2f", media);
                txtResp.setText("Seu IMC é "+mediaf);
            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edPeso.setText("");
                edAltura.setText("");
                txtResp.setText("");
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}