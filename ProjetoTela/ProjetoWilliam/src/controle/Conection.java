/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import model.Produto;
/**
 *
 * @author murilo ruz
 */
public class Conection {
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultset = null;
    private Produto prod;
    public void conectar() {
        String servidor = "jdbc:mysql://127.0.0.1:3306/sistema";
        String usuario = "root";
        String senha = "";
        String driver = "com.mysql.cj.jdbc.Driver";

        try {
            Class.forName(driver);
            this.connection = DriverManager.getConnection(servidor, usuario, senha);
            this.statement = this.connection.createStatement();
            System.out.println("Conectado");
        } catch (Exception e) {
            System.out.println("ERRO\n" + e.toString());
        }
    }
}
