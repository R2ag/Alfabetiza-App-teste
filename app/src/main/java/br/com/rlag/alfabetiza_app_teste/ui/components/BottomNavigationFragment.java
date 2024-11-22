package br.com.rlag.alfabetiza_app_teste.ui.components;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import br.com.rlag.alfabetiza_app_teste.R;


public class BottomNavigationFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bottom_navigation, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        BottomNavigationView bottomNavigationView = view.findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.nav_estudos:
                    // Navegar para a tela de Estudos
                    break;
                case R.id.nav_conquistas:
                    // Navegar para a tela de Conquistas
                    break;
                case R.id.nav_jogos:
                    // Navegar para a tela de Jogos
                    break;
                case R.id.nav_perfil:
                    // Navegar para a tela de Perfil
                    break;
            }
            return true;
        });
    }

}