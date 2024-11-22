package br.com.rlag.alfabetiza_app_teste.ui.activities.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.rlag.alfabetiza_app_teste.R;
import br.com.rlag.alfabetiza_app_teste.adapter.UnidadeAdapter;
import br.com.rlag.alfabetiza_app_teste.model.Unidade;


public class ContentFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewContent);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setLayoutAnimation(AnimationUtils.loadLayoutAnimation(requireContext(), R.anim.layout_animation));


        List<Unidade> unidades = carregarUnidades();
        UnidadeAdapter adapter = new UnidadeAdapter(unidades, requireContext(), unidade -> {
            // Evento de clique no item da unidade
            Toast.makeText(requireContext(), "Clicou na unidade: " + unidade.getNome(), Toast.LENGTH_SHORT).show();
        });
        recyclerView.setAdapter(adapter);

        return view;
    }

    private List<Unidade> carregarUnidades() {
        List<Unidade> unidades = new ArrayList<>();
        unidades.add(new Unidade("UNIDADE 1 – APRENDER A OUVIR", R.drawable.unidade1));
        unidades.add(new Unidade("UNIDADE 2 – AS PRIMEIRAS LETRAS", R.drawable.unidade2));
        // Adicione mais unidades aqui
        return unidades;
    }
}