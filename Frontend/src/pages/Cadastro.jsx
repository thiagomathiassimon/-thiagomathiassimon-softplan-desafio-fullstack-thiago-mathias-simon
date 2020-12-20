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
              <table>
                <thead />
                <tbody>
                  <tr>
                    <td>
                      <div class="input-block">
                        <label for="cadastro-nome">Nome</label>
                        <input type="text" id="cadastro-nome" />
                      </div>
                    </td>
                    <td>
                      <div class="input-block">
                        <label for="cadastro-dtNasc">Data de Nascimento</label>
                        <input type="date" id="cadastro-dtNasc" />
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <td>
                      <div class="input-block">
                        <label for="login-cpf">CPF</label>
                        <input type="number" id="cadastro-cpf" />
                      </div>
                    </td>
                    <td>
                      <div class="input-block">
                        <label for="login-email">Nível</label>
                        <select type="text" id="cadastro-nivel">
                          <option value="selecionar">Selecione uma opção</option>
                          <option value="administrador(a)">Administrador(a)</option>
                          <option value="usario(a)-triador(a)">Usuário(a)-triador(a)</option>
                          <option value="usuario(a)-finalizador(a)">Usuário(a)-finalizador(a)</option>
                        </select>
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <td>
                      <div class="input-block">
                        <label for="login-email">E-mail</label>
                        <input type="email" id="cadastro-email" />
                      </div>
                    </td>
                    <td>
                      <div class="input-block">
                        <label for="cadastro-telefone">Telefone</label>
                        <input type="number" id="cadastro-telefone" />
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <td>
                      <div class="input-block">
                        <label for="cadastro-password">Senha</label>
                        <input type="password" id="cadastro-password" />
                      </div>
                    </td>
                    <td>
                      <div class="input-block">
                        <label for="cadastro-confirmPassword">Confirme sua Senha</label>
                        <input type="password" id="cadastro-confirmPassword" />
                      </div>
                    </td>
                  </tr>
                </tbody>
              </table>
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