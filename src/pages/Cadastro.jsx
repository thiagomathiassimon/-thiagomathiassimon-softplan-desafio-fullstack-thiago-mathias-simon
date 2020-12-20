import React from 'react';
import '../assets/css/Page.css';
import { Link } from 'react-router-dom';


class Cadastro extends React.Component {
  render() {
    return (
      <>
        <section class="form-section">
          <h1>CADASTRO</h1>
          <div class="form-wrapper">
            <form action="">
              <div class="input-block">
                <label for="cadastro-nome">Nome</label>
                <input type="text" id="cadastro-nome" />
              </div>
              <div class="input-block">
                <label for="cadastro-dtNasc">Data de Nascimento</label>
                <input type="date" id="cadastro-dtNasc" />
              </div>
              <div class="input-block">
                <label for="login-email">E-mail</label>
                <input type="email" id="cadastro-nome" />
              </div>
              <div class="input-block">
                <label for="cadastro-password">Senha</label>
                <input type="password" id="cadastro-password" />
              </div>
              <div class="input-block">
                <label for="cadastro-confirmPassword">Confirme sua Senha</label>
                <input type="password" id="cadastro-confirmPassword" />
              </div>
              <button type="submit" class="btn-cadastrar">Cadastrar</button>
            </form>
            <Link to='/login'>
              <span>Já possui conta e quer voltar ao Login?</span>
            </Link>
          </div>
        </section>
      </>
    )
  }
}

export default Cadastro;