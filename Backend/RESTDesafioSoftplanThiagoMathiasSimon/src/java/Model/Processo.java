/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Thiago Mathias Simon
 */
public class Processo {

    private int id_processo;
    private String titulo;
    private String subtitulo;
    private String descricao;
    private String usuario;
    private String parecer;

    public Processo(int id_processo, String titulo, String subtitulo, String descricao, String usuario, String parecer) {
        this.id_processo = id_processo;
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.descricao = descricao;
        this.usuario = usuario;
        this.parecer = parecer;
    }

    public Processo(int id_processo, String titulo, String subtitulo, String descricao, String usuario) {
        this.id_processo = id_processo;
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.descricao = descricao;
        this.usuario = usuario;
    }

    public Processo() {
    }

    public int getId_processo() {
        return id_processo;
    }

    public void setId_processo(int id_processo) {
        this.id_processo = id_processo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getParecer() {
        return parecer;
    }

    public void setParecer(String parecer) {
        this.parecer = parecer;
    }

    
    @Override
    public String toString() {
        return "Processo{" + "titulo=" + titulo + ", subtitulo=" + subtitulo + ", descricao=" + descricao
                + ", parecer=" + parecer + '}';
    }
}
