import React from 'react';
import '../assets/css/Page.css';
import FormularioCadastro from '../components/FormularioCadastro';

class CadastroTriador extends React.Component {
  render() {
    return (
      <FormularioCadastro to='/logintriador' toLogin='/logintriador' />
    )
  }
}

export default CadastroTriador;