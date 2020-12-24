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
            render={({ touched, errors }) => (
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
