import React from 'react';
import '../assets/css/Page.css';
import { Link } from 'react-router-dom';

export default class FormularioLogin extends React.Component {
  render() {
    return (
      <>
        <section class="form-section">
          <h1>LOGIN</h1>
          <div class="form-wrapper">
            <form action="">
              <div class="input-block">
                <label for="login-email">E-mail</label>
                <input type="email" id="login-email" />
              </div>
              <div class="input-block">
                <label for="login-password">Senha</label>
                <input type="password" id="login-password" />
              </div>
              <Link to={this.props.to}>
                <button type="submit" class="btn-login">Login</button>
              </Link>
            </form>
            <Link to={this.props.toCadastro}>
              <span>Ainda não possue conta? Faça-a aqui!</span>
            </Link>
            <br />
            <br />
            <Link to='/paginainicial'>
              <span>Escolheu a opção errada e quer voltar à Página Inicial?</span>
            </Link>
            <br />
          </div>
        </section>
      </>
    )
  }
}