import React from 'react';
import { Link } from 'react-router-dom'


class PaginaInicial extends React.Component {
  render() {
    return (
      <>
        <section class="form-section">
          <h1>SISTEMA DE GERENCIAMENTO <br /> DE PROCESSOS</h1>
          <div class="form-wrapper">
            <form action="">
              <div class='input-block'>
                <h2>Quem é você?</h2>
              </div>
              <div class="input-block">
                <Link to='/loginadministrador'>
                  <button type="submit" class="btn-incluir">Administrador(a)</button>
                </Link>
              </div>
              <div class="input-block">
                <Link to='/visualizarprocessos'>
                  <button type="submit" class="btn-visualizar">Usuário(a)-triador(a)</button>
                </Link>
              </div>
              <div class="input-block">
                <Link to='/visualizarprocessos'>
                  <button type="submit" class="btn-visualizar">Usuário(a)-finalizador(a)</button>
                </Link>
              </div>
            </form>
          </div>
        </section>
      </>
    );
  }
}
export default PaginaInicial;