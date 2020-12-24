package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.Usuario;

/**
 *
 * @author Thiago Mathias Simon
 */
public class UsuarioDAO {

    /*
    * A Classe DAO vai ser responsavel de fazer todas as operações CRUD desse objeto no banco,
    * O recomendado é ter uma Classe DAO pra cada entidade do seu projeto, UsuarioDAO, etc...
     */
    private Connection con = null;

    //Sempre que instacia ele vai pegar a conexao com banco, da classe BancoConnection.
    public UsuarioDAO() {
        con = BancoConnection.getConnection();
    }

    //Método que recebe um usuário pra adicionar no banco!
    public boolean add_usuario(Usuario u) {
        //Aqui eu monto a query que vai adicionar o usuario, 
        //os nomes da tabela, e os campos tem que estar igual aos do banco.

        String sql = "INSERT INTO usuario (nome, cpf, email, telefone, senha, nivel) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            con = BancoConnection.getConnection();
            //O preparedStatement serve pra preparar a query que criei acima, subistituindo as '?' pelos valores que eu quero,
            //serve para não usar querys fixas e únicas, onde a '?' pode receber qualquer valor.
            //OBS: Só pode usar a notação '?' nos dados.
            PreparedStatement stmt = con.prepareStatement(sql);

            //Digo que na 1º '?' ela será trocada pelo nome do usuario, e assim por diante.
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getCpf());
            stmt.setString(3, u.getEmail());
            stmt.setString(4, u.getTelefone());
            stmt.setString(5, u.getSenha());
            stmt.setString(6, u.getNivel());

            //Query preparada com as devidas '?' substituidas pelos valores do obj usuário, agora eu executo essa Query com o método execute().
            stmt.execute();
            
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

    //Método que lista todos os usuario e que retorna um arraylist de usários, necessitando fazer a listagem no Main.
    public ArrayList<Usuario> mostrar_usuarios() {

        //ArrayList que irei retornar
        ArrayList<Usuario> retorno = new ArrayList<>();

        //Query que irei lançar, retorna todos os usuários 
        String sql = "SELECT * FROM usuario";

        try {
            con = BancoConnection.getConnection();
            //Passo a Query que vai ser preparada e executada.
            PreparedStatement stmt = con.prepareStatement(sql);

            //Executo essa Query e atribuo o resultado a rs. Onde ira guardar todo resultado que for pego no banco, 
            //ele guarda o resultado de uma pesquisa numa estrutura de dados que pode ser percorrida. 
            ResultSet rs = stmt.executeQuery();
            // O método executeQuery() é usado para executar consultas apenas, e não deve ser usado 
            //para comandos como update, delete, create etc.

            //Percorro o resultado enquanto tiver proximo.
            while (rs.next()) {

                //Instacio um tipo usuario pra criar o usuario e adicionar no ArrayList que irei retornar.
                Usuario u = new Usuario();
                //Chamo os Setters padrões do usuario, e no parâmetro coloco o rs.getTipo("nome_da_coluna_igual_do_banco");              
                u.setId_usuario(rs.getInt("id_usuario"));
                u.setNome(rs.getString("nome"));
                u.setCpf(rs.getString("cpf"));
                u.setEmail(rs.getString("email"));
                u.setTelefone(rs.getString("telefone"));
                u.setSenha(rs.getString("senha"));
                u.setNivel(rs.getString("nivel"));

                //Adiciono no ArrayList.
                retorno.add(u);
                //Repete esse processo atá acabar o ResultSet, e no final o ARRAY vai ficar cheio com todos os usuários.
            }

            rs.close();
            //Retorno o ARRAY com todos os usuários.
            return retorno;

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            BancoConnection.closeConnection(con);
        }
        return null;
    }

    //Método que deleta o usuário pelo número do id passado por parâmetro.
    public boolean delete_usuario(int id_usuario) {

        String sql1 = "DELETE FROM usuario WHERE id_usuario = ?";

        try {
            con = BancoConnection.getConnection();
            //Removendo todos os usuários
            PreparedStatement stmt1 = con.prepareStatement(sql1);
            //Preparo sendo feito, digo que na 1º '?' ela vai ser trocado pelo id do usuário que recebemos no parâmetro.
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

    //Método que retorna o usuário com o id passado por parâmetro.
    public Usuario achar_usuario(int id_usuario) {

        Usuario u = new Usuario();
        String sql = "SELECT * FROM usuario WHERE id_usuario = ?";

        try {
            con = BancoConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            //Preparo sendo feito, digo que na 1º '?' ela vai ser trocado pelo id do processo que recebemos no parâmetro.
            stmt.setInt(1, id_usuario);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                //Chamo o Setters padrão do usuário, e no parâmetro coloco o rs.getTipo("nome_da_coluna_igual_do_banco");              
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

    //Método que retorna o usuário com o titulo passado por parâmetro.
    public Usuario achar_usuario_email(String email) {

        Usuario u = new Usuario();
        String sql = "SELECT * FROM usuario WHERE email = ?";

        try {
            con = BancoConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            //Preparo sendo feito, digo que na 1º '?' ela vai ser trocado pelo id do usuário que recebemos no parâmetro.
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                //Chamo o Setters padrão do usuário, e no parâmetro coloco o rs.getTipo("nome_da_coluna_igual_do_banco");              
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

    //Método alterar usuário, onde pega as novas informações do parâmetro e faz o UPDATE na tabela pelo id do processo.
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

    //Método que valida o acesso do usuário,
    //para isso, compara a existência do e-mail e da senha informados pelo usuário
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
