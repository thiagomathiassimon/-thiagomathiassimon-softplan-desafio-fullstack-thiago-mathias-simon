/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.Usuario;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author Thiago Mathias Simon
 */
public class UsuarioDAO {

    /*
    * A Classe DAO vai ser responsavel de fazer todas as operações CRUD desse objeto no banco,
    * O recomendado e ter um Classe DAO pra cada entidade do seu projeto, UsuarioDAO, etc...
     */
    private Connection con = null;

    //Sempre que instacia ele vai pegar a conexao com banco, da classe que criamos BancoConnection.
    public UsuarioDAO() {
        con = BancoConnection.getConnection();
    }

    //Metodo que recebe um usuario pra adicionar no banco!
    public boolean add_usuario(Usuario u) {
        //Aqui eu monto a query que vai adicionar o usuario, tem que saber o basico de QUERYS SQL, 
        //os nomes da tabela, e os campos tem que estar igual a do banco.

        String sql = "INSERT INTO usuario (nome, cpf, email, telefone, senha, nivel) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            con = BancoConnection.getConnection();
            //O preparedStatement serve pra preparar a query que criei acima, subistituindo os '?' pelos valores que eu quero,
            //serve pra nao usar querys fixas e unicas, onde o '?' pode receber qualquer valor.
            //OBS: Só pode usar a notação '?' nos dados.
            PreparedStatement stmt = con.prepareStatement(sql);

            //Digo que no 2º '?' ele vai ser trocado pelo nome do usuario, e assim por diante.
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getCpf());
            stmt.setString(3, u.getEmail());
            stmt.setString(4, u.getTelefone());
            stmt.setString(5, u.getSenha());
            stmt.setString(6, u.getNivel());
            //   stmt.setInt(6, u.getId_endereco());
            //    stmt.setInt(7, u.getId_avaliacao());

            //Query preparada com os devidos '?' substituidos pelos valores do obj usuario, agora eu executo essa Query com o metodo execute().
            stmt.execute();

            // Recupera a id
            /*ResultSet rs = stmt.getGeneratedKeys();
            int id_endereco = 0;
            if (rs.next()) {
                id_endereco = rs.getInt(1);
            }  */
            //Método insert Endereço
            // add_endereco();
            //o método execute() é utilizado em situações em que a query pode retornar mais de um resultado 
            //(somente em situações muito particulares ele é utilizado, como em algumas execuções de stored procedures).
            System.out.println("\nUsuario Adicionado no Banco de Dados\n");
            return true;
            //Pronto aqui ele já inseriu no banco.

            // Recupera a id
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
            return false;
        } finally {
            BancoConnection.closeConnection(con);
        }

    }

    //Metodo que lista todos os usuario que retorna um arraylist de usuario, necessitando fazer a listagem no Main.
    public ArrayList<Usuario> mostrar_usuarios() {

        //ArrayList que irei retornar
        ArrayList<Usuario> retorno = new ArrayList<>();

        //Query que irei lançar, retorna todos os animais (incluido os já vendidos).
        String sql = "SELECT * FROM usuario";

        try {
            con = BancoConnection.getConnection();
            //Passo a Query que vai ser preparada e executada.
            PreparedStatement stmt = con.prepareStatement(sql);

            //Executo essa Query e atribuo o resultado a rs. Onde ira guardar todo resultado que for pego no banco, 
            //ele guarda o resultado de uma pesquisa numa estrutura de dados que pode ser percorrida. 
            ResultSet rs = stmt.executeQuery();
            // O método executeQuery() é usado para executar consultas apenas, e não deve ser usado 
            //para comandos como update, delete, create, etc.

            //Percorro o resultado enquanto tiver proximo.
            while (rs.next()) {

                //Instacio um tipo usuario pra criar o usuario e adicionar no ArrayList que irei retornar.
                Usuario u = new Usuario();
                //Chamo o Setters padrão do usuario, e no parametro coloco o rs.getTipo("nome_da_coluna_igual_do_banco");              
                u.setId_usuario(rs.getInt("id_usuario"));
                u.setNome(rs.getString("nome"));
                u.setCpf(rs.getString("cpf"));
                u.setEmail(rs.getString("email"));
                u.setTelefone(rs.getString("telefone"));
                u.setSenha(rs.getString("senha"));
                u.setNivel(rs.getString("nivel"));

                //Adiciono no ArrayList.
                retorno.add(u);
                //Repete esse processo ate acabar o ResultSet, e no final o ARRAY vai ficar cheio com todos os animais.
            }

            rs.close();
            //Retorno o ARRAY com todos os animais.
            return retorno;

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            BancoConnection.closeConnection(con);
        }
        return null;
    }

    //Metodo que deleta o usuario pelo numero do chassi passado pelo parametro.
    public boolean delete_usuario(int id_usuario) {

        String sql1 = "DELETE FROM usuario WHERE id_usuario = ?";

        try {
            con = BancoConnection.getConnection();
            //Removendo todas as vendas do usuario
            PreparedStatement stmt1 = con.prepareStatement(sql1);
            //Preparo sendo feito, digo que no 1º '?' ele vai ser trocado pelo chassi do usuario que recebemos no parametro.
            stmt1.setInt(1, id_usuario);
            stmt1.executeUpdate();
            System.out.println("\nUsuario Deletado do Banco de Dados\n");
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
            return false;
        } finally {
            BancoConnection.closeConnection(con);
        }

    }

    //Metodo que retorna o usuario com o id passado pelo parametro.
    public Usuario achar_usuario(int id_usuario) {

        Usuario u = new Usuario();
        String sql = "SELECT * FROM usuario WHERE id_usuario = ?";

        try {
            con = BancoConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            //Preparo sendo feito, digo que no 1º '?' ele vai ser trocado pelo chassi do usuario que recebemos no parametro.
            stmt.setInt(1, id_usuario);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                //Chamo o Setters padrão do usuario, e no parametro coloco o rs.getTipo("nome_da_coluna_igual_do_banco");              
                u.setId_usuario(rs.getInt("id_usuario"));
                u.setNome(rs.getString("nome"));
                u.setCpf(rs.getString("cpf"));
                u.setEmail(rs.getString("email"));
                u.setTelefone(rs.getString("telefone"));
                u.setSenha(rs.getString("senha"));
                u.setNivel(rs.getString("nivel"));
                //    u.setId_endereco(rs.getInt("id_endereco"));
                //    u.setId_avaliacao(rs.getInt("id_avaliacao"));

            }
            return u;

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
            return null;
        } finally {
            BancoConnection.closeConnection(con);
        }
    }

    //Metodo que retorna o usuario com o email passado pelo parametro.
    public Usuario achar_usuario_email(String email) {

        Usuario u = new Usuario();
        String sql = "SELECT * FROM usuario WHERE email = ?";

        try {
            con = BancoConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            //Preparo sendo feito, digo que no 1º '?' ele vai ser trocado pelo chassi do usuario que recebemos no parametro.
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                //Chamo o Setters padrão do usuario, e no parametro coloco o rs.getTipo("nome_da_coluna_igual_do_banco");              
                u.setId_usuario(rs.getInt("id_usuario"));
                u.setNome(rs.getString("nome"));
                u.setCpf(rs.getString("cpf"));
                u.setEmail(rs.getString("email"));
                u.setTelefone(rs.getString("telefone"));
                u.setSenha(rs.getString("senha"));
                u.setNivel(rs.getString("nivel"));

            }
            return u;

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
            return null;
        } finally {
            BancoConnection.closeConnection(con);
        }
    }

    //Metodo alterar usuario, onde pega as novas informações do parametro e faz o UPDATE na tabela pelo chassi do usuario.
    public void alterar_usuario(int id_usuario, String nome, String cpf, String email, String telefone, String senha, String nivel) {

        String sql = "UPDATE usuario SET nome = ?, cpf = ?, email = ?, telefone = ?, senha = ?, nivel = ? WHERE id_usuario = ?";

        try {
            con = BancoConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, cpf);
            stmt.setString(3, email);
            stmt.setString(4, telefone);
            stmt.setString(5, senha);
            stmt.setString(6, nivel);
            stmt.setInt(7, id_usuario);

            stmt.executeUpdate();

            System.out.println("\nUsuario Editado no Banco de Dados\n");
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            BancoConnection.closeConnection(con);
        }
    }

    //Metodo Consultar
    public boolean acesso_usuario(String email, String senha) {

        String sql = "SELECT id_usuario, nome, cpf, email, telefone, senha, nivel FROM usuario WHERE email=? and senha=?";

        try {
            con = BancoConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, email);
            stmt.setString(2, senha);

            ResultSet rs;
            rs = stmt.executeQuery();

            if (rs.next()) {
                String user = rs.getString("email");
                String pass = rs.getString("senha");
                // System.out.println("\nAcesso permitido\n");
                return true;

            } else {
                System.out.println("\nAcesso Negado\n");
                rs.close();
                return false;

            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
        return false;

    }
}
