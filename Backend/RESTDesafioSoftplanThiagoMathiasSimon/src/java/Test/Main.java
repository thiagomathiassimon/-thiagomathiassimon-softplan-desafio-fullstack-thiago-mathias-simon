/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import DAO.ProcessoDAO;
import Model.Processo;
import DAO.UsuarioDAO;
import Model.Usuario;
import java.util.Scanner;

/**
 *
 * @author Thiago Mathias Simon
 */
public class Main {

    public static void main(String[] args) {

        Main m = new Main();

        m.inicio();
    }

    public Scanner getScanner() {
        return new Scanner(System.in);
    }

    public void inicio() {

        System.out.println("1) Cadastrar Usuario e Senha");
        System.out.println("2) Acessar Sistema");
        System.out.println("3) Enviar Email");
        System.out.println("4) Sair");
        System.out.print("\nOpção: ");
        int entrada = getScanner().nextInt();

        switch (entrada) {

            case 1:
                add_usuario();
            case 2:
                acesso();
            case 3:
                System.exit(0);
            default:
                System.out.println("Digite uma opção valida!");
        }

    }

    private void acesso() {

        System.out.print("Digite o email: ");
        String email = getScanner().nextLine();
        System.out.print("Digite a senha: ");
        String senha = getScanner().nextLine();

        UsuarioDAO udao = new UsuarioDAO();

        while (udao.acesso_usuario(email, senha)) {
            if (true) {
                System.out.println("\nAcesso permitido\n");
                menu();
            } else {
                inicio();
            }
        }
    }

    public void menu() {

        System.out.println("1) Cadastrar Usuario");
        System.out.println("2) Listar Todos Usuarios");
        System.out.println("3) Excluir Usuario");
        System.out.println("4) Alterar Usuario");

        System.out.println("5) Cadastrar Processo");
        System.out.println("6) Listar Todos os Processos");
        System.out.println("7) Excluir Processo");
        System.out.println("8) Alterar Processo");

        System.out.println("9) Sair");
        System.out.print("Opção: ");
        int op = getScanner().nextInt();

        switch (op) {

            case 1:
                add_usuario();
            case 2:
                listar_usuario();
            case 3:
                excluir_usuario();
            case 4:
                alterar_usuario();
            case 5:
                add_processo();
            case 6:
                listar_processo();
            case 7:
                excluir_processo();
            case 8:
                alterar_processo();
            case 9:
                System.exit(0);

            default:
                System.out.println("Digite uma opção valida!");
                menu();
        }
    }

    private void add_usuario() {

        System.out.print("\nDigite o nome: ");
        String nome = getScanner().nextLine();
        System.out.print("Digite o cpf: ");
        String cpf = getScanner().nextLine();
        System.out.print("Digite o email: ");
        String email = getScanner().nextLine();
        System.out.print("Digite o telefone: ");
        String telefone = getScanner().nextLine();
        System.out.print("Digite a senha: ");
        String senha = getScanner().nextLine();
        System.out.println("Informe o nível: ");
        String nivel = getScanner().nextLine();

        //Instanciei um usuario, normal...
        Usuario u = new Usuario(nome, cpf, email, telefone, senha, nivel);
        //Instanciando a classe DAO do Usuario, chamando o metodo add_usuario e passando como parametro o usuario
        //criado acima
        UsuarioDAO udao = new UsuarioDAO();
        udao.add_usuario(u);

        menu();
    }

    public void listar_usuario() {

        //Instanciando a classe DAO do usuario
        UsuarioDAO udao = new UsuarioDAO();

        System.out.println("\t\n--- Todos os usuarios ---\n");

        //Passando um for no arraylist que o metodo mostrar_usuario retorna
        for (Usuario u : udao.mostrar_usuarios()) {
            System.out.println("ID do usuario: " + u.getId_usuario());
            System.out.println("Nome: " + u.getNome());
            System.out.println("CPF: " + u.getCpf());
            System.out.println("Email: " + u.getEmail());
            System.out.println("Telefone: " + u.getTelefone());
            System.out.println("Senha: " + u.getSenha());
            System.out.println("Nível: " + u.getNivel() + "\n");

        }
        menu();
    }

    public void excluir_usuario() {

        UsuarioDAO cdao = new UsuarioDAO();

        System.out.print("\nDigite o número id para excluir: ");
        int id_usuario = getScanner().nextInt();

        //Metodo que remove o carro pelo numero do chassi
        cdao.delete_usuario(id_usuario);
        menu();

    }

    public void alterar_usuario() {

        //Tem varias forma de fazer essa alteração, escolhi encontrar o carro  chamando o metodo achar_carro da classe DAO, 
        //mostrar ele, e dar a liberdade de alterar todas as informações, em seguida passando essas novas informaçoes
        //pro metodos altera_carro da classe CarroDAO
        UsuarioDAO cdao = new UsuarioDAO();

        System.out.print("\nDigite o número do id para alterar: ");
        int id_usuario = getScanner().nextInt();

        Usuario u = cdao.achar_usuario(id_usuario);

        System.out.println("\nAlterando Informações do Usuario: \n");
        System.out.println("Nome: " + u.getNome());
        System.out.println("CPF_CNPJ: " + u.getCpf());
        System.out.println("Email: " + u.getEmail());
        System.out.println("Telefone: " + u.getTelefone());
        System.out.println("Senha: " + u.getSenha());
        System.out.println("Nívrl" + u.getNivel());

        System.out.println("Digite as novas informações: \n");
        System.out.print("Digite o Nome: ");
        String nome = getScanner().nextLine();
        System.out.print("Digite o cpf: ");
        String cpf = getScanner().nextLine();
        System.out.print("Digite o email: ");
        String email = getScanner().nextLine();
        System.out.print("Digite o telefone: ");
        String telefone = getScanner().nextLine();
        System.out.print("Digite a senha: ");
        String senha = getScanner().nextLine();
        System.out.println("Digite o nível");
        String nivel = getScanner().nextLine();

        //Passando como parametro as informações e o numero do chassi do carro que foi digitado e posteriormente encontrado
        //cdao.alterar_usuario(u.getId(), nome, cpf, email, telefone, senha, cep, rua, complemento, numero, bairro, cidade, estado);
        cdao.alterar_usuario(u.getId_usuario(), nome, cpf, email, telefone, senha, nivel);
        menu();
    }

    private void add_processo() {

        System.out.print("\nDigite o titulo: ");
        String titulo = getScanner().nextLine();
        System.out.print("Digite o subtitulo: ");
        String subtitulo = getScanner().nextLine();
        System.out.print("Digite o descricao: ");
        String descricao = getScanner().nextLine();
        System.out.print("Digite o usuario: ");
        String usuario = getScanner().nextLine();
        System.out.print("Digite a parecer: ");
        String parecer = getScanner().nextLine();

        //Instanciei um processo, normal...
        Processo p = new Processo(titulo, subtitulo, descricao, usuario, parecer);
        //Instanciando a classe DAO do processo, chamando o metodo add_processo e passando como parametro o processo
        //criado acima
        ProcessoDAO pdao = new ProcessoDAO();
        pdao.add_processo(p);

        menu();
    }

    public void listar_processo() {

        //Instanciando a classe DAO do processo
        ProcessoDAO pdao = new ProcessoDAO();

        System.out.println("\t\n--- Todos os processos ---\n");

        //Passando um for no arraylist que o metodo mostrar_processo retorna
        for (Processo p : pdao.mostrar_processo()) {
            System.out.println("ID do processo: " + p.getId_processo());
            System.out.println("Titulo: " + p.getTitulo());
            System.out.println("Subtitulo: " + p.getSubtitulo());
            System.out.println("Descricao: " + p.getDescricao());
            System.out.println("Usuario: " + p.getUsuario());
            System.out.println("Parecer: " + p.getParecer() + "\n");

        }
        menu();
    }

    public void excluir_processo() {

        ProcessoDAO pdao = new ProcessoDAO();

        System.out.print("\nDigite o número id para excluir: ");
        int id_processo = getScanner().nextInt();

        //Metodo que remove o processo pelo id
        pdao.delete_processo(id_processo);
        menu();

    }

    public void alterar_processo() {

        ProcessoDAO pdao = new ProcessoDAO();

        System.out.print("\nDigite o número do id para alterar: ");
        int id_processo = getScanner().nextInt();

        Processo p = pdao.achar_processo(id_processo);

        System.out.println("ID do processo: " + p.getId_processo());
        System.out.println("Titulo: " + p.getTitulo());
        System.out.println("Subtitulo: " + p.getSubtitulo());
        System.out.println("Descricao: " + p.getDescricao());
        System.out.println("Usuario: " + p.getUsuario());
        System.out.println("Parecer: " + p.getParecer() + "\n");

        System.out.println("Digite as novas informações: \n");
       System.out.print("\nDigite o titulo: ");
        String titulo = getScanner().nextLine();
        System.out.print("Digite o subtitulo: ");
        String subtitulo = getScanner().nextLine();
        System.out.print("Digite o descricao: ");
        String descricao = getScanner().nextLine();
        System.out.print("Digite o usuario: ");
        String usuario = getScanner().nextLine();
        System.out.print("Digite a parecer: ");
        String parecer = getScanner().nextLine();

        //Passando como parametro as informações e o numero do chassi do carro que foi digitado e posteriormente encontrado
        //cdao.alterar_usuario(u.getId(), nome, cpf, email, telefone, senha, cep, rua, complemento, numero, bairro, cidade, estado);
        pdao.alterar_processo(p.getId_processo(), titulo, subtitulo, descricao, usuario, parecer);
        menu();
    }

}
