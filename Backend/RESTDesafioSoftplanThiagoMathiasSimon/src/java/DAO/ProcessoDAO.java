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
import Model.Processo;

/**
 *
 * @author Thiago Mathias Simon
 */
public class ProcessoDAO {

    private Connection con = null;

    public ProcessoDAO() {
        con = BancoConnection.getConnection();
    }

    public boolean add_processo(Processo p) {
        String sql = "INSERT INTO processo (titulo, subtitulo, descricao, usuario, parecer) VALUES (?, ?, ?, ?, ?)";

        try {
            con = BancoConnection.getConnection();
            //O preparedStatement serve pra preparar a query que criei acima, subistituindo os '?' pelos valores que eu quero,
            //serve pra nao usar querys fixas e unicas, onde o '?' pode receber qualquer valor.
            //OBS: Só pode usar a notação '?' nos dados.
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, p.getTitulo());
            stmt.setString(2, p.getSubtitulo());
            stmt.setString(3, p.getDescricao());
            stmt.setString(4, p.getUsuario());
            stmt.setString(5, p.getParecer());

            //Query preparada com os devidos '?' substituidos pelos valores do obj processo, agora eu executo essa Query com o metodo execute().
            stmt.execute();

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

    public ArrayList<Processo> mostrar_processo() {

        //ArrayList que irei retornar
        ArrayList<Processo> retorno = new ArrayList<>();

        String sql = "SELECT * FROM processo";

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
                Processo p = new Processo();
                //Chamo o Setters padrão do usuario, e no parametro coloco o rs.getTipo("nome_da_coluna_igual_do_banco");              
                p.setId_processo(rs.getInt("id_processo"));
                p.setTitulo(rs.getString("titulo"));
                p.setSubtitulo(rs.getString("subtitulo"));
                p.setDescricao(rs.getString("descricao"));
                p.setUsuario(rs.getString("usuario"));
                p.setParecer(rs.getString("parecer"));

                //Adiciono no ArrayList.
                retorno.add(p);
                //Repete esse processo ate acabar o ResultSet, e no final o ARRAY vai ficar cheio com todos os processos.
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

    //Metodo que retorna o processo com o id passado pelo parametro.
    public Processo achar_processo(int id_processo) {

        Processo p = new Processo();
        String sql = "SELECT * FROM processo WHERE id_processo = ?";

        try {
            con = BancoConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            //Preparo sendo feito, digo que no 1º '?' ele vai ser trocado pelo id do processo que recebemos no parametro.
            stmt.setInt(1, id_processo);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                //Chamo o Setters padrão do processo, e no parâmetro coloco o rs.getTipo("nome_da_coluna_igual_do_banco");              
                p.setId_processo(rs.getInt("id_processo"));
                p.setTitulo(rs.getString("titulo"));
                p.setSubtitulo(rs.getString("subtitulo"));
                p.setDescricao(rs.getString("descricao"));
                p.setUsuario(rs.getString("usuario"));
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

    //Metodo que retorna o processo com o titulo passado pelo parametro.
    public Processo achar_processo_titulo(String titulo) {

        Processo p = new Processo();
        String sql = "SELECT * FROM processo WHERE titulo = ?";

        try {
            con = BancoConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            //Preparo sendo feito, digo que no 1º '?' ele vai ser trocado pelo titulo do processo que recebemos no parametro.
            stmt.setString(1, titulo);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                //Chamo o Setters padrão do usuario, e no parametro coloco o rs.getTipo("nome_da_coluna_igual_do_banco");              
                p.setId_processo(rs.getInt("id_processo"));
                p.setTitulo(rs.getString("titulo"));
                p.setSubtitulo(rs.getString("subtitulo"));
                p.setDescricao(rs.getString("descricao"));
                p.setUsuario(rs.getString("usuario"));
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

    //Metodo alterar processo, onde pega as novas informações do parametro e faz o UPDATE na tabela pelo id do processo.
    public void alterar_processo(int id_processo, String titulo, String subtitulo, String descricao, String usuario, String parecer) {

        String sql = "UPDATE usuario SET nome = ?, cpf = ?, email = ?, telefone = ?, senha = ?, nivel = ? WHERE id_usuario = ?";

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
