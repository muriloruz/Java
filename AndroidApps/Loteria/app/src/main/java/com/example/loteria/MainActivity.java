package com.example.loteria;

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
    Button btnG;
    TextView txtResps;
    int n1,n2,n3,n4,n5,n6;
    Random rand;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        n1=n2=n3=n4=n5=n6=0;
        txtResps = (TextView) findViewById(R.id.textRespostas);
        btnG = (Button) findViewById(R.id.btnGerar);
        rand = new Random();
        btnG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n1 = rand.nextInt(60);
                n2 = rand.nextInt(60);
                n3 = rand.nextInt(60);
                n4 = rand.nextInt(60);
                n5 = rand.nextInt(60);
                n6 = rand.nextInt(60);
                String resp = String.format("\n%d\t|\t%d\t|\t%d\n%d\t|\t%d\t|\t%d",n1,n2,n3,n4,n5,n6);
                txtResps.setText("Os números são: " + resp);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}