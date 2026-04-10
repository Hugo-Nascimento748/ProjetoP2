package com.example.projetop2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import java.util.ArrayList;

public class ProductListFragment extends Fragment {

    private ArrayList<Produto> carrinho = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product_list, container, false);

        // 1. Configurar a Lista (RecyclerView)
        RecyclerView rv = view.findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));

        ArrayList<Produto> listaProdutos = new ArrayList<>();
        listaProdutos.add(new Produto(1, "Mouse Gamer", "RGB 3200 DPI", 150.00, R.drawable.mouse));
        listaProdutos.add(new Produto(2, "Teclado Mecânico", "Black Basic", 100.00, R.drawable.teclado));
        listaProdutos.add(new Produto(3, "Monitor 24'", "144Hz IPS", 800.00, R.drawable.monitor));
        listaProdutos.add(new Produto(4, "Gabinete Gamer", "White RGB", 250.00, R.drawable.gabinete));
        listaProdutos.add(new Produto(5, "Cabo HDMI", "Black", 20.00, R.drawable.hdmi));
        listaProdutos.add(new Produto(6, "SSD", "250GB", 400.00, R.drawable.ssd));

        // 2. Configurar o Adapter e a ação de ADICIONAR
        ProdutoAdapter adapter = new ProdutoAdapter(listaProdutos, produto -> {
            carrinho.add(produto); // Adiciona na lista interna
            Toast.makeText(getContext(), produto.getNome() + " adicionado ao carrinho!", Toast.LENGTH_SHORT).show();
        });
        rv.setAdapter(adapter);

        // 3. Configurar a ação de IR PARA O CARRINHO (Botão Flutuante)
        // Certifique-se que o ID no fragment_product_list.xml é fabCarrinho
        ExtendedFloatingActionButton fab = view.findViewById(R.id.fabCarrinho);
        fab.setOnClickListener(v -> {
            if (carrinho.isEmpty()) {
                Toast.makeText(getContext(), "Seu carrinho está vazio!", Toast.LENGTH_SHORT).show();
            } else {
                // Abre a CartActivity que criamos nos passos anteriores
                Intent intent = new Intent(getActivity(), CartActivity.class);
                intent.putParcelableArrayListExtra("lista_carrinho", carrinho);
                startActivity(intent);
            }
        });

        return view;
    }
}