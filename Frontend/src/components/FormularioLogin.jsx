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
      console.log(values)

      axios.post('http://localhost:8080/RESTDesafioSoftplanThiagoMathiasSimon/api/login', values)
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
    }


    const validations = yup.object().shape({
      email: yup.string().email().required(),
      senha: yup.string().required()
    })

    return (
      <>
        {/* <section class="form-section"> */}
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
                <label for="login-email">E-mail</label>
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
            <button type="submit" class="btn-login" onClick={handleSubmit}>Login</button>
            <Link to={this.props.to}>
              <button className="btn-login" >Próxima página</button>
            </Link>
          </Form>

        </Formik>
        {/* <div class="form-wrapper">
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
          </div> */}
        {/* </section> */}
      </>
    )
  }
}