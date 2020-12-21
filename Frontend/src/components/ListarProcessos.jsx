import React from 'react';
import { Link } from 'react-router-dom'

export default class ListarProcessos extends React.Component {
  render() {
    return (
      <>
        <section class="form-section">
          <h1>VISUALIZAR PROCESSOS</h1>
          <div class="form-wrapper">
            <form action="">
              <div class="input-block">
                <table>
                  <thead>
                    <tr>
                      <th>Título</th>
                      <th>Subtítulo</th>
                      <th>Descrição</th>
                      <th>Usuários</th>
                      <th>Status</th>
                      <th>Ações</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td>
                        Processo contra o desmatamento
                       </td>
                      <td>
                        Processo civil
                      </td>
                      <td>
                        Justiça
                        </td>
                      <td>
                        Cidadão
                       </td>
                      <td>
                        Ativo
                        </td>
                      <td>
                        {this.props.children}
                      </td>
                    </tr>
                  </tbody>
                </table>
              </div>
            </form>
            <Link to={this.props.toPagina}>
              <span>Não era o que queria? Retorne às opções!</span>
            </Link>
          </div>
        </section>
      </>
    )
  }
}