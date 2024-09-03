package com.example.jurossimples;

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
    EditText edPA, edPJ, edVP;
    Button btnCal;
    TextView txtResp;
    float vp, pj;
    int pa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnCal = (Button) findViewById(R.id.btnCalc);
        txtResp = (TextView)findViewById(R.id.txtResp);
        edPA = (EditText) findViewById(R.id.edPA);
        edPJ = (EditText) findViewById(R.id.edPJ);
        edVP = (EditText) findViewById(R.id.edVP);

        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vp = Float.parseFloat(edVP.getText().toString());
                pj = Float.parseFloat(edPJ.getText().toString());
                pa = Integer.parseInt(edPA.getText().toString());
                float paConv = pa/30f;
                float pjConv = pj/100;
                float result = vp*pjConv*paConv;
                float resulFinal = vp + result;
                String resultF = String.format("Juros = %.2f\nValor Final = %.2f",result,resulFinal);
                txtResp.setText(resultF);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}