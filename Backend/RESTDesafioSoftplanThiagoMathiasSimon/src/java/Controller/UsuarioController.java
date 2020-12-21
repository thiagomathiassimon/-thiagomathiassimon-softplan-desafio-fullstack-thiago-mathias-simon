/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.ArrayList;
import java.util.List;
import Model.Usuario;
import DAO.UsuarioDAO;

/**
 *
 * @author Thiago Mathias Simon
 */
public class UsuarioController {

    public boolean acessoUsuario(String email, String senha) {
        UsuarioDAO udao = new UsuarioDAO();
        if (udao.acesso_usuario(email, senha)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean addUsuario(Usuario obj) {
        UsuarioDAO udao = new UsuarioDAO();
        if (udao.add_usuario(obj)) {
            return true;
        } else {
            return false;
        }
    }

    public List<Usuario> getUsuario() {
        UsuarioDAO udao = new UsuarioDAO();
        return udao.mostrar_usuarios();
    }

    public Usuario getUsuario(int id) throws ClassNotFoundException {
        boolean Achou = false;

        UsuarioDAO udao = new UsuarioDAO();
        Usuario u = udao.achar_usuario(id);

        return u;
    }

    public Usuario getUsuarioEmail(String email) throws ClassNotFoundException {
        boolean Achou = false;

        UsuarioDAO udao = new UsuarioDAO();
        Usuario u = udao.achar_usuario_email(email);

        return u;
    }

    public boolean update(int id, Usuario obj) {
        boolean Achou = false;

        UsuarioDAO udao = new UsuarioDAO();
        Usuario u = udao.achar_usuario(id);
        if (u != null) {
            udao.alterar_usuario(u.getId_usuario(),
                    obj.getNome(),
                    obj.getCpf(),
                    obj.getEmail(),
                    obj.getTelefone(),
                    obj.getSenha(),
                    obj.getNivel());
            Achou = true;
        } else {
            return false;
        }
        return Achou;
    }

    public boolean delete(int id) {
        UsuarioDAO udao = new UsuarioDAO();

        if (udao.delete_usuario(id)) {
            return true;
        } else {
            return false;
        }
    }

}
