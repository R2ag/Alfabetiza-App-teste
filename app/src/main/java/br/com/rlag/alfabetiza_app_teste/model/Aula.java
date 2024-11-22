package br.com.rlag.alfabetiza_app_teste.model;

public class Aula {
    private String titulo;
    private int imagem;

    public Aula(String titulo, int imagem) {
        this.titulo = titulo;
        this.imagem = imagem;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getImagem() {
        return imagem;
    }
}
