package br.com.rlag.alfabetiza_app_teste.api;

import java.util.List;

import br.com.rlag.alfabetiza_app_teste.model.Unidade;
import br.com.rlag.alfabetiza_app_teste.model.UserStatus;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("user/status") // Substitua pelo endpoint correto da sua API
    Call<UserStatus> getUserStatus();

    @GET("units") // Substitua "units" pelo endpoint correto
    Call<List<Unidade>> getUnidades();
}
