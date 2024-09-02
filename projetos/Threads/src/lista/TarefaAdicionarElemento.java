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
    private int numThread;
    public TarefaAdicionarElemento(Lista lista, int numThread) {
        this.lista = lista;
        this.numThread = numThread;
    }
    

    @Override
    public void run(){
        for(int j = 0;j<100;j++){
            lista.adicionaElementos("Thread "+numThread+": "+j);
        }
    }
}
