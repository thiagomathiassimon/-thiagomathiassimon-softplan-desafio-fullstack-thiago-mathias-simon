import React from 'react';
import '../assets/css/Page.css';
import FormularioLogin from '../components/FormularioLogin';

class LoginAdministrador extends React.Component {
  render() {
    return (
      <FormularioLogin to='/usuarios' toCadastro='/cadastroadministrador' />
    )
  }
}

export default LoginAdministrador;