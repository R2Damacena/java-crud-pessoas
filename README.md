# Projeto de Manipulação de Dados de Pessoas em Java

Este é um projeto em Java que demonstra a manipulação de dados de pessoas, utilizando conceitos de orientação a objetos e persistência em um banco de dados MySQL. O projeto possui uma estrutura básica que permite a criação, atualização, listagem e exclusão de pessoas.

## Tecnologias utilizadas

- Java
- MySQL
- JDBC (Java Database Connectivity)
- IDE: IntelliJ IDEA (ou outra de sua preferência)

## Requisitos cumpridos

- Herança: O projeto utiliza herança ao ter a classe `PessoaDAO` estendendo a classe abstrata `Pessoa`. A classe `PessoaDAO` herda os atributos e métodos da classe `Pessoa`, aproveitando a reutilização de código.
- Polimorfismo: O projeto utiliza polimorfismo ao implementar a interface `OperacoesPessoa` na classe `PessoaDAO` e sobrescrever os métodos definidos na interface. Isso permite que os objetos `PessoaDAO` sejam tratados polimorficamente como objetos do tipo `OperacoesPessoa`.
- Classe abstrata: O projeto possui a classe abstrata `Pessoa`, que contém implementações parciais de métodos e serve como base para as subclasses concretas, como `PessoaDAO`.
- Interface: O projeto utiliza a interface `OperacoesPessoa`, que define um contrato para as classes que a implementam. A interface fornece a assinatura dos métodos que devem ser implementados pelas classes concretas.
- Encapsulamento: Os atributos `nome`, `endereco` e `telefone` na classe `Pessoa` são encapsulados usando modificadores de acesso privado. Os métodos getters e setters são usados para acessar e modificar esses atributos de forma controlada.
- Métodos ou atributo estáticos: O projeto possui um método estático na classe `Conexao` para obter uma conexão com o banco de dados sem a necessidade de instanciar um objeto. Isso permite o acesso à conexão de forma direta e estática.
- Tratamento de exceção: O projeto utiliza blocos try-catch para capturar e tratar exceções do tipo `SQLException`. Isso garante que os erros de banco de dados sejam tratados corretamente e que as mensagens de erro sejam exibidas de forma adequada.
- ArrayList: O projeto utiliza a classe `ArrayList` para armazenar objetos do tipo `PessoaDAO` e construir uma lista de pessoas cadastradas. Isso permite adicionar, remover e iterar sobre os objetos de forma flexível.

## Configuração do ambiente

1. Certifique-se de ter o JDK (Java Development Kit) instalado em sua máquina. O projeto foi desenvolvido utilizando a versão 19 do JDK.
2. Faça o download e instalação do MySQL Server e do MySQL Workbench em sua máquina.
3. Importe o projeto em sua IDE (como o IntelliJ IDEA) utilizando o recurso de importação de projeto.

## Configuração do banco de dados

1. Abra o MySQL Workbench e crie um novo banco de dados chamado `pessoas_db`.
2. Utilize o script SQL fornecido no projeto na pasta resources(`script.sql`) para criar a tabela `pessoa` dentro do banco de dados `pessoas_db`.

## Configuração do JDBC

1. Faça o download do driver JDBC do MySQL correspondente à versão do seu banco de dados MySQL.
2. Adicione o driver JDBC às dependências do projeto em sua IDE.

## Executando o projeto

1. Abra o projeto em sua IDE.
2. Certifique-se de que a configuração de conexão com o banco de dados (URL, usuário, senha) está correta no arquivo `Conexao.java`.
3. Execute a classe `Main` para iniciar o programa.
4. A aplicação exibirá um menu com as opções disponíveis: cadastrar, atualizar, listar ou deletar uma pessoa. Siga as instruções fornecidas na interface para interagir com o sistema.

## Contribuição

Sinta-se à vontade para contribuir com melhorias, correções de bugs ou adição de novos recursos para este projeto. Basta fazer um fork do repositório, criar um branch com suas modificações e enviar um pull request.
