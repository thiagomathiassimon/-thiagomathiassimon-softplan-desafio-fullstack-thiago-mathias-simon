package Controller;

import java.util.List;
import Model.Processo;
import DAO.ProcessoDAO;

/**
 *
 * @author Thiago Mathias Simon
 */
public class ProcessoController {
    
    public boolean addProcesso(Processo obj) {
        ProcessoDAO pdao = new ProcessoDAO();
        if (pdao.add_processo(obj)) {
            return true;
        } else {
            return false;
        }
    }

    public List<Processo> getProcesso() {
        ProcessoDAO pdao = new ProcessoDAO();
        return pdao.mostrar_processo();
    }

    public Processo getProcesso(int id) throws ClassNotFoundException {
        boolean Achou = false;
        ProcessoDAO pdao = new ProcessoDAO();
        Processo p = pdao.achar_processo(id);

        return p;
    }

    public Processo getProcessoEmail(String titulo) throws ClassNotFoundException {
        boolean Achou = false;

        ProcessoDAO pdao = new ProcessoDAO();
        Processo p = pdao.achar_processo_titulo(titulo);

        return p;
    }

    public boolean update(int id, Processo obj) {
        boolean Achou = false;

        ProcessoDAO pdao = new ProcessoDAO();
        Processo p = pdao.achar_processo(id);
        if (p != null) {
            pdao.alterar_processo(p.getId_processo(),
                    obj.getTitulo(),
                    obj.getSubtitulo(),
                    obj.getDescricao(),
                    obj.getUsuario(),
                    obj.getParecer());
            
            Achou = true;
        } else {
            return false;
        }
        return Achou;
    }

    public boolean delete(int id) {
        ProcessoDAO pdao = new ProcessoDAO();

        if (pdao.delete_processo(id)) {
            return true;
        } else {
            return false;
        }
    }
    
}
