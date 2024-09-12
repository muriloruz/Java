
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
public class Media2 {
    public static void main(String[] args) {
        double n1,n2,n3, media;
        n1=n2=media=n3=0.0;
        Scanner sc = new Scanner(System.in);
        
        sc.useLocale(Locale.US);
        n1 = sc.nextDouble();
        n2 = sc.nextDouble();
        n3 = sc.nextDouble();
        
        n1 = n1*2;
        n2 = n2*3;
        n3 = n3*5;
        media = (n1+n2+n3)/10;
        
        System.out.printf("MEDIA = %.1f\n",media);
    }
}
