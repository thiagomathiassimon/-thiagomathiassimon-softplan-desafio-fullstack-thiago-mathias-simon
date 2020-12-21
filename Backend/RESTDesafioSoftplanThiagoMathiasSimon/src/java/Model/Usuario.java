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
public class Usuario {

    private int id_usuario;
    private String nome;
    private String cpf;
    private String email;
    private String email1;
    private String telefone;
    private String senha;
    private String nivel;

    public Usuario() {
    }

    public Usuario(String nome, String cpf, String email, String telefone, String senha, String nivel) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
        this.nivel = nivel;

    }

    public Usuario(String nome, String cpf, String email, String email1, String telefone, String senha, String nivel) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.email1 = email1;
        this.telefone = telefone;
        this.senha = senha;
        this.nivel = nivel;

    }

    public Usuario(String email, String senha) {

    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNivel() {
        return nivel;
    }
    
    public void setNivel(String nivel){
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nome=" + nome + ", cpf=" + cpf + ", email=" + email
                + ", email1=" + email1 + ", telefone=" + telefone + ", senha=" + senha +", nivel="+nivel+ '}';
    }

}
