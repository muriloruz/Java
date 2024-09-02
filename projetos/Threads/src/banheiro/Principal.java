/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banheiro;

/**
 *
 * @author murilo
 */
public class Principal {
    public static void main(String[] args) {
        Banheiro ban = new Banheiro();
        Thread t1 = new Thread(new Tarefa1(ban),"Alexandre");
        Thread t2 = new Thread(new Tarefa2(ban),"Robert");
        t1.start();
        t2.start();
    }
}
