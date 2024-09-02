/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lista;

/**
 *
 * @author murilo
 */
public class Principal{
    public static void main(String[] args) throws InterruptedException{
        Lista lista = new Lista();
        for(int i =0;i<10;i++){
            Thread thread = new Thread(new TarefaAdicionarElemento(lista,i));
            thread.start();
        }
        Thread.sleep(2000);
        
        for(int k=0;k<lista.tamanho();k++) 
           System.out.println(lista.pegaElemento(k));
    }
}
