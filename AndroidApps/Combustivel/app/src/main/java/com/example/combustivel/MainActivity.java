package com.example.combustivel;

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
    Button btnCalcular;
    EditText edGas, edEta;
    TextView txtResp;
    float gas, etanol;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btnCalcular = (Button) findViewById(R.id.btnCalc);
        edGas = (EditText) findViewById(R.id.edGaso);
        edEta = (EditText) findViewById(R.id.edEtanol);
        txtResp = (TextView) findViewById(R.id.txtResp);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gas = Float.parseFloat(edGas.getText().toString());
                etanol = Float.parseFloat(edEta.getText().toString());
                float result = etanol/gas;
                if(result>0.7) txtResp.setText("Vale a pena colocar Gasolina");
                else if(result>0 && result<=0.7) txtResp.setText("Vale a pena colocar Etanol");
                else txtResp.setText("Valor Inválido");
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}