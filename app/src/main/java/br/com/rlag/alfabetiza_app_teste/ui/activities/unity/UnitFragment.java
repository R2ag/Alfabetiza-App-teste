package br.com.rlag.alfabetiza_app_teste.ui.activities.unity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.rlag.alfabetiza_app_teste.R;
import br.com.rlag.alfabetiza_app_teste.adapter.AulaAdapter;
import br.com.rlag.alfabetiza_app_teste.model.Aula;

public class UnitFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_unit, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewAulas);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        // Carregar aulas da unidade
        List<Aula> aulas = carregarAulas();

        // Configurar adaptador
        AulaAdapter adapter = new AulaAdapter(aulas, requireContext(), aula -> {
            Toast.makeText(requireContext(), "Clicou na " + aula.getTitulo(), Toast.LENGTH_SHORT).show();
        });

        recyclerView.setAdapter(adapter);

        return view;
    }

    private List<Aula> carregarAulas() {
        List<Aula> aulas = new ArrayList<>();
        // Adicione mais aulas conforme necessário
        return aulas;
    }
}