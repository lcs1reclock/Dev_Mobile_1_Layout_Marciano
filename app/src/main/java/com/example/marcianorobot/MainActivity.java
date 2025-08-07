package com.example.marcianorobot;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.example.marcianorobot.R;

public class MainActivity extends AppCompatActivity {

    private EditText etInput;
    private Button btnSend;
    private MarcianoRobotPremium marciano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInput = findViewById(R.id.et_input);
        btnSend = findViewById(R.id.btn_send);

        
        UserAction logAction = new UserAction() {
            @Override
            public void execute() { }
        };
        marciano = new MarcianoRobotPremium(logAction);

        btnSend.setOnClickListener(v -> {
            String input = etInput.getText().toString().trim();
            if (input.isEmpty()) {
                etInput.setError("Por favor, digite uma mensagem.");
                return;
            }

            // Processo a mensagem para receber a resposta do robô Marciano
            String resposta = marciano.responda(input);

            // Crio a Intent para iniciar a activity_resposta
            Intent intent = new Intent(MainActivity.this, activity_resposta.class);
            intent.putExtra("resposta_do_robo", resposta); // Passa a resposta para a próxima tela
            startActivity(intent);
        });
    }
}