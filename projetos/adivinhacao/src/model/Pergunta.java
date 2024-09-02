/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author murilo
 */
public class Pergunta {
    private Pergunta(){}
    
    private static Pergunta instance;
    
    public static synchronized Pergunta getInstance(){
        if(instance == null){
            instance = new Pergunta();
        }
        return instance;
    }
    
    private int chute;
    
    public int getChute(){
        return this.chute;
    }
    
    public void setChute(int n){
        this.chute = n;
    }
}
