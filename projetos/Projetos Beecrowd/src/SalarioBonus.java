
import java.math.BigDecimal;
import java.math.RoundingMode;
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
public class SalarioBonus {
    public static void main(String[] args) {
        String nome = " ";
        BigDecimal porcent = BigDecimal.ZERO;
        BigDecimal venda = BigDecimal.ZERO;
        BigDecimal salario = BigDecimal.ZERO;
        BigDecimal nSalario = BigDecimal.ZERO;
        Scanner sc = new Scanner(System.in);
        
        nome = sc.next();
        sc.useLocale(Locale.US);
        
        salario = sc.nextBigDecimal();
        venda = sc.nextBigDecimal();
        
        porcent = venda.multiply(BigDecimal.valueOf(0.15));
        porcent = porcent.setScale(2, RoundingMode.HALF_EVEN);
        
        nSalario = salario.add(porcent);
        nSalario = nSalario.setScale(2, RoundingMode.HALF_EVEN);
        
        System.out.printf(Locale.US, "TOTAL = R$ %.2f\n", nSalario);
    }
}
