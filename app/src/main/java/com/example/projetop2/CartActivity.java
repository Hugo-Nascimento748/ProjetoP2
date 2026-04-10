package com.example.projetop2;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Criamos um layout simples via código ou crie o activity_cart.xml com um FrameLayout
        setContentView(R.layout.activity_cart);

        ArrayList<Produto> lista = getIntent().getParcelableArrayListExtra("lista_carrinho");

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container_carrinho, CartFragment.newInstance(lista))
                    .commit();
        }
    }
}