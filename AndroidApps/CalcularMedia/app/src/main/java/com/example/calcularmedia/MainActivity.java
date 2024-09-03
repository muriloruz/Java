package com.example.calcularmedia;

import android.os.Bundle;
import android.util.Log;
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
    Button btnCalcularMed, btnLimpar;
    EditText edNome, edN1, edN2, edN3, edFalta;
    TextView txtResp, txtAp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnCalcularMed = (Button) findViewById(R.id.btnCalc);
        btnLimpar = (Button) findViewById(R.id.btnLimpar);
        edNome = (EditText) findViewById(R.id.tfNome);
        edN1 = (EditText) findViewById(R.id.tfN1);
        edN2 = (EditText) findViewById(R.id.tfN2);
        edN3 = (EditText) findViewById(R.id.tfN3);
        edFalta = (EditText) findViewById(R.id.tfFaltas);
        txtResp = (TextView) findViewById(R.id.lblResp);
        txtAp = (TextView) findViewById(R.id.lblAp);
        btnCalcularMed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float n1,n2,n3,media,vet[];
                int i,j,faltas;

                vet = new float[3];
                i=j=faltas=0;
                n1=n2=n3=media=0f;
                try{
                    n1 = Float.parseFloat(edN1.getText().toString());
                    n2 = Float.parseFloat(edN2.getText().toString());
                    n3 = Float.parseFloat(edN3.getText().toString());
                    faltas = Integer.parseInt(edFalta.getText().toString());
                    if ((n1 < 0 || n1 > 10) || n2 < 0 || n2 > 10 || n3 < 0 || n3 > 10) {
                        txtResp.setText("As notas devem estar entre 0 e 10.");
                    }else{
                        vet[0] = n1;
                        vet[1] = n2;
                        vet[2] = n3;

                        for(i=0;i<3;i++){
                            for(j=0;j<3-i-1;j++){
                                if(vet[j]<vet[j+1]){
                                    float swap = vet[j];
                                    vet[j] = vet[j+1];
                                    vet[j+1] = swap;
                                }
                            }
                        }
                        for (float a:vet) {
                            Log.d("",String.valueOf(a));
                        }
                        media = (vet[0]+vet[1])/2;
                        txtResp.setText("O aluno "+ edNome.getText().toString() + " ficou com media "+String.valueOf(media));
                        if(media>=6 && faltas<=5) txtAp.setText("Aprovado");
                        else txtAp.setText("Reprovado");
                    }
                }catch (Exception e){
                    Log.d("","O erro é "+e);
                }
            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edFalta.setText("");
                edN1.setText("");
                edN2.setText("");
                edN3.setText("");
                edNome.setText("");
                txtResp.setText("");
                txtAp.setText("");
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}