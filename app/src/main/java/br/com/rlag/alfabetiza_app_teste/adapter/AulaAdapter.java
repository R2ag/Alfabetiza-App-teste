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
import br.com.rlag.alfabetiza_app_teste.model.Aula;

public class AulaAdapter extends RecyclerView.Adapter<AulaAdapter.ViewHolder> {
    private final List<Aula> aulas;
    private final Context context;
    private final OnAulaClickListener listener;

    // Interface para clique nos itens
    public interface OnAulaClickListener {
        void onAulaClick(Aula aula);
    }

    public AulaAdapter(List<Aula> aulas, Context context, OnAulaClickListener listener) {
        this.aulas = aulas;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_aula, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Aula aula = aulas.get(position);
        holder.txtTitulo.setText(aula.getTitulo());
        holder.imgCapa.setImageResource(aula.getImagem());

        // Configurar evento de clique
        holder.itemView.setOnClickListener(v -> listener.onAulaClick(aula));
    }

    @Override
    public int getItemCount() {
        return aulas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgCapa;
        TextView txtTitulo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCapa = itemView.findViewById(R.id.imgAula);
            txtTitulo = itemView.findViewById(R.id.txtTitulo);
        }
    }
}
