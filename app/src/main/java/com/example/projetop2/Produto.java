package com.example.projetop2;

import android.os.Parcel;
import android.os.Parcelable;
public class Produto implements Parcelable{
    private int id;
    private String nome;
    private String descricao;
    private double preco;
    private int imagemResId; // ID do drawable (R.drawable.nome)

    public Produto(int id, String nome, String descricao, double preco, int imagemResId) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.imagemResId = imagemResId;
    }

    protected Produto(Parcel in) {
        id = in.readInt();
        nome = in.readString();
        descricao = in.readString();
        preco = in.readDouble();
        imagemResId = in.readInt();
    }

    public static final Creator<Produto> CREATOR = new Creator<Produto>() {
        @Override
        public Produto createFromParcel(Parcel in) { return new Produto(in); }
        @Override
        public Produto[] newArray(int size) { return new Produto[size]; }
    };

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nome);
        dest.writeString(descricao);
        dest.writeDouble(preco);
        dest.writeInt(imagemResId);
    }

    // Getters
    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public int getImagemResId() { return imagemResId; }

}
