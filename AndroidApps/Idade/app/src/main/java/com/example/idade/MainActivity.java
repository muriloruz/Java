package com.example.idade;

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

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    EditText dataEd;
    TextView txtResp;
    Button btnIda;
    int idade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        dataEd = (EditText) findViewById(R.id.tfData);
        dataEd.addTextChangedListener(new DateTextWatcher());
        txtResp = (TextView) findViewById(R.id.txtResp);
        btnIda = (Button) findViewById(R.id.btnId);

        idade = 0;
        btnIda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String dataNasc = dataEd.getText().toString();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    Date dataNascSdf = sdf.parse(dataNasc);
                    LocalDate localDateNascimento = dataNascSdf.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
                    LocalDate dataAgora = LocalDate.now();
                    idade = Period.between(localDateNascimento, dataAgora).getYears();
                    txtResp.setText("A idade é "+idade);
                }catch (Exception e){
                    System.out.println("Erro "+e);
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}