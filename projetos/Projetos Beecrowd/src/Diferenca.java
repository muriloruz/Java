
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ruz
 */
public class Diferenca {
    public static void main(String[] args) {
        int a,b,c,d,diferenca;
        a=b=c=d=diferenca=0;
        Scanner sc = new Scanner(System.in);
        
        a=sc.nextInt();
        b=sc.nextInt();
        c=sc.nextInt();
        d=sc.nextInt();
        
       diferenca = ((a*b)-(c*d));
       
        System.out.println("DIFERENCA = "+diferenca);
    }
}
