/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;
import com.mysql.cj.jdbc.PreparedStatementWrapper;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import model.Produto;
import java.sql.PreparedStatement;
import java.time.Instant;
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
    public void inserir(String cod, String status,String nome,String desc, String qntdEstoque, String estqMin, String estqMax,String pcCompra,String pcVenda,String codBarras,String ncm,String fatorLu,Instant data ,String enderecoImagem){
        String query = "INSERT INTO `produto` (`cod`, `status`, `nome`, `descricao`, `qtd_estoque`, `estoque_minimo`, `estoque_maximo`, `preco_compra`, `preco_venda`, `bar_code`, `ncm`, `fator`, `data_cadastro`, `imagem`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try(PreparedStatement preStatement = this.connection.prepareStatement(query)){
                
                
                System.out.println(query);
                
                preStatement.setString(1, cod);//codigo
                preStatement.setString(2, status);//Status
                preStatement.setString(3, nome);//nome
                preStatement.setString(4, desc);//descriçãoS
                preStatement.setInt(5, parseInt(qntdEstoque));//qtd_estoque
                preStatement.setInt(6, parseInt(estqMin));//estoque_minimo
                preStatement.setInt(7, parseInt(estqMax));//estoque_maximo
                preStatement.setString(8, pcCompra);//preco_compra
                preStatement.setString(9, pcVenda);//preco_venda
                preStatement.setString(10, codBarras);//bar_code
                preStatement.setString(11, ncm);//ncm
                preStatement.setString(12, fatorLu);//fator
                preStatement.setTimestamp(13,Timestamp.from(data));
                preStatement.setString(14,enderecoImagem);
                
                
                System.out.println("Registro inserido com sucesso");
                
            } catch (Exception e) {
                System.out.println("Erro:" + e.toString());
            }
        
    }
}
