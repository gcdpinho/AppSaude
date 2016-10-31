package br.com.appsaude.ui;

public class Especialista{

    private String nome;
    private String percent;
    private int imagem;

    public Especialista(String nome, String percent, int imagem){
        super();
        this.nome = nome;
        this.percent = percent;
        this.imagem = imagem;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getPercent(){
        return percent;
    }

    public void setPercent(String percent){
        this.percent = percent;
    }

    public int getImagem(){
        return imagem;
    }

    public void setImagem(int imagem){
        this.imagem = imagem;
    }

    @Override
    public String toString() {
        return nome;
    }
}