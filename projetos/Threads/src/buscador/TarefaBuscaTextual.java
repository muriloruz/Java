/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buscador;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author murilo
 */
public class TarefaBuscaTextual implements Runnable {
    private String nomeArquivo;
    private String nome;

    public TarefaBuscaTextual(String nomeArquivo, String nome) {
        this.nomeArquivo = nomeArquivo;
        this.nome = nome;
    }
    @Override
    public void run(){
        int cont = 0;
        try {
            
            Scanner scanner = new Scanner(new File(nomeArquivo));
            int numeroLinha = 1;
            while(scanner.hasNextLine()){
                String linha = scanner.nextLine();
                if(linha.toLowerCase().contains(nome.toLowerCase())){
                    System.out.println(nomeArquivo+" - "+linha+" - Linha: "+numeroLinha);
                    cont = 99;
                }
                numeroLinha++;
            }
             if(cont!=99){
                 System.out.println("Not found");
             }
            
            scanner.close();
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
    
}
