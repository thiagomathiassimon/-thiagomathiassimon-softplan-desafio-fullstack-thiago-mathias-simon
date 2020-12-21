import React from 'react';
import '../assets/css/Page.css';
import FormularioCadastro from '../components/FormularioCadastro';
import PossuiCadastro from '../components/PossuiCadastro';

class CadastroAdministrador extends React.Component {
  render() {
    return (
      <FormularioCadastro to='/loginadministrador'
        children={
          <PossuiCadastro toLogin='/loginadministrador' />
        }
      />
    )
  }
}

export default CadastroAdministrador;