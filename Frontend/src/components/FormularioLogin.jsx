import React from 'react';
import '../assets/css/Page.css';
import { ErrorMessage, Formik, Form, Field } from 'formik'
import { Link } from 'react-router-dom'
import * as yup from 'yup'
import axios from 'axios'
import { history } from '../history'

export default class FormularioLogin extends React.Component {
  render() {

    const handleSubmit = values => {
      console.log("AQUI OS VALORES", values)
      return axios.post('http://localhost:8080/RESTDesafioSoftplanThiagoMathiasSimon/api/login', values)
        .then(resp => {
          console.log("passou na requisição")
          const { data } = resp
          console.log(data.token)
          if (data.token) {
            console.log("no localStorage")
            localStorage.setItem('token', data.token)
            history.push('/')
          }
        })
        .catch(erro => {
          window.alert("Um erro ocorreu! Senha ou Email incorretos!")
          window.location.reload();
          console.log(erro)
          //Retorne se a promise dá false
        })
    }

    const validations = yup.object().shape({
      email: yup.string().email().required(),
      senha: yup.string().required()
    })
    return (
      <>
        <section>
          <h1>LOGIN</h1>
          <Formik
            initialValues={{
              email: "",
              senha: ""
            }}
            onSubmit={handleSubmit}
            validationSchema={validations}
          >
            <Form className="Login">
              <div className="Login-Group">
                <div class="input-block">
                  <label for="login-email">E-mail:</label>
                  <Field
                    name="email"
                    className="Login-Field"
                  />
                </div>
                <ErrorMessage
                  component="span"
                  name="email"
                  className="Login-Error"
                />
              </div>
              <div className="Login-Group">
                <div class="input-block">
                  <label for="login-email">Senha:</label>
                  <Field
                    name="senha"
                    className="Login-Field"
                  />
                </div>
                <ErrorMessage
                  component="span"
                  name="senha"
                  className="Login-Error"
                />
              </div>
              <button type="submit" class="btn-mais">Login</button>
              <label> </label>
              <Link to={this.props.to}>
                <button className="btn-mais" >Próxima página</button>
              </Link>
            </Form>
          </Formik>
          <Link to={this.props.toCadastro} >
            Não possui cadastro? Faça-o aqui!
          </Link>
          <br />
          <Link to="/paginainicial">
            <span>Não era o que queria? Retorne às opções!</span>
          </Link>
        </section>
      </>
    )
  }
}