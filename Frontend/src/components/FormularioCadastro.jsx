import React from 'react';
import { Field, Form, Formik } from "formik";
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

export default class FormularioCadastro extends React.Component {

  state = { teveAlteracao: false }

  salvarUsuario = (usuario, actions) => {
    actions.setSubmitting(true);
    this.props.salvar(usuario);
    actions.resetForm();
    actions.setSubmitting(false);
    this.setState({ teveAlteracao: false });
  }

  handleChange = (name, value, setFieldValue) => {
    this.setState({ teveAlteracao: true });
    setFieldValue(name, value);
  }

  render() {
    return (
      <>
        <section class="form-section">
          <h1>CADASTRO</h1>
          <Formik
            enableReinitialize
            validateOnMount={true}
            validationSchema={UsuarioSchema}
            initialValues={this.props.usuario || USUARIO_INICIAL}
            onSubmit={(values, actions) => {
              window.alert("Usuários adicionado no Banco de Dados")
              this.salvarUsuario(values, actions)
              window.history.go(-1);
            }}
            render={({ touched, errors }) => (
              <Form>
                <div className="form-wrapper">
                  <table>
                    <thead></thead>
                    <tbody>
                      <tr>
                        <td>
                          <div className="input-block">
                            <label>Nome:</label>
                            <Field
                              className="input-formulario"
                              name="nome"
                            />
                            <br />
                            {touched.nome && errors.nome && <span className="erro-campo-formulario">{errors.nome}</span>}
                          </div>
                        </td>
                        <td>
                          <div className="input-block">
                            <label>CPF:</label>
                            <Field
                              className="input-formulario"
                              name="cpf"
                            />
                            <br />
                            {touched.cpf && errors.cpf && <span className="erro-campo-formulario">{errors.cpf}</span>}
                          </div>
                        </td>
                      </tr>
                      <tr>
                        <td>
                          <div className="input-block">
                            <label>Nivel:</label>
                            <Field
                              className="input-formulario"
                              name="nivel"
                            />
                            <br />
                            {touched.nivel && errors.nivel && <span className="erro-campo-formulario">{errors.nivel}</span>}
                          </div>
                        </td>
                        <td>
                          <div className="input-block">
                            <label>Email:</label>
                            <Field
                              className="input-formulario"
                              name="email"
                            />
                            <br />
                            {touched.email && errors.email && <span className="erro-campo-formulario">{errors.email}</span>}
                          </div>
                        </td>
                      </tr>
                      <tr>
                        <td>
                          <div className="input-block">
                            <label>Telefone:</label>
                            <Field
                              className="input-formulario"
                              name="telefone"
                            />
                            <br />
                            {touched.telefone && errors.telefone && <span className="erro-campo-formulario">{errors.telefone}</span>}
                          </div>
                        </td>
                        <td>
                          <div className="input-block">
                            <label>Senha:</label>
                            <Field
                              className="incluirProcesso-usuario"
                              name="senha"
                            />
                            <br />
                            {touched.senha && <errors className="senha"></errors> && <span className="erro-campo-formulario">{errors.senha}</span>}
                          </div>
                        </td>
                      </tr>
                    </tbody>
                  </table>
                  <div className="botoes">
                    <button type="submit" class="btn-cadastrar">Cadastrar</button>
                    <br />
                  </div>
                </div>
              </Form>
            )}
          />
          {this.props.children}
          <Link to='/paginainicial'>
            <span>Escolheu a opção errada e quer voltar à Página Inicial?</span>
          </Link>
          <br />
        </section >
      </>
    )
  }
}