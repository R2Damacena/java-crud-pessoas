import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

class PessoaDAO extends Pessoa {
    public PessoaDAO(String nome, String endereco, String telefone) {
        super(nome, endereco, telefone);
    }

    @Override
    public void mostrarDados() {
        String mensagem = "Nome: " + getNome() + "\n"
                + "Endereço: " + getEndereco() + "\n"
                + "Telefone: " + getTelefone();
        JOptionPane.showMessageDialog(null, mensagem);
    }
    @Override
    public void cadastrar() {
        try (Connection conexao = Conexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement("INSERT INTO pessoa (nome, endereco, telefone) VALUES (?, ?, ?)")) {
            stmt.setString(1, getNome());
            stmt.setString(2, getEndereco());
            stmt.setString(3, getTelefone());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Pessoa cadastrada com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar pessoa: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void atualizar() {
        try (Connection conexao = Conexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement("UPDATE pessoa SET endereco = ?, telefone = ? WHERE nome = ?")) {
            stmt.setString(1, getEndereco());
            stmt.setString(2, getTelefone());
            stmt.setString(3, getNome());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Pessoa atualizada com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar pessoa: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void listar() {
        List<PessoaDAO> pessoas = new ArrayList<>();
        try (Connection conexao = Conexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM pessoa");
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                String telefone = rs.getString("telefone");
                PessoaDAO pessoa = new PessoaDAO(nome, endereco, telefone);
                pessoas.add(pessoa);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar pessoas: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

        StringBuilder mensagem = new StringBuilder("Lista de pessoas:\n\n");
        for (PessoaDAO pessoa : pessoas) {
            mensagem.append("Nome: ").append(pessoa.getNome()).append("\n");
            mensagem.append("Endereço: ").append(pessoa.getEndereco()).append("\n");
            mensagem.append("Telefone: ").append(pessoa.getTelefone()).append("\n");
            mensagem.append("\n");
        }

        JOptionPane.showMessageDialog(null, mensagem.toString());
    }

    @Override
    public void deletar() {
        try (Connection conexao = Conexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement("DELETE FROM pessoa WHERE nome = ?")) {
            stmt.setString(1, getNome());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Pessoa deletada com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar pessoa: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}

