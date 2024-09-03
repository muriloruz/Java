package com.example.appidade;

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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
     EditText etNome, etDataNascimento;
     TextView tvResultado;
     Button btnCalcular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        etNome = findViewById(R.id.etNome);
        etDataNascimento = findViewById(R.id.etDataNascimento);
        tvResultado = findViewById(R.id.tvResultado);
        btnCalcular = findViewById(R.id.btnCalcular);
        etDataNascimento.addTextChangedListener(new DateTextWatcher());

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = etNome.getText().toString();
                String dataNascimentoStr = etDataNascimento.getText().toString();

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

                try {
                    Date dataNascimento = sdf.parse(dataNascimentoStr);
                    Calendar nascimento = Calendar.getInstance();
                    nascimento.setTime(dataNascimento);

                    Calendar hoje = Calendar.getInstance();

                    int anos = hoje.get(Calendar.YEAR) - nascimento.get(Calendar.YEAR);
                    int meses = hoje.get(Calendar.MONTH) - nascimento.get(Calendar.MONTH);
                    int dias = hoje.get(Calendar.DAY_OF_MONTH) - nascimento.get(Calendar.DAY_OF_MONTH);

                    if (meses < 0) {
                        anos--;
                        meses += 12;
                    }

                    if (dias < 0) {
                        meses--;
                        Calendar ultimoMes = Calendar.getInstance();
                        ultimoMes.setTime(hoje.getTime());
                        ultimoMes.add(Calendar.MONTH, -1);
                        dias += ultimoMes.getActualMaximum(Calendar.DAY_OF_MONTH);
                    }

                    long diferencaMillis = hoje.getTimeInMillis() - nascimento.getTimeInMillis();
                    long horas = TimeUnit.MILLISECONDS.toHours(diferencaMillis);
                    long minutos = TimeUnit.MILLISECONDS.toMinutes(diferencaMillis);

                    String resultado = String.format("%s tem:\n%d anos\n%d meses\n%d dias\n%d horas\n%d minutos",
                            nome, anos, meses, dias, horas, minutos);

                    tvResultado.setText(resultado);

                } catch (ParseException e) {
                    e.printStackTrace();
                    tvResultado.setText("Data de nascimento inválida.");
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