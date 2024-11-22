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
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.rlag.alfabetiza_app_teste.R;
import br.com.rlag.alfabetiza_app_teste.adapter.UnidadeAdapter;
import br.com.rlag.alfabetiza_app_teste.api.ApiClient;
import br.com.rlag.alfabetiza_app_teste.api.ApiService;
import br.com.rlag.alfabetiza_app_teste.model.Unidade;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ContentFragment extends Fragment {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, container, false);

        // Inicializar RecyclerView e ProgressBar
        recyclerView = view.findViewById(R.id.recyclerViewContent);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        progressBar = view.findViewById(R.id.progressBar);

        // Carregar dados da API
        carregarUnidades();

        return view;
    }

    private void carregarUnidades() {
        // Exibir a barra de progresso
        progressBar.setVisibility(View.VISIBLE);

        ApiService apiService = ApiClient.getRetrofitInstance().create(ApiService.class);
        Call<List<Unidade>> call = apiService.getUnidades();

        call.enqueue(new Callback<List<Unidade>>() {
            @Override
            public void onResponse(@NonNull Call<List<Unidade>> call, @NonNull Response<List<Unidade>> response) {
                progressBar.setVisibility(View.GONE);

                if (response.isSuccessful() && response.body() != null) {
                    List<Unidade> unidades = response.body();
                    UnidadeAdapter adapter = new UnidadeAdapter(unidades, requireContext(), unidade -> {
                        Toast.makeText(requireContext(), "Clicou na " + unidade.getNome(), Toast.LENGTH_SHORT).show();
                    });
                    recyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(requireContext(), "Erro ao carregar unidades", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Unidade>> call, @NonNull Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(requireContext(), "Erro de conexão", Toast.LENGTH_SHORT).show();
            }
        });
    }
}