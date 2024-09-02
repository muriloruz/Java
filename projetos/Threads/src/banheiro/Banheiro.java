/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banheiro;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author murilo
 */
public class Banheiro {
    public void fazNumero1(){
        String nome = Thread.currentThread().getName();
        //O marcador "synchronized" serve para sincronizar a thread, isso significa que a JVM vai esperar acabar essa thread 
        //antes de chamar outra
        synchronized (this) {
            System.out.println(nome+" entrando no banheiro");
            System.out.println(nome+" fazendo número 1");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                System.out.println("Erro: "+ex);
            }
            System.out.println(nome+" dando descarga");
            System.out.println(nome+" lavando a mão");
            System.out.println(nome+" saindo do banheiro");
        }
    }
    public void fazNumero2(){
        String nome = Thread.currentThread().getName();
        //O marcador "synchronized" serve para sincronizar a thread, isso significa que a JVM vai esperar acabar essa thread 
        //antes de chamar outra
        synchronized (this) {
            System.out.println(nome+" entrando no banheiro");
            System.out.println(nome+" fazendo número 2");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                System.out.println("Erro: "+ex);
            }
            System.out.println(nome+" dando descarga");
            System.out.println(nome+" lavando a mão");
            System.out.println(nome+" saindo do banheiro");
        }
    }
}
