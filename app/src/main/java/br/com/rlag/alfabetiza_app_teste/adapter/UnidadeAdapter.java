package br.com.rlag.alfabetiza_app_teste.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.rlag.alfabetiza_app_teste.R;
import br.com.rlag.alfabetiza_app_teste.model.Unidade;

public class UnidadeAdapter extends RecyclerView.Adapter<UnidadeAdapter.ViewHolder>  {
    private final List<Unidade> unidades;
    private final Context context;
    private final OnUnidadeClickListener listener;

    // Interface para eventos de clique
    public interface OnUnidadeClickListener {
        void onUnidadeClick(Unidade unidade);
    }

    public UnidadeAdapter(List<Unidade> unidades, Context context, OnUnidadeClickListener listener) {
        this.unidades = unidades;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_unidade, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Unidade unidade = unidades.get(position);
        holder.txtTitulo.setText(unidade.getNome());
        holder.txtDescricao.setText(unidade.getDescricao());
        holder.imgCapa.setImageResource(unidade.getImagem());

        // Evento de clique no item
        holder.itemView.setOnClickListener(v -> listener.onUnidadeClick(unidade));
    }

    @Override
    public int getItemCount() {
        return unidades.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgCapa;
        TextView txtTitulo, txtDescricao;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCapa = itemView.findViewById(R.id.imgCapa);
            txtTitulo = itemView.findViewById(R.id.txtTitulo);
            txtDescricao = itemView.findViewById(R.id.txtDescricao);
        }
    }
}
