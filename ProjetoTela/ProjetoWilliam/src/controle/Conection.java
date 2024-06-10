package controle;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.Instant;

public class Conection {
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultset = null;
    
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

    public void inserir(String cod, String status, String nome, String desc, String qntdEstoque, String estqMin, String estqMax, String pcCompra, String pcVenda, String codBarras, String ncm, String fatorLu, Instant data, String enderecoImagem) {
        conectar();
        String query = "INSERT INTO produto (cod, status, nome, descricao, qtd_estoque, estoque_minimo, estoque_maximo, preco_compra, preco_venda, bar_code, ncm, fator, data_cadastro, imagem) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        try (PreparedStatement preStatement = this.connection.prepareStatement(query)) {
            System.out.println(query);

            preStatement.setString(1, cod);
            preStatement.setString(2, status);
            preStatement.setString(3, nome);
            preStatement.setString(4, desc);
            preStatement.setInt(5, Integer.parseInt(qntdEstoque));
            preStatement.setInt(6, Integer.parseInt(estqMin));
            preStatement.setInt(7, Integer.parseInt(estqMax));
            preStatement.setBigDecimal(8, new BigDecimal(pcCompra));  // Assuming pcCompra is a string representation of a decimal
            preStatement.setBigDecimal(9, new BigDecimal(pcVenda));    // Assuming pcVenda is a string representation of a decimal
            preStatement.setString(10, codBarras);
            preStatement.setString(11, ncm);
            preStatement.setString(12, fatorLu);
            preStatement.setTimestamp(13, Timestamp.from(data));
            preStatement.setString(14, enderecoImagem);

            preStatement.executeUpdate();

            System.out.println("Registro inserido com sucesso");

        } catch (Exception e) {
            System.out.println("Erro: " + e.toString());
        } finally {
            try {
                if (this.connection != null) {
                    this.connection.close();
                }
            } catch (Exception e) {
                System.out.println("Erro ao fechar conexão: " + e.toString());
            }
        }
    }
    public void update(String cod, String status, String nome, String desc, String qntdEstoque, String estqMin, String estqMax, String pcCompra, String pcVenda, String codBarras, String ncm, String fatorLu, Instant data, String enderecoImagem) {
        conectar();
        String query = "UPDATE produto (cod, status, nome, descricao, qtd_estoque, estoque_minimo, estoque_maximo, preco_compra, preco_venda, bar_code, ncm, fator, data_cadastro, imagem) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        try (PreparedStatement preStatement = this.connection.prepareStatement(query)) {
            System.out.println(query);

            preStatement.setString(1, cod);
            preStatement.setString(2, status);
            preStatement.setString(3, nome);
            preStatement.setString(4, desc);
            preStatement.setInt(5, Integer.parseInt(qntdEstoque));
            preStatement.setInt(6, Integer.parseInt(estqMin));
            preStatement.setInt(7, Integer.parseInt(estqMax));
            preStatement.setBigDecimal(8, new BigDecimal(pcCompra));  // Assuming pcCompra is a string representation of a decimal
            preStatement.setBigDecimal(9, new BigDecimal(pcVenda));    // Assuming pcVenda is a string representation of a decimal
            preStatement.setString(10, codBarras);
            preStatement.setString(11, ncm);
            preStatement.setString(12, fatorLu);
            preStatement.setTimestamp(13, Timestamp.from(data));
            preStatement.setString(14, enderecoImagem);

            preStatement.executeUpdate();

            System.out.println("Registro inserido com sucesso");

        } catch (Exception e) {
            System.out.println("Erro: " + e.toString());
        } finally {
            try {
                if (this.connection != null) {
                    this.connection.close();
                }
            } catch (Exception e) {
                System.out.println("Erro ao fechar conexão: " + e.toString());
            }
        }
    }
   public void deletarProduto(String cod) {
        conectar();
        String query = "DELETE FROM produto WHERE cod = ?";

        try (PreparedStatement ps = this.connection.prepareStatement(query)) {
            ps.setString(1, cod);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Registro deletado com sucesso.");
            } else {
                System.out.println("Nenhum registro encontrado com o código fornecido.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao deletar registro: " + e.toString());
        }
    }
}