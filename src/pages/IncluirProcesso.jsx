import React from 'react';
import { Link } from 'react-router-dom'



class IncluirProcesso extends React.Component {
  render() {
    return (
      <>
        <section class="form-section">
          <h1>INCLUIR PROCESSO</h1>
          <div class="form-wrapper">
            <form action="">
              <div class="input-block">
                <label for="incluirProcesso-titulo">Título</label>
                <input type="text" id="cadastro-nome" />
              </div>
              <div class="input-block">
                <label for="incluirProcesso-subtitulo">Subtítulo</label>
                <input type="text" id="incluirProcesso-subtitulo" />
              </div>
              <div class="input-block">
                <label for="incluirProcesso-descricao">Descrição</label>
                <textarea type="text" id="incluirProcesso-descricao" />
              </div>
              <div class="input-block" id='usuarioDiv'>
                <label for="incluirProcesso-usuarios" id='labelUsuario'>Usuários</label>
                <input type="text" id="incluirProcesso-usuarios" />
              </div>
              <div class="input-block" id='newUsuarioDiv'>
              </div>
              <button type="submit" class="btn-cadastrar" >Cadastrar</button>
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