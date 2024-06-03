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
    public void inserir() {
        prod = Produto.getInstance();
        try {
            String query = "INSERT INTO `produto` (`id`,`cod`, `status`, `nome`, `descricao`, `qtd_estoque`, `estoque_minimo`, `estoque_maximo`, `preco_compra`, `preco_venda`, `bar_code`, `ncm`, `fator`, `data_cadastro`, `imagem`)"
                    + " VALUES (NULL, '" + prod.getCod() + "', '" + prod.getStatus() + "', '" + prod.getNome() + "', '" + prod.getDescricao() + "', '" + prod.getQtd_estoque() + "', '" + prod.getEstoque_minimo() + "', '" + prod.getEstoque_maximo() + "', '" + prod.getPrecoCompra() + "', '" + prod.getPrecoVenda() + "', '" + prod.getBar_code() + "', '" + prod.getNcm() + "', '" + 
                    prod.getFator()+ "', '" + prod.getData_cadastro()+ "', '" + prod.getImagem() +"')";
            System.out.println(query);
            this.statement.execute(query);
            System.out.println("Registro inserido com sucesso");
        } catch (Exception e) {
            System.out.println("Erro:" + e.toString());
        }
    }
}
