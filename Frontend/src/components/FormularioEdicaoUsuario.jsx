import React from 'react';
import { Field, Form, Formik } from "formik";
import { Grid } from '@material-ui/core'
import { Link } from 'react-router-dom'
import * as yup from 'yup';

const USUARIO_INICIAL = {
  nome: '',
  cpf: '',
  nivel: '',
  email: '',
  telefone: '',
  senha: ''
}

const UsuarioSchema = yup.object().shape({
  nome: yup.string().required('Informe o Título do processo'),
  cpf: yup.string().required('Informe o Subtítulo do processos'),
  nivel: yup.string().required('Informe o Descrição do processo'),
  email: yup.string().required('Informe o Usuário do processo'),
  telefone: yup.string().required('Informe o Parecer do processo'),
  senha: yup.string().required('Informe o Parecer do processo'),
})

export default class FormularioEdicaoUsuario extends React.Component {

  state = { teveAlteracao: false }

  salvarUsuario = (usuario, actions) => {
    actions.setSubmitting(true);
    this.props.salvar(usuario);
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
          <div class="form-wrapper">
            <Formik
              enableReinitialize
              validateOnMount={true}
              validationSchema={UsuarioSchema}
              initialValues={this.props.usuario || USUARIO_INICIAL}
              onSubmit={(values, actions) => {
                window.alert("Usuários adicionado no Banco de Dados")
                this.salvarUsuario(values, actions)
              }}
              render={({ values, touched, errors, isSubmitting, handleReset, setFieldTouched, setFieldValue }) => (
                <Form>
                  <div className="form-wrapper">
                    <div class="input-block">
                      <h2>EM EDIÇÃO</h2>
                      <table>
                        <thead>
                          <tr>
                            <th>Nome</th>
                            <th>CPF</th>
                            <th>Nível</th>
                            <th>E-mail</th>
                            <th>Telefone</th>
                            <th>Senha</th>
                          </tr>
                        </thead>
                        <tbody>
                          <tr>
                            <td>
                              <Field
                                className="input-formulario"
                                name="nome"
                              />
                              {touched.nome && errors.nome && <span className="erro-campo-formulario">{errors.nome}</span>}
                            </td>
                            <td>
                              <Field
                                className="input-formulario"
                                name="cpf"
                              />
                              {touched.cpf && errors.cpf && <span className="erro-campo-formulario">{errors.cpf}</span>}
                            </td>
                            <td>
                              <Field
                                className="input-formulario"
                                name="nivel"
                              />
                              {touched.nivel && errors.nivel && <span className="erro-campo-formulario">{errors.nivel}</span>}
                            </td>
                            <td>
                              <Field
                                className="input-formulario"
                                name="email"
                              />
                              {touched.email && errors.email && <span className="erro-campo-formulario">{errors.email}</span>}
                            </td>
                            <td>
                              <Field
                                className="incluirProcesso-usuario"
                                name="telefone"
                              />
                              {touched.telefone && <errors className="telefone"></errors> && <span className="erro-campo-formulario">{errors.telefone}</span>}
                            </td>
                            <td>
                              <Field
                                className="incluirProcesso-usuario"
                                name="senha"
                              />
                              {touched.senha && <errors className="senha"></errors> && <span className="erro-campo-formulario">{errors.senha}</span>}
                            </td>
                            <td><button className='btn-cadastrar'>Salvar</button></td>
                          </tr>
                        </tbody></table>
                    </div>
                  </div>
                </Form>

              )}
            />
          </div>
        </section >
      </>
    )
  }
}
