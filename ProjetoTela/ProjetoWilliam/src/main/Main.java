/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import java.sql.Timestamp;
import model.Produto;
/**
 * @since 27/05/2024 
 * @author murilo ruz
 */
public class Main {
    public static void main(String[] args) {
        java.util.Date dataAgora = new java.util.Date();
        Timestamp tmstp = new Timestamp(dataAgora.getTime());
        controle.Conection con = new controle.Conection();
        con.conectar();
        Produto p1 = Produto.getInstance();
        p1.setCod("PROD1");
        p1.setStatus('P');
        p1.setNome("Box of goodgood");
        p1.setDescricao("Uma box of goodgood muito gostosa, yam yam");
        p1.setQtd_estoque(5);
        p1.setEstoque_minimo(1);
        p1.setEstoque_maximo(10);
        p1.setPrecoCompra(5.5);
        p1.setPrecoVenda(8.0);
        p1.setBar_code(123456789L);
        p1.setNcm(1234567890123456786L);
        p1.setFator(5.9);
        p1.setData_cadastro(tmstp);
        p1.setImagem("/boxOfGoodGood.png");
        con.inserir();
        
    }
}
