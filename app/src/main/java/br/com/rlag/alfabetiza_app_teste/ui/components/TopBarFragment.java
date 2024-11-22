package br.com.rlag.alfabetiza_app_teste.ui.components;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import br.com.rlag.alfabetiza_app_teste.R;
import br.com.rlag.alfabetiza_app_teste.api.ApiClient;
import br.com.rlag.alfabetiza_app_teste.api.ApiService;
import br.com.rlag.alfabetiza_app_teste.model.UserStatus;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TopBarFragment extends Fragment {

    private TextView txtMoedas, txtChaves, txtVidas;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_top_bar, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Referências aos TextViews
        txtMoedas = view.findViewById(R.id.txtMoedas);
        txtChaves = view.findViewById(R.id.txtChaves);
        txtVidas = view.findViewById(R.id.txtVidas);

        // Fazer a consulta à API
        carregarDadosDoUsuario();
    }

    private void carregarDadosDoUsuario() {
        ApiService apiService = ApiClient.getRetrofitInstance().create(ApiService.class);
        Call<UserStatus> call = apiService.getUserStatus();

        call.enqueue(new Callback<UserStatus>() {
            @Override
            public void onResponse(@NonNull Call<UserStatus> call, @NonNull Response<UserStatus> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // Atualizar a interface com os dados recebidos
                    UserStatus status = response.body();
                    txtMoedas.setText(String.valueOf(status.getMoedas()));
                    txtChaves.setText(String.valueOf(status.getChaves()));
                    txtVidas.setText(status.getVidas());
                } else {
                    Toast.makeText(requireContext(), "Erro ao carregar dados", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<UserStatus> call, @NonNull Throwable t) {
                Toast.makeText(requireContext(), "Erro de conexão", Toast.LENGTH_SHORT).show();
            }
        });
    }
}