package com.example.marcianorobot;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class activity_resposta extends AppCompatActivity {

    private TextView tvResposta;
    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resposta);

        tvResposta = findViewById(R.id.tv_resposta);
        btnVoltar = findViewById(R.id.btn_voltar);

        // Recebe a resposta da Activity anterior
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String resposta = extras.getString("resposta_do_robo");
            tvResposta.setText(resposta);
        }

        btnVoltar.setOnClickListener(v -> finish()); // Finaliza a activity e volta para a anterior
    }
}