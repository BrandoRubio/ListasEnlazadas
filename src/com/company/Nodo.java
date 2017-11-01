package com.company;

/**
 * Created by mr boots on 23/10/2017.
 */
public class Nodo {
    Object valor;
    Nodo sig;

    public Nodo(Object valor){
        this.valor = valor;
        this.sig=null;
    }
    public void enlazarSig(Nodo n){
        sig= n;
    }
    public  Nodo obtenerSig(){
        return sig;
    }
    public Object obtenerValor(){
        return  valor;
    }
}