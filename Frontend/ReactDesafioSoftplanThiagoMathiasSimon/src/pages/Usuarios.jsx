import React from 'react';
import { Link } from 'react-router-dom'

class Usuarios extends React.Component {
  render() {
    return (
      <>
        <section class="form-section">
          <h1>USUÁRIOS</h1>
          <div class="form-wrapper">
            <form>
              <div class='input-block'>
                <h2>O que deseja fazer?</h2>
              </div>
              <div class="input-block">
                <Link to='/incluirusuarios'>
                  <button type="submit" class="btn-incluir">Incluir Usuários</button>
                </Link>
              </div>
              <div class="input-block">
                <Link to='/visualizarusuarios'>
                  <button type="submit" class="btn-visualizar">Visualizar Usuários</button>
                </Link>
              </div>
            </form>
            <Link to='/loginadministrador'>
              <span>Voltar ao Login?</span>
            </Link>
          </div>
        </section>
      </>
    );
  }
}

export default Usuarios;