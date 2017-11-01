package com.company;
import java.util.Scanner;

/**
 * Created by mr boots on 23/10/2017.
 */
public class Lista {
    Nodo cabeza;
    int size;
    Scanner sc = new Scanner(System.in);

    public void setSize(int size) {
        this.size = size;
    }

    public Lista(){
        cabeza = null;
    }

    public boolean estaVacio(){
        return (cabeza==null)? true:false;
    }
    public int getSize(){
        return size;
    }
    public Object obtener(int index){
        int contador =0;
        Nodo temporal = cabeza;
        while (contador < index){
            temporal = temporal.obtenerSig();
            contador++;
        }
        return temporal.obtenerValor();
    }
    public void addPrimero(Object obj){
        if (cabeza==null) {
            cabeza = new Nodo(obj);
        }else {
            Nodo temp = cabeza;
            Nodo nuevo = new Nodo(obj);
            nuevo.enlazarSig(temp);
            cabeza = nuevo;
        }
        size++;
    }

    public void eliminar(Object valor)
    {
        Nodo temp = cabeza;
        if(valor==temp.obtenerValor()){
            cabeza = cabeza.obtenerSig();
        }else{

            while (temp.obtenerSig().obtenerValor()==valor) {
                temp=temp.obtenerSig();
            }
            cabeza.enlazarSig(temp.obtenerSig().obtenerSig());

        }
        size--;
    }
    public void buscar(Object valor)
    {   int i=0;
        Nodo temp = cabeza;
        if(valor==temp.obtenerValor()){
            cabeza = cabeza.obtenerSig();
        }else{

            while (temp.obtenerSig().obtenerValor()==valor) {
                temp=temp.obtenerSig();
            }
            cabeza.enlazarSig(temp.obtenerSig().obtenerSig());

        }
        size--;
    }



    public void Mostrar(){
        Nodo temp = cabeza;
        if (temp!=null){
            System.out.println("Estos son los datos: ");
            while(temp!=null){
                System.out.println(temp.valor.toString()+" ");
                temp = temp.obtenerSig();
            }
        }
    }
    public void MostrarMenu() {
        int decision;
        Object valor;

        do {
            System.out.println("Elige una opción:");
            System.out.println("1)Insertar\n2)Mostrar\n3)Buscar\n4)Eliminar\n5)Contar\n6)Terminar");
            decision = sc.nextInt();
            switch (decision) {
                case 1: {
                    System.out.println("Inserta un valor:");
                    valor = sc.next();
                    addPrimero(valor);
                    decision = 2;
                    break;
                }
                case 2: {
                    System.out.println("---------------------------");
                    if (estaVacio() == true)
                        System.out.println("La lista está vacía");
                    else
                        Mostrar();
                    System.out.println("---------------------------");
                    break;
                }
                case 4:
                {
                    System.out.println("¿Que valor quieres eliminar ?");
                    valor = sc.next();
                     eliminar(valor);
                     break;
                }
                case 5: {
                    System.out.println("Tamaño: " + getSize());
                    break;
                }
                case 6:{
                    System.exit(0);
                }
                default: {
                    System.out.println("Vuelve a elegir la opción");
                    break;
                }
            }
        } while (decision!=6);
    }
}
