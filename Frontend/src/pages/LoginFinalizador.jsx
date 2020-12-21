import React from 'react';
import '../assets/css/Page.css';
import FormularioLogin from '../components/FormularioLogin';

class LoginFinalizador extends React.Component {
  render() {
    return (
      <FormularioLogin to='/cadastrofinalizador' toCadastro='/cadastrofinalizador' />
    )

  }
}

export default LoginFinalizador;