/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lista;

/**
 *
 * @author murilo
 */
public class TarefaAdicionarElemento implements Runnable {
    private Lista lista;
    private int numeroDaThread;
     public TarefaAdicionarElemento(Lista lista, int numero) {
        this.lista = lista;
        this.numeroDaThread =  numero;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            lista.adicionaElementos("Thread " + numeroDaThread + " - " + i );
        }
    }
}
