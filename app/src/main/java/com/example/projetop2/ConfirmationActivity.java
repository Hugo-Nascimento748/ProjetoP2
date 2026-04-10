package com.example.projetop2;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ConfirmationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        double total = getIntent().getDoubleExtra("valor_total", 0.0);
        String usuarioMock = "João Silva"; // Nome mock conforme solicitado

        TextView txtMensagem = findViewById(R.id.txtMensagem);
        TextView txtTotal = findViewById(R.id.txtTotalConfirmado);

        txtMensagem.setText("Obrigado, " + usuarioMock + "!");
        txtTotal.setText(String.format("Total da compra: R$ %.2f", total));
    }

    public void voltarParaInicio(View v) {
        // Limpa a pilha de Activities e volta para a primeira (Main)
        finishAffinity();
    }
}
