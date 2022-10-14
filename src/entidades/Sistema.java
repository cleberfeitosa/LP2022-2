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
                    if(temp == null){//banco não encontrado
                        System.out.println("\nO banco não foi encontratdo.");
                    }else{
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

}
