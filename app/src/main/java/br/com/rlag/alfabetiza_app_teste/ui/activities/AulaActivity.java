package br.com.rlag.alfabetiza_app_teste.ui.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.ui.PlayerView;

import br.com.rlag.alfabetiza_app_teste.R;

public class AulaActivity extends AppCompatActivity {

    private ExoPlayer player;
    private PlayerView playerView;
    private ProgressBar progressBar;
    private TextView aulaTitle;
    private Button btnContinuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aula);

        // Referências aos elementos da interface
        playerView = findViewById(R.id.playerView);
        progressBar = findViewById(R.id.progressBar);
        aulaTitle = findViewById(R.id.aulaTitle);
        btnContinuar = findViewById(R.id.btnContinuar);

        // Configurar título e progresso da aula
        configurarAula();

        // Inicializar o player de vídeo
        inicializarPlayer();

        // Configurar ação do botão "Continuar"
        btnContinuar.setOnClickListener(v -> continuarAula());
    }

    private void configurarAula() {
        aulaTitle.setText("Comparando o tamanho das palavras");
        progressBar.setProgress(50); // Progresso inicial
    }

    private void inicializarPlayer() {
        // Criar uma instância do ExoPlayer
        player = new ExoPlayer.Builder(this).build();

        // Conectar o player ao PlayerView
        playerView.setPlayer(player);

        // Configurar a mídia (exemplo: vídeo online)
        String videoUrl = "https://www.example.com/video.mp4"; // Substitua pela URL do vídeo
        MediaItem mediaItem = MediaItem.fromUri(Uri.parse(videoUrl));
        player.setMediaItem(mediaItem);

        // Preparar o player
        player.prepare();
        player.play(); // Iniciar a reprodução
    }

    private void continuarAula() {
        // Ação ao clicar em "Continuar" (exemplo: próxima atividade)
        finish(); // Finalizar a Activity atual
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (player != null) {
            player.pause();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (player != null) {
            player.release(); // Liberar recursos do player
            player = null;
        }
    }
}