import React from 'react';
import '../assets/css/Page.css';
import FormularioCadastro from '../components/FormularioCadastro';
import PossuiCadastro from '../components/PossuiCadastro';

class CadastroFinalizador extends React.Component {
  render() {
    return (
      <FormularioCadastro to='/loginfinalizador'
        children={
          <PossuiCadastro toLogin='/loginfinalizador' />
        }
      />
    )
  }
}

export default CadastroFinalizador;