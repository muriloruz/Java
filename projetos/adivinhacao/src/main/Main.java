/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import controlle.ControllerClass;
import static controlle.ControllerClass.numCerto;
import model.Pergunta;
import java.util.Scanner;
/**
 *
 * @author murilo
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pergunta p = Pergunta.getInstance();
        ControllerClass cc;
        int i = 3;
        System.out.println("Você tem 3 tentativas de acerta o número correto entre 0 e 10");
        while(i>0){
            System.out.print("Resposta ==> ");
            p.setChute(sc.nextInt());
            cc = new ControllerClass();
            if(cc.cont == 1) break;
            if(i>1)
                System.out.printf("Você ainda tem %d chances\n", i-1);
            else
                System.out.println("Acabou suas tentativas\nO número correto era "+cc.numCerto);
            i--;
        }
        
    }
}
