package com.example.projetop2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton; // ADICIONADO
import android.widget.Spinner;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class CartFragment extends Fragment {
    private ArrayList<Produto> lista;
    private double total = 0;

    public static CartFragment newInstance(ArrayList<Produto> produtos) {
        CartFragment fragment = new CartFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList("produtos", produtos);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_cart, container, false);

        // --- LÓGICA DO NOVO BOTÃO DE VOLTAR NO TOPO ---
        ImageButton btnVoltar = v.findViewById(R.id.btnVoltarCarrinho);
        btnVoltar.setOnClickListener(view -> {
            if (getActivity() != null) {
                getActivity().finish(); // Fecha a Activity e volta para a vitrine
            }
        });
        // ----------------------------------------------

        lista = getArguments().getParcelableArrayList("produtos");

        RecyclerView rv = v.findViewById(R.id.rvCarrinho);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(new CartAdapter(lista));

        // Cálculo do Total
        TextView txtTotal = v.findViewById(R.id.txtTotal);
        total = 0; // Resetar para não duplicar em caso de recarregamento
        for (Produto p : lista) { total += p.getPreco(); }
        txtTotal.setText(java.text.NumberFormat.getCurrencyInstance().format(total));

        // Configurar Spinners
        Spinner spPagto = v.findViewById(R.id.spinnerPagamento);
        Spinner spParcela = v.findViewById(R.id.spinnerParcelas);

        String[] opcoesPagto = {"Cartão de Crédito", "Pix", "Boleto"};
        spPagto.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, opcoesPagto));

        String[] opcoesParcelas = {"1x sem juros", "2x sem juros", "3x sem juros", "10x com juros"};
        spParcela.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, opcoesParcelas));

        v.findViewById(R.id.btnFinalizar).setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), ConfirmationActivity.class);
            intent.putExtra("valor_total", total);
            intent.putExtra("metodo", spPagto.getSelectedItem().toString());
            intent.putExtra("parcelas", spParcela.getSelectedItem().toString());
            startActivity(intent);
        });

        return v;
    }
}