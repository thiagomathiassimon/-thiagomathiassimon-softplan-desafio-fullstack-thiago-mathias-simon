import React from 'react';
import '../assets/css/Page.css';
import FormularioLogin from '../components/FormularioLogin';

class LoginTriador extends React.Component {
  render() {
    return (
      <FormularioLogin to='/' toCadastro='/cadastrotriador' />
    )
  }
}

export default LoginTriador;