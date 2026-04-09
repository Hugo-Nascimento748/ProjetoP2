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
import java.util.ArrayList;


public class ProductListFragment extends Fragment {

    private ArrayList<Produto> carrinho = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product_list, container, false);

        RecyclerView rv = view.findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));

        ArrayList<Produto> listaProdutos = new ArrayList<>();
        listaProdutos.add(new Produto(1, "Mouse Gamer", "RGB 3200 DPI", 150.00, android.R.drawable.ic_menu_agenda));
        listaProdutos.add(new Produto(2, "Teclado Mecânico", "Switch Blue", 350.00, android.R.drawable.ic_input_add));
        listaProdutos.add(new Produto(3, "Monitor 24'", "144Hz IPS", 1200.00, android.R.drawable.ic_menu_gallery));

        ProdutoAdapter adapter = new ProdutoAdapter(listaProdutos, produto -> {
            carrinho.add(produto);
            Toast.makeText(getContext(), produto.getNome() + " adicionado!", Toast.LENGTH_SHORT).show();

            // Exemplo de como abrir uma nova Activity enviando a lista (Carrinho)
            // Intent intent = new Intent(getActivity(), CarrinhoActivity.class);
            // intent.putParcelableArrayListExtra("carrinho", carrinho);
            // startActivity(intent);
        });

        rv.setAdapter(adapter);
        return view;
    }
}