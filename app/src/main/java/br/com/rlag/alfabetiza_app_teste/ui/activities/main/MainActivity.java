package br.com.rlag.alfabetiza_app_teste.ui.activities.main;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import br.com.rlag.alfabetiza_app_teste.R;
import br.com.rlag.alfabetiza_app_teste.ui.components.BottomNavigationFragment;
import br.com.rlag.alfabetiza_app_teste.ui.components.TopBarFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Carregar fragmentos reutilizáveis
        carregarTopBar();
        carregarBottomNavigation();
        carregarConteudoPrincipal();
    }

    private void carregarTopBar() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.top_bar_fragment, new TopBarFragment());
        transaction.commit();
    }

    private void carregarBottomNavigation() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.bottom_nav_fragment, new BottomNavigationFragment());
        transaction.commit();
    }

    private void carregarConteudoPrincipal() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container_content, new ContentFragment());
        transaction.commit();
    }
}