package br.com.appsaude.ui;

/**
 * Created by gcdpinho on 16/11/16.
 */

public class Doenca {

    private String nomeDoenca;
    private String descDoenca;
    private String porc;

    public Doenca(String nome, String desc, String porc){
        this.nomeDoenca = nome;
        this.descDoenca = desc;
        this.porc = porc;
    }

    public String getNomeDoenca(){
        return this.nomeDoenca;
    }

    public void setNomeDoenca(String nome){
        this.nomeDoenca = nome;
    }

    public String getDescDoenca(){
        return this.descDoenca;
    }

    public void setDescDoenca(String desc){
        this.descDoenca = desc;
    }

    public String getPorc(){
        return this.porc;
    }

    public void setPorc(String porc){
        this.porc = porc;
    }

}
