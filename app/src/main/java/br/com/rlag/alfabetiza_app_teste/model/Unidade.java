package br.com.rlag.alfabetiza_app_teste.model;

public class Unidade {
    private String nome;
    private int imagem; // ID do recurso da imagem
    private String descricao; // Descrição adicional da unidade (opcional)

    public Unidade(String nome, int imagem, String descricao) {
        this.nome = nome;
        this.imagem = imagem;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public int getImagem() {
        return imagem;
    }

    public String getDescricao() {
        return descricao;
    }
}
