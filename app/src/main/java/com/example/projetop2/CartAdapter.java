package com.example.projetop2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Locale;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    private ArrayList<Produto> produtos;

    public CartAdapter(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_carrinho, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Produto p = produtos.get(position);
        holder.txtNome.setText(p.getNome());
        holder.txtPreco.setText(String.format(Locale.getDefault(), "R$ %.2f", p.getPreco()));
        // Se tiver imagem (URL ou Recurso), carregue aqui com Glide/Picasso
    }

    @Override
    public int getItemCount() {
        return produtos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtNome, txtPreco;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNome = itemView.findViewById(R.id.txtNome);
            txtPreco = itemView.findViewById(R.id.txtPreco);
        }
    }
}