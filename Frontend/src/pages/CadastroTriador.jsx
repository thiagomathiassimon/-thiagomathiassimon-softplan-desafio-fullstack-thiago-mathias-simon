import React from 'react';
import '../assets/css/Page.css';
import FormularioCadastro from '../components/FormularioCadastro';
import PossuiCadastro from '../components/PossuiCadastro';

class CadastroTriador extends React.Component {
  render() {
    return (
      <FormularioCadastro to='/logintriador'
        children={
          <PossuiCadastro toLogin='/logintriador' />
        } />
    )
  }
}

export default CadastroTriador;