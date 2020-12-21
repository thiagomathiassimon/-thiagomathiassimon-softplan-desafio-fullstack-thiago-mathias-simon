import React from 'react';
import '../assets/css/Page.css';
import FormularioLogin from '../components/FormularioLogin';

class LoginFinalizador extends React.Component {
  render() {
    return (
      <FormularioLogin to='/visualizarpendentes' toCadastro='/cadastrofinalizador' />
    )

  }
}

export default LoginFinalizador;