import React from 'react';
import { Field, Form, Formik } from "formik";
import { Link } from 'react-router-dom'
import * as yup from 'yup';

const PROCESSO_INICIAL = {
  titulo: '',
  subtitulo: '',
  descricao: '',
  usuario: '',
  parecer: ''
}

const ProcessoSchema = yup.object().shape({
  titulo: yup.string().required('Informe o Título do processo'),
  subtitulo: yup.string().required('Informe o Subtítulo do processos'),
  descricao: yup.string().required('Informe o Descrição do processo'),
  usuario: yup.string().required('Informe o Usuário do processo'),
  parecer: yup.string().required('Informe o Parecer do processo'),
})


export default class FormularioProcesso extends React.Component {

  state = { teveAlteracao: false }

  salvarProcesso = (filme, actions) => {
    actions.setSubmitting(true);
    this.props.salvar(filme);
    actions.resetForm();
    actions.setSubmitting(false);
    this.setState({ teveAlteracao: false })
  }

  handleChange = (name, value, setFieldValue) => {
    this.setState({ teveAlteracao: true });
    setFieldValue(name, value);
  }

  adicionarAtor = (ator, name, values, setFieldValue) => {
    const elenco = values[name];
    elenco.push(ator);
    setFieldValue(name, elenco);
  }


  render() {
    return (
      <>
        <section class="form-section">
          <h1>INCLUIR PROCESSO</h1>
          <Formik
            enableReinitialize
            validateOnMount={true}
            validationSchema={ProcessoSchema}
            initialValues={this.props.processo || PROCESSO_INICIAL}
            onSubmit={(values, actions) => {
              window.alert("Processo adicionado no Banco de Dados")
              window.history.go(-1);
              this.salvarProcesso(values, actions)
            }}
            render={({ values, touched, errors, isSubmitting, handleReset, setFieldTouched, setFieldValue }) => (
              <Form>
                <div className="form-wrapper">
                  <div className="input-block">
                    <label>Título:</label>
                    <Field
                      className="input-formulario"
                      name="titulo"
                    />
                    <br />
                    {touched.titulo && errors.titulo && <span className="erro-campo-formulario">{errors.titulo}</span>}
                  </div>
                  <div className="input-block">
                    <label>Subtitulo:</label>
                    <Field
                      className="input-formulario"
                      name="subtitulo"
                    />
                    <br />
                    {touched.subtitulo && errors.subtitulo && <span className="erro-campo-formulario">{errors.subtitulo}</span>}
                  </div>
                  <div className="input-block">
                    <label>Descrição:</label>
                    <Field
                      className="input-formulario"
                      name="descricao"
                    />
                    <br />
                    {touched.descricao && errors.descricao && <span className="erro-campo-formulario">{errors.descricao}</span>}
                  </div>
                  <div className="input-block">
                    <label>Usuario:</label>
                    <Field
                      className="input-formulario"
                      name="usuario"
                    />
                    <br />
                    {touched.usuario && errors.usuario && <span className="erro-campo-formulario">{errors.usuario}</span>}
                  </div>
                  <div className="input-block">
                    <label>Parecer:</label>
                    <Field
                      className="incluirProcesso-usuario"
                      name="parecer"
                    />
                    <br />
                    {touched.parecer && <errors className="parecer"></errors> && <span className="erro-campo-formulario">{errors.parecer}</span>}
                  </div>
                  <div className="botoes">
                    <button type="submit" class="btn-cadastrar" >
                      {this.props.btnTitle}
                    </button>
                  </div>
                </div>
                {/* <>
              <section class="form-section">
                <h1>INCLUIR PROCESSO</h1>
                <div class="form-wrapper">
                  <form action="">
                    <div class="input-block">
                      <label for="incluirProcesso-titulo">Título</label>
                      <input type="text" id="cadastro-nome" />
                      {touched.titulo && errors.titulo && <span className="erro-campo-formulario">{errors.titulo}</span>}
                    </div>
                    <div class="input-block">
                      <label for="incluirProcesso-subtitulo" value={this.state.subtitulo} onChange={this.alteraSubtitulo}>Subtítulo</label>
                      <input type="text" id="incluirProcesso-subtitulo" />
                      {touched.subtitulo && errors.subtitulo && <span className="erro-campo-formulario">{errors.subtitulo}</span>}
                    </div>
                    <div class="input-block">
                      <label for="incluirProcesso-descricao" value={this.state.descricao} onChange={this.alteraDescricao}>Descrição</label>
                      <textarea type="text" id="incluirProcesso-descricao" />
                      {touched.descricao && errors.descricao && <span className="erro-campo-formulario">{errors.descricao}</span>}
                    </div>
                    <div class="input-block" id='usuarioDiv'>
                      <label for="incluirProcesso-usuarios" id='labelUsuario' value={this.state.usuario} onChange={this.alteraUsuario}>Usuários</label>
                      <input type="text" id="incluirProcesso-usuarios" />
                      {touched.usuario && errors.usuario && <span className="erro-campo-formulario">{errors.usuario}</span>}
                    </div>
                    <div class="input-block" id='usuarioDiv'>
                      <label for="incluirProcesso-parecer" id='labelParecer' value={this.state.parecer} onChange={this.alteraParecer}>Parecer</label>
                      <input type="text" id="incluirProcesso-parecer" />
                      {touched.parecer && errors.parecer && <span className="erro-campo-formulario">{errors.parecer}</span>}
                    </div>
                    {this.props.children}
                    <button className="botao-formulario" onClick={() => { handleReset(PROCESSO_INICIAL) }}>Novo</button>
                    <Link to={this.props.btnTo}>
                      <button type="submit" class="btn-cadastrar">{this.props.btnTitle}</button>
                    </Link>
                  </form>
                  <Link to={this.props.toPagina}>
                    <span>Não era o que queria? Retorne às opções!</span>
                  </Link>
                </div>
              </section>
            </> */}
              </Form>
            )}
          />
          <Link to={this.props.toPagina}>
            <span>Não era o que queria? Retorne às opções!</span>
          </Link>
          <br />
        </section>
      </>
    )
  }
}
