import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        int opcao = Integer.parseInt(JOptionPane.showInputDialog(
                "Selecione uma opção:\n" +
                        "1 - Cadastrar pessoa\n" +
                        "2 - Atualizar pessoa\n" +
                        "3 - Listar pessoas\n" +
                        "4 - Deletar pessoa\n" +
                        "0 - Sair"));

        while (opcao != 0) {
            switch (opcao) {
                case 1:
                    cadastrarPessoa();
                    break;
                case 2:
                    atualizarPessoa();
                    break;
                case 3:
                    listarPessoas();
                    break;
                case 4:
                    deletarPessoa();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
                    break;
            }

            opcao = Integer.parseInt(JOptionPane.showInputDialog(
                    "Selecione uma opção:\n" +
                            "1 - Cadastrar pessoa\n" +
                            "2 - Atualizar pessoa\n" +
                            "3 - Listar pessoas\n" +
                            "4 - Deletar pessoa\n" +
                            "0 - Sair"));
        }
    }

    private static void cadastrarPessoa() {
        String nome = JOptionPane.showInputDialog("Informe o nome:");
        String endereco = JOptionPane.showInputDialog("Informe o endereço:");
        String telefone = JOptionPane.showInputDialog("Informe o telefone:");

        PessoaDAO pessoa = new PessoaDAO(nome, endereco, telefone);
        pessoa.cadastrar();
    }

    private static void atualizarPessoa() {
        String nome = JOptionPane.showInputDialog("Informe o nome:");
        String endereco = JOptionPane.showInputDialog("Informe o novo endereço:");
        String telefone = JOptionPane.showInputDialog("Informe o novo telefone:");

        PessoaDAO pessoa = new PessoaDAO(nome, endereco, telefone);
        pessoa.atualizar();
    }

    private static void listarPessoas() {
        PessoaDAO pessoa = new PessoaDAO(null, null, null);
        pessoa.listar();
    }

    private static void deletarPessoa() {
        String nome = JOptionPane.showInputDialog("Informe o nome:");

        PessoaDAO pessoa = new PessoaDAO(nome, null, null);
        pessoa.deletar();
    }
}
