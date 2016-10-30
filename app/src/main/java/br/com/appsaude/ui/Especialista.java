package br.com.appsaude.ui;

public class Especialista{

    private String nome;
    private float percent;
    private int imagem;

    public Especialista(String nome, float percent, int imagem){
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

    public float getPercent(){
        return percent;
    }

    public void setPercent(float percent){
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