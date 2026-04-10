package com.example.projetop2;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        // Ativa o botão de voltar na barra superior
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Meu Carrinho");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        ArrayList<Produto> lista = getIntent().getParcelableArrayListExtra("lista_carrinho");

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container_carrinho, CartFragment.newInstance(lista))
                    .commit();
        }
    }

    // Faz a setinha de voltar funcionar
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}