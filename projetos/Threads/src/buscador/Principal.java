/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buscador;
import java.util.Scanner;
/**
 *
 * @author murilo
 */
public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nome = sc.nextLine();
        Thread threadAssinaturas = new Thread(new TarefaBuscaTextual("src/buscador/assinaturas1.txt",nome));
        Thread threadAssinaturas2 = new Thread(new TarefaBuscaTextual("src/buscador/assinaturas2.txt",nome));
        Thread threadAutores = new Thread(new TarefaBuscaTextual("src/buscador/autores.txt",nome));
        
        
        threadAssinaturas.start();
        threadAssinaturas2.start();
        threadAutores.start();
        
    }
}
