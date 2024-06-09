/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.math.BigDecimal;
import java.sql.Timestamp;
/**
 *
 * @author murilo ruz
 */
public class Produto {
    private String cod;
    private char status;
    private String nome;
    private String descricao;
    private int qtd_estoque;
    private int estoque_minimo;
    private int estoque_maximo;
    private double precoCompra;
    private double precoVenda;
    private long bar_code;
    private long ncm;
    private double fator;
    private Timestamp data_cadastro;
    private String imagem;
    private static Produto instanciaUnica;
    
    private Produto(){}
    
    public static Produto getInstance(){
        if (instanciaUnica == null) {
            instanciaUnica = new Produto();
        }
        return instanciaUnica;
    }
    
    public String getCod() {
        return cod;
    }

    public char getStatus() {
        return status;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getQtd_estoque() {
        return qtd_estoque;
    }

    public int getEstoque_minimo() {
        return estoque_minimo;
    }

    public int getEstoque_maximo() {
        return estoque_maximo;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public long getBar_code() {
        return bar_code;
    }

    public long getNcm() {
        return ncm;
    }

    public double getFator() {
        return fator;
    }

    public Timestamp getData_cadastro() {
        return data_cadastro;
    }

    public String getImagem() {
        return imagem;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setQtd_estoque(int qtd_estoque) {
        this.qtd_estoque = qtd_estoque;
    }

    public void setEstoque_minimo(int estoque_minimo) {
        this.estoque_minimo = estoque_minimo;
    }

    public void setEstoque_maximo(int estoque_maximo) {
        this.estoque_maximo = estoque_maximo;
    }

    public void setPrecoCompra(double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public void setBar_code(long bar_code) {
        this.bar_code = bar_code;
    }

    public void setNcm(long ncm) {
        this.ncm = ncm;
    }

    public void setFator(double fator) {
        this.fator = fator;
    }

    public void setData_cadastro(Timestamp data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
    
    public void printarDados(){
        System.out.println(this.bar_code);
        System.out.println(this.cod);
        System.out.println(this.data_cadastro);
        System.out.println(this.descricao);
        System.out.println(this.estoque_maximo);
        System.out.println(this.estoque_minimo);
        System.out.println(this.fator);
        System.out.println(this.imagem);
        System.out.println(this.ncm);
        System.out.println(this.nome);
        System.out.println(this.precoCompra);
        System.out.println(this.precoVenda);
        System.out.println(this.qtd_estoque);
        System.out.println(this.status);
    }
}
