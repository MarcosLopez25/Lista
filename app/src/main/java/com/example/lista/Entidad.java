package com.example.lista;

public class Entidad {
    private int imgEdit;
    private int imgErase;
    private String txtValor;

    public Entidad(String txtValor, int imgEdit, int imgErase){
        this.txtValor = txtValor;
        this.imgEdit = imgEdit;
        this.imgErase = imgErase;
    }

    public String getTxtValor(){
        return txtValor;
    }

    public int getImgEdit(){
        return imgEdit;
    }

    public  int getImgErase(){
        return imgErase;
    }

}
