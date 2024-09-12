
import java.util.Locale;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ruz
 */
public class Salario {
    public static void main(String[] args) {
        int cod, horas;
        double dmv, sal;
        Scanner sc = new Scanner(System.in);
        
        cod = sc.nextInt();
        horas = sc.nextInt();
        sc.useLocale(Locale.US);
        dmv = sc.nextDouble();
        
        sal = horas*dmv;
        
        System.out.printf("NUMBER = %d\nSALARY = U$ %.2f\n",cod,sal);
    }
}
