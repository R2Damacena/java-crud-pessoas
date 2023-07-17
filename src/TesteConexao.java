import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {
    public static void main(String[] args) {
        try {
            Connection conexao = Conexao.obterConexao();
            if (conexao != null) {
                System.out.println("Conexão estabelecida com sucesso!");
                conexao.close();
            }
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }
}