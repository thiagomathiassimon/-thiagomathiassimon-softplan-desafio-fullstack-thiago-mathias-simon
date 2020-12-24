import React from 'react';
import { Link } from 'react-router-dom'

export default class ListarProcessos extends React.Component {

  handleExcluir(processos) {
    this.props.excluir(processos);
  }

  handleEditar(processos) {
    this.props.editar(processos);
  }

  render() {

    const processosFiltrados = this.props.processo.filter(processos => {
      console.log(processos)
      console.log(processos.parecer === 'Pendente')
      return processos.parecer === 'Pendente'
    })

    return (
      <>
        <section class="form-section">
          <h1>VISUALIZAR PROCESSOS PENDENTES</h1>
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
                      <th>Parecer</th>
                      <th>Ações</th>
                    </tr>
                  </thead>
                  <tbody>
                    {processosFiltrados.map(processos => (
                      <tr key={processos.id_processo}>
                        {console.log(processos.id_processo)}
                        <td>
                          {processos.titulo}
                        </td>
                        <td>
                          {processos.subtitulo}
                        </td>
                        <td>
                          {processos.descricao}
                        </td>
                        <td>
                          {processos.usuario}
                        </td>
                        <td>
                          {processos.parecer}
                        </td>
                        <td>
                          <td><button className='btn-editar' onClick={(e) => {
                            e.preventDefault();
                            this.handleEditar(processos)
                          }}>Editar</button></td>
                          <td><button className="btn-excluir" button onClick={() => this.handleExcluir(processos)}>Excluir</button></td>
                        </td>
                      </tr>
                    )
                    )}
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