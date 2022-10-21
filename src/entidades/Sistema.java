/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author clebe
 */

/*
  Esta é a classe principal do sistema. Ela possui ArrayList de objetos
  Pessoa e objetos da classe Banco. É nessa classe que temos
  o menu que nos permite criar os bancos e as pessoas. Note que uma pessoa
  só se torna um cliente de uma agência a partir do momento que ela é associada
  a uma conta bancária
 */
public class Sistema {

    private ArrayList<Pessoa> pessoas = new ArrayList<>();// ArrayList de pessoas
    private ArrayList<Banco> bancos = new ArrayList<>();//ArrayList de bancos
    Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        //Chama o menu principal do sistema
        Sistema s = new Sistema();
        s.menuPrincipal();
    }

    //método que exibe o menu principal do sistema
    public void menuPrincipal() {
        while (true) {
            System.out.println("\n:: S I S T E M A   B A N C Á R I O ::");
            System.out.println("Bem-vindo(a) ao sistema. Escolha a opção desejada");
            System.out.println("1 - Administrar o Sistema");
            System.out.println("2 - Acessar como Clinete");
            System.out.println("3 - Sair");
            System.out.println("Sua opção: ");
            int opcao = Integer.parseInt(entrada.nextLine()); // Lê a opção do usuário

            switch (opcao) {
                case 1:
                    menuAdministrarSistema();// chama o menu de administração
                    break;
                case 2:
                    menuCliente();// chama o menu do cliente
                    break;
                case 3:
                    System.out.println("\nObrigado por usar o Sistema Bancário\n");
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nOpção inválida\n");
            }

        }

    }

    //menu que permite adiministrar o sistema
    public int menuAdministrarSistema() {
        while (true) {   // exibe continuamente o menu de opções         
            System.out.println("\n:: A D M I N I S T R A Ç Ã O   D O   S I S T E M A::\n");
            System.out.println("Escolha a opção desejada");
            System.out.println("1 - Gerenciar Bancos");
            System.out.println("2 - Gerenciar Pessoas");
            System.out.println("3 - Gerenciar Agências");
            System.out.println("4 - Gerenciar Contas");
            System.out.println("5 - Voltar Menu Anterior");
            System.out.println("Sua opção: ");
            int opcao = Integer.parseInt(entrada.nextLine()); // Lê a opção do usuário

            switch (opcao) {
                case 1: // vamos gerenciar os bancos
                    menuGerenciarBancos();
                    break;
                case 2: // vamos gerenciar os as pessoas(que serão futuros clientes
                    menuGerenciarPessoas();
                    break;
                case 3: // vamos gerenciar  as agências de um determinado banco
                    menuGerenciarAgencias();
                    break;
                case 4: // vamos gerenciar as contas de uma determinada  agência de um determinado banco
                    menuGerenciarContas();
                    break;
                case 5:
                    return 1; // volta para o menu Principal
                default:
                    System.out.println("Opcao inválida!! ");
            }
        }
    }

    //menu cadastrar, Listar, excluir e atualizar os bancos
    public int menuGerenciarBancos() {
        Banco temp; //serve para várias operações neste menu
        String pesquisaBanco; // serve para as pesquisas dos bancos
        while (true) {    //mostra o menu de forma repetitiva até o usuário usar a opção de sair
            System.out.println("\n:: G E R E N C I A R   B A N C O S::\n");
            System.out.println("Escolha a opção desejada");
            System.out.println("1 - Novo Banco");
            System.out.println("2 - Listas Bancos");
            System.out.println("3 - Pesquisar Bancos");
            System.out.println("4 - Excluir Banco");
            System.out.println("5 - Atualizar Banco");
            System.out.println("6 - Voltar ao Menu Anterior");
            System.out.println("Sua opção: ");
            int opcao = Integer.parseInt(entrada.nextLine()); //Lê a opção do usuário

            switch (opcao) {
                case 1:// vamos cadastrar um novo banco
                    System.out.println("\nNúmero do Banco: ");
                    String numeroBanco = entrada.nextLine();
                    System.out.println("Nome do Banco: ");
                    String nomeBanco = entrada.nextLine();
                    // vamos incrementar o contador de bancos
                    Banco.contadorBancos++;

                    //agora vamos criar um novo objeto da classe Banco
                    Banco b = new Banco(Banco.contadorBancos, nomeBanco, numeroBanco);
                    // e adicionamos no ArrayList de bancos
                    bancos.add(b);
                    // e finalmente mostramos uma mensagem de sucesso.
                    System.out.println("\nO Banco foi criado com sucesso!!!");
                    break;
                case 2:// vamos listar os bancos cadastrados
                    if (bancos.isEmpty()) {
                        System.out.println("\nNão há nenhum banco cadastrado.");
                    } else {
                        for (int i = 0; i < bancos.size(); i++) {
                            temp = bancos.get(i); // obtém o banco da iteração atual
                            System.out.println("\nId: " + temp.getId());
                            System.out.println("\nNúmero " + temp.getNumero());
                            System.out.println("\nNome " + temp.getNome());
                            System.out.println("\nQuantas agências " + temp.getAgencias().size());

                        }
                    }
                    break;
                case 3:// vamos pesquisar um banco
                    System.out.println("\nInforme o id, número ou nome do Banco");
                    pesquisaBanco = entrada.nextLine();
                    //chamamos o método que pesquisa o banco
                    temp = pesquisarBanco(pesquisaBanco);
                    if (temp == null) {// banco não encontrado
                        System.out.println("\nO banco não foi encontrado.");
                    } else {
                        //mostra o banco encontrado
                        System.out.println("\nId: " + temp.getId());
                        System.out.println("\nNúmero: " + temp.getNumero());
                        System.out.println("\nNome: " + temp.getNome());
                        System.out.println("\nQuant Agências: " + temp.getAgencias().size());
                    }
                    break;
                case 4:// vamos excluir um banco
                    System.out.println("\nInforme o id, número ou nome do Banco a ser excluído: ");
                    pesquisaBanco = entrada.nextLine();
                    //chamamos o método que pesquisa o banco
                    temp = pesquisarBanco(pesquisaBanco);
                    if (temp == null) {//banco não encontrado
                        System.out.println("\nO banco não foi encontrado.");
                    } else {
                        //vamos excluir este banco. Atenção. Ao excluir um banco, todas suas agências e contas serão excluídas também.
                        bancos.remove(temp);
                        System.out.println("\nBanco excluído com sucesso.");
                    }
                    break;
                case 5: // vamos atualizar um banco
                    System.out.println("\nInforme o id, número ou nome do Banco a ser atualizado: ");
                    pesquisaBanco = entrada.nextLine();
                    //chamamos o método que pesquisa o banco
                    temp = pesquisarBanco(pesquisaBanco);
                    if (temp == null) {//banco não encontrado
                        System.out.println("\nO banco não foi encontratdo.");
                    } else {
                        //mostra o banco encontrado
                        System.out.println("\nDados atuais deste banco:");
                        System.out.println("\nId: " + temp.getId());
                        System.out.println("\nNúmero: " + temp.getNumero());
                        System.out.println("\nNome: " + temp.getNome());
                        System.out.println("\nQuant Agências: " + temp.getAgencias().size());

                        System.out.println("\nInforme os novos dados:");
                        System.out.println("\nNovo Número do Banco: ");
                        String novoNumeroBanco = entrada.nextLine();
                        System.out.println("\nNovo nome od Banco: ");
                        String novoNomeBanco = entrada.nextLine();
                        //vamos atualizar os dados deste banco no ArrayList
                        temp.setNome(novoNomeBanco);
                        temp.setNumero(novoNumeroBanco);
                        System.out.println("\nBanco atualizado com sucesso.");
                    }
                    break;
                case 6:
                    return 0; // volta para o menu principal

            }
        }

    }

    //método que pesquisa um banco pelo id, número ou nome e retorna um objeto da classe Banco
    public Banco pesquisarBanco(String pesquisaBanco) {
        Banco b = null;

        //este banco existe?
        for (int i = 0; i < bancos.size(); i++) {
            //pesquisa pelo id
            if (Integer.toString(bancos.get(i).getId()).equals(pesquisaBanco)) {
                return bancos.get(i);
            }//pesquisar por nome
            else if (bancos.get(i).getNome().contains(pesquisaBanco)) {
                return bancos.get(i);
            }//pesquisar pelo número
            else if (bancos.get(i).getNumero().contains(pesquisaBanco)) {
                return bancos.get(i);
            }
        }
        return b;
    }

    //menu para cadastrar, listar, pesquisar, excluir e atualizar as pessoas (futuros clientes
    public int menuGerenciarPessoas() {
        Pessoa temp; // serve para várias operações neste menu
        String pesquisaPessoa; //serve para as pesquisas das pessoas 
        while (true)//mostra o menu de forma repetitiva até o usuário usar a opção de sair
        {
            System.out.println("\n:: G E R E N C I A R  P E S S O A S ::");
            System.out.println("Escolha a opção desejada");
            System.out.println("1 - Nova Pessoa (Futuro Cliente)");
            System.out.println("2 - Listar Pessoa");
            System.out.println("3 - Pesquisar Pessoa");
            System.out.println("4 - Excluir Pessoa");
            System.out.println("5 - Atualizar Pessoa");
            System.out.println("6 - Voltar Menu Anterior");
            System.out.print("Sua opção: ");
            int opcao = Integer.parseInt(entrada.nextLine());

            switch (opcao) {
                case 1:
                    System.out.println("\nNome: ");
                    String nomePessoa = entrada.nextLine();
                    System.out.println("\nIdade: ");
                    int idade = Integer.parseInt(entrada.nextLine());
                    System.out.println("\nSexo: ");
                    char sexo = entrada.nextLine().charAt(0);

                    //vamos incrementar o contador de pessoas
                    Pessoa.contadorPessoas++;
                    //agora vamos criar um objeto da classe Pessoa
                    Pessoa p = new Pessoa(Pessoa.contadorPessoas, nomePessoa, idade, sexo);
                    //e finalmente mostramos uma mensagem de sucesso.
                    System.out.println("\nA pessoa foi criada com sucesso.");
                    break;
                case 2:// vamos listas as pessoas cadastradas
                    if (pessoas.isEmpty()) {
                        System.out.println("\nNão há nenhuma pessoa cadastrada.");
                    } else {
                        for (int i = 0; i < pessoas.size(); i++) {
                            temp = pessoas.get(i);//obtém a pessoa da iteração atual
                            System.out.println("\nId: " + temp.getId());
                            System.out.println("\nNome: " + temp.getNome());
                            System.out.println("\nIdade: " + temp.getIdade());
                            System.out.println("\nSexo: " + temp.getSexo());
                            System.out.println("Quantidade de Contas Bancárias: " + temp.getContas(bancos).size());
                        }
                    }
                    break;
                case 3: // vamos pesquisar uma pessoa
                    System.out.print("\nInforme o id ou nome da pessoa: ");
                    pesquisaPessoa = entrada.nextLine();
                    //chamamos o método que pesquisa a pessoa
                    temp = pesquisarPessoa(pesquisaPessoa);
                    if (temp == null) {//pessoa não encontrada
                        System.out.println("\nA pessao não encontrada.");
                    } else // mostra e a pessoa encontrada
                    {
                        System.out.println("\nId: " + temp.getId());
                        System.out.println("\nNome: " + temp.getNome());
                        System.out.println("\nIdade: " + temp.getIdade());
                        System.out.println("\nSexo: " + temp.getSexo());
                        System.out.println("Quantidade de Contas Bancárias: " + temp.getContas(bancos).size());
                    }
                    break;
                case 4: // vamos excluir uma pessoa
                    System.out.print("\nInforme o id ou nome da pessoa a ser excluída: ");
                    pesquisaPessoa = entrada.nextLine();
                    //chamamos o método que pesquisa a pessoa
                    temp = pesquisarPessoa(pesquisaPessoa);
                    if (temp == null) {// pessoa não encontrada
                        System.out.println("\nA pessoa não foi encontrada.");
                    } else {// vamos excluir a pessoa. Atenção: Se houver contas bancárias relacionadas a esta pessoa, então a exclusão da conta bancária deverá ser feita primeiro
                        if (temp.getContas(bancos).size() > 0) {
                            System.out.println("\nOps! Esta pessoa possui contas bancárias . Exclua as contas primeiro.");
                        } else {
                            pessoas.remove(temp);
                            System.out.println("\nPessoa excluída com sucesso");
                        }
                    }
                    break;
                case 5: // vamos atualizar uma pessoa
                    System.out.print("\nInforme o id ou nome da pessoa a ser atualizada: ");
                    pesquisaPessoa = entrada.nextLine();
                    //chamamos o método que pesquisa a pessoa
                    temp = pesquisarPessoa(pesquisaPessoa);
                    if (temp == null) {//pessoa não encontrada
                        System.out.println("\nA pessoa não foi encontrada");
                    } else {//mostra a pessoa encontrada
                        System.out.println("\nId: " + temp.getId());
                        System.out.println("\nNome: " + temp.getNome());
                        System.out.println("\nIdade: " + temp.getIdade());
                        System.out.println("\nSexo: " + temp.getSexo());
                        System.out.println("Quantidade de Contas Bancárias: " + temp.getContas(bancos).size());
                        System.out.println("\nInforme os novos dados: ");
                        System.out.print("\nNovo Nome:");
                        String novoNomePessoa = entrada.nextLine();
                        System.out.print("\nNova Idade:");
                        int novaIdadePessoa = Integer.parseInt(entrada.nextLine());
                        System.out.print("\nNovo sexo: ");
                        char novoSexoPessoa = entrada.nextLine().charAt(0);
//vamos atualizar os dados desta pessoa no ArrayList
                        temp.setNome(novoNomePessoa);
                        temp.setId(novaIdadePessoa);
                        temp.setSexo(novoSexoPessoa);
                    }
                    break;
                case 6:
                    return 0; // volta para o menu principal
            }

        }

    }

    //método que pesquisa uma pessoa pelo id, número ou nome e retorna um objeto da classe Pessoa
    public Pessoa pesquisarPessoa(String pesquisaPessoa) {
        Pessoa p = null;
        //esta pessoa exite?
        for (int i = 0; i < pessoas.size(); i++) {
            //pesquisa pelo id
            if (Integer.toString(pessoas.get(i).getId()).equals(pesquisaPessoa)) {
                return pessoas.get(i);
            } else if (pessoas.get(i).getNome().contains(pesquisaPessoa)) {//pesquisar por nome
                return pessoas.get(i);
            }
        }
        return p;
    }

    //menu para cadastrar, listar, pesquisar, excluir e atualizar as agências
    public int menuGerenciarAgencias() {
        Agencia temp; // serve para várias operações neste menu 
        String pesquisaAgencia; // serve para as pesquisas das agências
        Banco bancoAtual = null; // guarda o banco atual
        //para gerenciar uma agência nós precisamos de um banco 
        while (bancoAtual) {
            System.out.println("\nInforme o id, número ou nome do banco: ");
            String pesquisaBanco = entrada.nextLine();
            //chamamos o método que pesquisa o banco
            Banco b = pesquisarBanco(pesquisaBanco);
            if (b == null) {//banco não encontrado
                System.out.println("\nO banco não foi encontrado. \n\nDigite 1 para pesquisar novamente ou 2 para voltar ao menu anterior:");
                int opcao = Integer.parseInt(entrada.nextLine());
                if (opcao == 2) {
                    return 1;// saímos daqui e voltamos para o menu anterior
                }
            } else {//banco encontrado. Vamos prosseguir com as agências
                bancoAtual = b;
            }
        }
        //Atenção: o menu abaixo deverá se exibido somente se um banco for selecionado
        while (true) {//monstra o menu de forma repetitiva até o usuário usar a opção de sair
            System.out.println("\n:: G E R E N C I A R  A G Ê N C I A ::\n");
            System.out.println("Banco Selecionado: " + bancoAtual.getNome() + "\n");

            System.out.println("Escolha o opção desejada");
            System.out.println("1 - Nova Agência");
            System.out.println("2 - Listar Agências");
            System.out.println("3 - Pesquisar Agência");
            System.out.println("4 - Excluir Agência");
            System.out.println("5 - Atualizar Agência");
            System.out.println("6 - Voltar ao menu anterior");
            System.out.print("Sua opção: ");
            int opcao = Integer.parseInt(entrada.nextLine());//lê a opção do usuário

            switch (opcao) {
                case 1://vamos cadastrar uma nova agência
                    System.out.print("\nNúmero da Agência:");
                    String numeroAgencia = entrada.nextLine();
                    System.out.print("Cidade/Estado: ");
                    String cidadeAgencia = entrada.nextLine();

                    //vamos incrementar o contador de agências
                    Agencia.contadorAgencias++;

                    //agora vamos criar um objeto da classe Agênca
                    Agencia a = new Agencia(bancoAtual, Agencia.contadorAgencias, numeroAgencia, cidadeAgencia);
                    //e o adicionamos no ArrayList de agencias do banco selecionado
                    bancoAtual.getAgencias().add(a);
                    //e finalmente mostramos uma mensagem de sucesso.
                    System.out.println("\nA Agência foi criada com sucesso.");
                    break;
                case 2: //vamos listar agências cadastradas no banco selecionado
                    if (bancoAtual.getAgencias().isEmpty()) {
                        System.out.println("\nNão há nenhuma agência cadastrada neste banco.");
                    } else {
                        for (int i = 0; i < bancoAtual.getAgencias().size(); i++) {
                            temp = bancoAtual.getAgencias().get(i); // obtém a agência da iteração atual
                            System.out.println("\nId: " + temp.getId());
                            System.out.println("\nNúmero: " + temp.getNumero());
                            System.out.println("\nCidade/Estado: " + temp.getCidade());
                            System.out.println("\nQuantas Contas Bancárias: " + temp.getContas().size());
                        }
                    }
                    break;
                case 3: //vamos pesquisar uma agência
                    System.out.print("\nInforme o id, número ou cidade da agência: ");
                    pesquisaAgencia = entrada.nextLine();
                    //chamamos o método que pesquisa a agência
                    temp = pesquisarAgencia(bancoAtual, pesquisaAgencia);
                    if (temp == null) {//agência não encontrada
                        System.out.println("\nA agência não foi encontrada");
                    } else {//mostra agência encontrada
                        System.out.println("\nId: " + temp.getId());
                        System.out.println("\nNúmero: " + temp.getNumero());
                        System.out.println("\nCidade/Estado: " + temp.getCidade());
                        System.out.println("\nQuantas Contas Bancárias: " + temp.getContas().size());
                    }
                    break;
                case 4:// vamos excluir uma agência

                    System.out.print("\nInforme o id, número ou cidade da agência");
                    pesquisaAgencia = entrada.nextLine();
                    //chamamos o método que pesquisa a agência
                    temp = pesquisarAgencia(bancoAtual, pesquisaAgencia);
                    if (temp == null) {//agência não encontrada
                        System.out.println("\nAgência não foi encontrada");
                    } else {//vamos excluir esta agência. Atenção. Ao excluir uma agência, todas suas contas serão excluídas também.
                        bancoAtual.getAgencias().remove(temp);
                        System.out.println("\nAgência excluída com sucesso.");
                    }
                    break;

                case 5: //vamos atualizar uma agência
                    System.out.println("\nInforme o id, número ou cidade da agência: ");
                    pesquisaAgencia = entrada.nextLine();
                    //chamamos o método que pesquisa a agência
                    temp = pesquisarAgencia(bancoAtual, pesquisaAgencia);
                    if (temp == null) {//agência não encontrada
                        System.out.println("\nA agência não foi encontrada");
                    } else {//mostra a agêcia encontrada
                        System.out.println(
                        "n\Dados atuais desta agência:");
                              System.out.println("\nId: " + temp.getId());
                        System.out.println("\nNúmero: " + temp.getNumero());
                        System.out.println("\nCidade/Estado: " + temp.getCidade());
                        System.out.println("\nQuantas Contas Bancárias: " + temp.getContas().size());
                    }
            }
        }
    }

}
