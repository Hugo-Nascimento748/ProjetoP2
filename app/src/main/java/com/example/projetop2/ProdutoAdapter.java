package com.example.projetop2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
public class ProdutoAdapter extends RecyclerView.Adapter<ProdutoAdapter.ViewHolder>{
    private List<Produto> produtos;
    private OnProdutoClickListener listener;

    public interface OnProdutoClickListener {
        void onAdicionarClick(Produto produto);
    }

    public ProdutoAdapter(List<Produto> produtos, OnProdutoClickListener listener) {
        this.produtos = produtos;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_produto, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Produto p = produtos.get(position);
        holder.nome.setText(p.getNome());
        holder.preco.setText(String.format("R$ %.2f", p.getPreco()));
        holder.imagem.setImageResource(p.getImagemResId());

        holder.btnAdicionar.setOnClickListener(v -> listener.onAdicionarClick(p));
    }

    @Override
    public int getItemCount() { return produtos.size(); }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imagem;
        TextView nome, preco;
        Button btnAdicionar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagem = itemView.findViewById(R.id.imgProduto);
            nome = itemView.findViewById(R.id.txtNome);
            preco = itemView.findViewById(R.id.txtPreco);
            btnAdicionar = itemView.findViewById(R.id.btnAdicionar);
        }
    }

}
