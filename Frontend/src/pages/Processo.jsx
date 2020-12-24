import React from 'react';
import { Link } from 'react-router-dom'
import ProcessoAPI from '../services/ProcessoAPI';

class Processo extends React.Component {
  render() {
    return (
      <>
        <section class="form-section">
          <h1>PROCESSO</h1>
          <div class="form-wrapper">
            <form>
              <div class='input-block'>
                <h2>O que deseja fazer?</h2>
              </div>
              <div class="input-block">
                <Link to='/incluirprocesso'>
                  <button type="submit" class="btn-incluir" onClick={ProcessoAPI.buscarProcessos}>Incluir Processo</button>
                </Link>
              </div>
              <div class="input-block">
                <Link to='/visualizarprocessos'>
                  <button type="submit" class="btn-visualizar">Visualizar Processos</button>
                </Link>
              </div>
            </form>
            <Link to='/logintriador'>
              <span>Voltar ao Login?</span>
            </Link>
          </div>
        </section>
      </>
    );
  }
}

export default Processo;