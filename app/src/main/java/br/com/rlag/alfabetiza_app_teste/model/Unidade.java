package br.com.rlag.alfabetiza_app_teste.model;

public class Unidade {
    private int id;          // ID da unidade
    private String nome;     // Nome da unidade
    private String imagem;   // URL da imagem da unidade (se necessário)

    // Getters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getImagem() {
        return imagem;
    }

    // Setters (opcional)
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
