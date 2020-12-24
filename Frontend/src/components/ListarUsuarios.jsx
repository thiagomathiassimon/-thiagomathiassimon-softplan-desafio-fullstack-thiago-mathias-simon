import React from 'react';
import { Link } from 'react-router-dom'

export default class ListarUsuarios extends React.Component {

  handleExcluir(usuarios) {
    this.props.excluir(usuarios);
  }

  handleEditar(usuarios) {
    this.props.editar(usuarios);
  }

  render() {
    return (
      <>
        <section class="form-section">
          <h1>VISUALIZAR USUÁRIOS</h1>
          <div class="form-wrapper">
            <form action="">
              <div class="input-block">
                <table>
                  <thead>
                    <tr>
                      <th>Nome</th>
                      <th>CPF</th>
                      <th>Nível</th>
                      <th>Email</th>
                      <th>Telefone</th>
                      <th>Senha</th>
                      <th>Ações</th>
                    </tr>
                  </thead>
                  <tbody>
                    {this.props.usuario.map(usuarios => (
                      <tr key={usuarios.id_usuario}>
                        <td>
                          {usuarios.nome}
                        </td>
                        <td>
                          {usuarios.cpf}
                        </td>
                        <td>
                          {usuarios.nivel}
                        </td>
                        <td>
                          {usuarios.email}
                        </td>
                        <td>
                          {usuarios.telefone}
                        </td>
                        <td>
                          {usuarios.senha}
                        </td>
                        <td>
                          <td>
                            <button type="submit" class="btn-editar" onClick={(e) => {
                              e.preventDefault();
                              this.handleEditar(usuarios)
                            }} >Editar
                            </button>
                          </td>
                          <td>
                            <button type="submit" class="btn-excluir" onClick={() => this.handleExcluir(usuarios)} >Excluir
                            </button>
                          </td>
                        </td>
                      </tr>))}
                  </tbody>
                </table>
              </div>
            </form>
            <Link to='/usuarios'>
              <span>Não era o que queria? Retorne às opções!</span>
            </Link>
          </div>
        </section>
      </>
    );
  }
}