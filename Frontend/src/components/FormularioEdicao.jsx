import React from 'react';
import { Field, Form, Formik } from "formik";
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

export default class FormularioEdicao extends React.Component {

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
          <Formik
            enableReinitialize
            validateOnMount={true}
            validationSchema={ProcessoSchema}
            initialValues={this.props.processo || PROCESSO_INICIAL}
            onSubmit={(values, actions) => {
              window.alert("Processo adicionado no Banco de Dados")
              this.salvarProcesso(values, actions)
            }}
            render={({ touched, errors }) => (
              <Form className="Edicao">
                <div class="input-block">
                  <h2>EM EDIÇÃO</h2>
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
                      <tr>
                        <td>
                          <Field
                            className="input-formulario"
                            name="titulo"
                          />
                          {touched.titulo && errors.titulo && <span className="erro-campo-formulario">{errors.titulo}</span>}
                        </td>
                        <td>
                          <Field
                            className="input-formulario"
                            name="subtitulo"
                          />
                          {touched.subtitulo && errors.subtitulo && <span className="erro-campo-formulario">{errors.subtitulo}</span>}
                        </td>
                        <td>
                          <Field
                            className="input-formulario"
                            name="descricao"
                          />
                          {touched.descricao && errors.descricao && <span className="erro-campo-formulario">{errors.descricao}</span>}
                        </td>
                        <td>
                          <Field
                            className="input-formulario"
                            name="usuario"
                          />
                          {touched.usuario && errors.usuario && <span className="erro-campo-formulario">{errors.usuario}</span>}
                        </td>
                        <td>
                          <Field
                            className="incluirProcesso-usuario"
                            name="parecer"
                          />
                          {touched.parecer && <errors className="parecer"></errors> && <span className="erro-campo-formulario">{errors.parecer}</span>}
                        </td>
                        <td><button className='btn-cadastrar'>Salvar</button></td>
                      </tr>
                    </tbody></table>
                </div>
              </Form>
            )}
          />
        </section>
      </>
    )
  }
}
