import React from 'react';
import { Link } from 'react-router-dom'


class IncluirProcesso extends React.Component {
  render() {
    return (
      <>
        <section class="form-section">
          <h1>VIZUALIZAR PROCESSOS</h1>
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
                        <button type="submit" class="btn-editar">
                          Editar
                        </button>
                        <label> </label>
                        <button type="submit" class="btn-excluir">
                          Excluir
                        </button>
                      </td>
                    </tr>
                  </tbody>
                </table>
              </div>
              <button type="submit" class="btn-cadastrar">Cadastrar</button>
            </form>
            <Link to='/'>
              <span>Não era o que queria? Retorne às opções!</span>
            </Link>
          </div>
        </section>
      </>
    );
  }
}
export default IncluirProcesso;