package com.example.projetop2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class CartFragment extends Fragment {
    private ArrayList<Produto> listaProdutos;
    private double valorTotal = 0;

    public static CartFragment newInstance(ArrayList<Produto> produtos) {
        CartFragment fragment = new CartFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList("produtos", produtos);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart, container, false);

        if (getArguments() != null) {
            listaProdutos = getArguments().getParcelableArrayList("produtos");
        }

        RecyclerView rv = view.findViewById(R.id.rvCarrinho);
        TextView txtTotal = view.findViewById(R.id.txtTotal);
        Button btnFinalizar = view.findViewById(R.id.btnFinalizar);

        // Configura RecyclerView
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(new CartAdapter(listaProdutos));

        // Calcula Total
        for (Produto p : listaProdutos) {
            valorTotal += p.getPreco();
        }
        txtTotal.setText(String.format("R$ %.2f", valorTotal));

        btnFinalizar.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), ConfirmationActivity.class);
            intent.putExtra("valor_total", valorTotal);
            startActivity(intent);
        });

        return view;
    }
}
