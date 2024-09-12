/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Locale;
import java.util.Scanner;
/**
 *
 * @author ruz
 */
public class AreaDoCirculo {
    public static void main(String[] args) {
        double a = 0.0;
        double pi = 3.14159;
        double r = 0.0;
        Scanner sc = new Scanner(System.in);
        
        sc.useLocale(Locale.US);
        r = sc.nextDouble();
        
        a = pi * (r*r);
        String respA = String.format("A=%.4f",a);
        System.out.println(respA);
    }
}
