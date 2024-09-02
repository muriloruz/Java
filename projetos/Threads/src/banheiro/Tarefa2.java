/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banheiro;

/**
 *
 * @author murilo
 */
public class Tarefa2 implements Runnable{
    private Banheiro ban;

    public Tarefa2(Banheiro ban) {
        this.ban = ban;
    }
    @Override
    public void run(){
        ban.fazNumero2();
    }
    
}
