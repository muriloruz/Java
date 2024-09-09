/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

/**
 *
 * @author ruz
 */
public class TarefaAcessaBancoProcedimento implements Runnable {
    private PoolDeConexao pool;
    private GerenciadorDeTransacao tx;

    public TarefaAcessaBancoProcedimento(PoolDeConexao pool,
            GerenciadorDeTransacao tx) {
        this.pool = pool;
        this.tx = tx;
    }

    @Override
    public void run() {
        synchronized (tx) { 
            System.out.println("Peguei a chave da tx");
            tx.begin();
            synchronized (pool) { 
                System.out.println("Peguei a chave do pool");
                pool.getConnection();
            }
        }
    }
}
