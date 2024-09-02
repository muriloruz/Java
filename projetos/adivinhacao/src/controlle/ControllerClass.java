/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlle;


import java.util.Scanner;
import java.util.Random;
import model.Pergunta;
/**
 *
 * @author murilo
 */
public class ControllerClass {
    private static Random rand = new Random();
    public static int numCerto = rand.nextInt(10);
    public Pergunta p = Pergunta.getInstance();
    
    public int cont=0;
    
    public ControllerClass(){
            
        
            if(p.getChute() == numCerto){
                System.out.println("Acertou!!");
                cont = 1;
            }else if(p.getChute() > numCerto){
                System.out.println("O número chutado é menor que o número certo");
            }else{
                System.out.println("O número chutado é maior que o número certo");
            }
    }
}
