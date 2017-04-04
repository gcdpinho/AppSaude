package br.com.appsaude.model;

public class Profissional {

    private String nome, endereco, fone, plano, email;
    private int imagem;

    public Profissional(String nome, String endereco, String fone, String plano, String email, int imagem){
        this.nome = nome;
        this.endereco = endereco;
        this.fone = fone;
        this.plano = plano;
        this.email = email;
        this.imagem = imagem;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getEndereco(){
        return this.endereco;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    public String getFone(){
        return this.fone;
    }

    public void setFone(String fone){
        this.fone = fone;
    }

    public String getPlano(){
        return this.plano;
    }

    public void setPlano(String plano){
        this.plano = plano;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public int getImagem(){
        return this.imagem;
    }

    public void setImagem(int imagem){
        this.imagem = imagem;
    }
}
