package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.Processo;

/**
 *
 * @author Thiago Mathias Simon
 */
public class ProcessoDAO {

    /*
    * A Classe DAO vai ser responsavel de fazer todas as operações CRUD desse objeto no banco,
    * O recomendado é ter uma Classe DAO pra cada entidade do seu projeto, UsuarioDAO, etc...
     */
    private Connection con = null;

    //Sempre que instacia ele vai pegar a conexao com banco, da classe BancoConnection.
    public ProcessoDAO() {
        con = BancoConnection.getConnection();
    }

    //Método que recebe um processo pra adicionar no banco!
    public boolean add_processo(Processo p) {
        //Aqui eu monto a query que vai adicionar o usuario, 
        //os nomes da tabela, e os campos tem que estar igual aos do banco.

        String sql = "INSERT INTO processo (titulo, subtitulo, descricao, usuarios, parecer) VALUES (?, ?, ?, ?, ?)";

        try {
            con = BancoConnection.getConnection();
            //O preparedStatement serve pra preparar a query que criei acima, subistituindo as '?' pelos valores que eu quero,
            //serve para não usar querys fixas e únicas, onde a '?' pode receber qualquer valor.
            //OBS: Só pode usar a notação '?' nos dados.
            PreparedStatement stmt = con.prepareStatement(sql);

            //Digo que na 1º '?' ela será trocada pelo tiítulo do processo, e assim por diante.
            stmt.setString(1, p.getTitulo());
            stmt.setString(2, p.getSubtitulo());
            stmt.setString(3, p.getDescricao());
            stmt.setString(4, p.getUsuario());
            stmt.setString(5, p.getParecer());

            //Query preparada com as devidas '?' substituidas pelos valores do obj processo, agora eu executo essa Query com o método execute().
            stmt.execute();

            //o método execute() é utilizado em situações em que a query pode retornar mais de um resultado 
            //(somente em situações muito particulares ele é utilizado, como em algumas execuções de stored procedures).
            System.out.println("Processo Adicionado no Banco de Dados\n");
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
    
    //Método que lista todos os processos e que retorna um arraylist de processos, necessitando fazer a listagem no Main.
    public ArrayList<Processo> mostrar_processo() {

        //ArrayList que irei retornar
        ArrayList<Processo> retorno = new ArrayList<>();
        
        //Query que irei lançar, retorna todos os processos
        String sql = "SELECT * FROM processo";

        try {
            con = BancoConnection.getConnection();
            //Passo a Query que vai ser preparada e executada.
            PreparedStatement stmt = con.prepareStatement(sql);

            //Executo essa Query e atribuo o resultado a rs. Onde irá guardar todo o resultado que for pego no banco, 
            //ele guarda o resultado de uma pesquisa numa estrutura de dados que pode ser percorrida. 
            ResultSet rs = stmt.executeQuery();
            // O método executeQuery() é usado para executar consultas apenas, e não deve ser usado 
            //para comandos como update, delete, create etc.

            //Percorro o resultado enquanto tiver proximo.
            while (rs.next()) {

                //Instacio um tipo processo pra criar o processo e adicionar no ArrayList que irei retornar.
                Processo p = new Processo();
                //Chamo os Setters padrões do usuario, e no parâmetro coloco o rs.getTipo("nome_da_coluna_igual_do_banco");              
                p.setId_processo(rs.getInt("id_processo"));
                p.setTitulo(rs.getString("titulo"));
                p.setSubtitulo(rs.getString("subtitulo"));
                p.setDescricao(rs.getString("descricao"));
                p.setUsuario(rs.getString("usuarios"));
                p.setParecer(rs.getString("parecer"));

                //Adiciono no ArrayList.
                retorno.add(p);
                //Repete esse processo até acabar o ResultSet, e no final o ARRAY vai ficar cheio com todos os processos.
            }

            rs.close();
            //Retorno o ARRAY com todos os processos.
            return retorno;

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            BancoConnection.closeConnection(con);
        }
        return null;
    }

        //Método que deleta o processo pelo número do id passado por parâmetro.
    public boolean delete_processo(int id_processo) {

        String sql1 = "DELETE FROM processo WHERE id_processo = ?";

        try {
            con = BancoConnection.getConnection();
            //Removendo todas os processos
            PreparedStatement stmt1 = con.prepareStatement(sql1);
            //Preparo sendo feito, digo que na 1º '?' ela vai ser trocado pelo id do processo que recebemos no parâmetro.
            stmt1.setInt(1, id_processo);
            stmt1.executeUpdate();
            System.out.println("\nProcesso Deletado do Banco de Dados\n");
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
            return false;
        } finally {
            BancoConnection.closeConnection(con);
        }

    }

    //Método que retorna o processo com o id passado por parâmetro.
    public Processo achar_processo(int id_processo) {

        Processo p = new Processo();
        String sql = "SELECT * FROM processo WHERE id_processo = ?";

        try {
            con = BancoConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            //Preparo sendo feito, digo que na 1º '?' ela vai ser trocado pelo id do processo que recebemos no parâmetro.
            stmt.setInt(1, id_processo);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                //Chamo o Setters padrão do processo, e no parâmetro coloco o rs.getTipo("nome_da_coluna_igual_do_banco");              
                p.setId_processo(rs.getInt("id_processo"));
                p.setTitulo(rs.getString("titulo"));
                p.setSubtitulo(rs.getString("subtitulo"));
                p.setDescricao(rs.getString("descricao"));
                p.setUsuario(rs.getString("usuarios"));
                p.setParecer(rs.getString("parecer"));

            }
            return p;

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
            return null;
        } finally {
            BancoConnection.closeConnection(con);
        }
    }

    //Método que retorna o processo com o titulo passado por parâmetro.
    public Processo achar_processo_titulo(String titulo) {

        Processo p = new Processo();
        String sql = "SELECT * FROM processo WHERE titulo = ?";

        try {
            con = BancoConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            //Preparo sendo feito, digo que na 1º '?' ela vai ser trocado pelo id do processo que recebemos no parâmetro.
            stmt.setString(1, titulo);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                //Chamo o Setters padrão do processo, e no parâmetro coloco o rs.getTipo("nome_da_coluna_igual_do_banco");              
                p.setId_processo(rs.getInt("id_processo"));
                p.setTitulo(rs.getString("titulo"));
                p.setSubtitulo(rs.getString("subtitulo"));
                p.setDescricao(rs.getString("descricao"));
                p.setUsuario(rs.getString("usuarios"));
                p.setParecer(rs.getString("parecer"));

            }
            return p;

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
            return null;
        } finally {
            BancoConnection.closeConnection(con);
        }
    }

    //Método alterar processo, onde pega as novas informações do parâmetro e faz o UPDATE na tabela pelo id do processo.
    public void alterar_processo(int id_processo, String titulo, String subtitulo, String descricao, String usuario, String parecer) {

        String sql = "UPDATE processo SET titulo = ?, subtitulo = ?, descricao = ?, usuarios = ?, parecer = ? WHERE id_processo = ?";

        try {
            con = BancoConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, titulo);
            stmt.setString(2, subtitulo);
            stmt.setString(3, descricao);
            stmt.setString(4, usuario);
            stmt.setString(5, parecer);
            stmt.setInt(6, id_processo);

            stmt.executeUpdate();

            System.out.println("\nProcesso Editado no Banco de Dados\n");
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            BancoConnection.closeConnection(con);
        }
    }

}
