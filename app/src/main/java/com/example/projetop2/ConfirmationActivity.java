package com.example.projetop2;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ConfirmationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        double total = getIntent().getDoubleExtra("valor_total", 0.0);
        String metodo = getIntent().getStringExtra("metodo");
        String parcelas = getIntent().getStringExtra("parcelas");

        TextView msg = findViewById(R.id.txtSucessoMsg); // Verifique se o ID no XML é esse

        String resumo = "PEDIDO CONFIRMADO!\n\n" +
                "Valor: " + java.text.NumberFormat.getCurrencyInstance().format(total) + "\n" +
                "Forma: " + metodo + "\n" +
                "Parcelamento: " + parcelas + "\n\n" +
                "Obrigado por comprar na TecnoStore!";

        msg.setText(resumo);

        findViewById(R.id.btnVoltarInicio).setOnClickListener(v -> {
            finish(); // Fecha a tela e encerra o fluxo
        });
    }
}