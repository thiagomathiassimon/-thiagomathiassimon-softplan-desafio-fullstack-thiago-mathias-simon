import React from 'react';
import '../assets/css/Page.css';
import FormularioCadastro from '../components/FormularioCadastro';

class CadastroAdministrador extends React.Component {
  render() {
    return (
      <FormularioCadastro to='/loginadministrador' toLogin='/loginadministrador' />
    )
  }
}

export default CadastroAdministrador;